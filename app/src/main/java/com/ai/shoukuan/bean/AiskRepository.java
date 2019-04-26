package com.ai.shoukuan.bean;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.ai.shoukuan.http.source.HttpDataSource;
import com.ai.shoukuan.http.source.LocalDataSource;

import io.reactivex.Observable;
import com.mvvm.library.base.BaseModel;

/**
 * MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 */
public class AiskRepository extends BaseModel implements HttpDataSource, LocalDataSource {
    private volatile static AiskRepository INSTANCE = null;
    private final HttpDataSource mHttpDataSource;

    private final LocalDataSource mLocalDataSource;

    private AiskRepository(@NonNull HttpDataSource httpDataSource,
                           @NonNull LocalDataSource localDataSource) {
        this.mHttpDataSource = httpDataSource;
        this.mLocalDataSource = localDataSource;
    }

    public static AiskRepository getInstance(HttpDataSource httpDataSource,
                                             LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (AiskRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AiskRepository(httpDataSource, localDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public Observable<Object> login() {
        return mHttpDataSource.login();
    }


    @Override
    public void saveUserName(String userName) {
        mLocalDataSource.saveUserName(userName);
    }

    @Override
    public void savePassword(String password) {
        mLocalDataSource.savePassword(password);
    }

    @Override
    public String getUserName() {
        return mLocalDataSource.getUserName();
    }

    @Override
    public String getPassword() {
        return mLocalDataSource.getPassword();
    }
}
