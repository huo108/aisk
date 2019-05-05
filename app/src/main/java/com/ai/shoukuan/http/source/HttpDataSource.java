package com.ai.shoukuan.http.source;

import com.ai.shoukuan.bean.DemoEntity;
import com.ai.shoukuan.bean.LoginBean;
import com.ai.shoukuan.bean.UploadResult;
import com.mvvm.library.http.BaseResponse;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface HttpDataSource {
    //模拟登录
    Observable<LoginBean> login(String userName, String password, String verifyCode);

    Observable<Object> verifyCode();

    Observable<LoginBean> register(String userName, String password);

    Observable<UploadResult> upload(@Part MultipartBody.Part file);

    Observable<BaseResponse<DemoEntity>> demoGet();

    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);

    //模拟上拉加载
    Observable<DemoEntity> loadMore();
}
