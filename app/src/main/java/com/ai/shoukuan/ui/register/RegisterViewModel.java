package com.ai.shoukuan.ui.register;

import android.app.Application;
import android.support.annotation.NonNull;

import com.ai.shoukuan.bean.AiskRepository;
import com.mvvm.library.base.BaseViewModel;

/**
 * Created by wumh on 2019/4/26
 **/
public class RegisterViewModel extends BaseViewModel<AiskRepository> {

    public RegisterViewModel(@NonNull Application application, AiskRepository model) {
        super(application, model);
    }

}
