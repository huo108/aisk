package com.ai.shoukuan.ui.user;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.ai.shoukuan.BR;
import com.ai.shoukuan.R;
import com.ai.shoukuan.factory.AppViewModelFactory;
import com.ai.shoukuan.ui.recharge.RechargeActivity;
import com.ai.shoukuan.databinding.ActivityUserBinding;
import com.ai.shoukuan.ui.history.BillHistoryActivity;
import com.ai.shoukuan.ui.login.LoginActivity;
import com.ai.shoukuan.ui.qrcode.QRCodeActivity;
import com.mvvm.library.base.BaseActivity;

public class UserActivity extends BaseActivity<ActivityUserBinding, UserViewModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_user;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public UserViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(UserViewModel.class);
    }

}
