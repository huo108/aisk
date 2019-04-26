package com.ai.shoukuan.ui.register;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.ai.shoukuan.R;
import com.ai.shoukuan.bean.UserBean;
import com.ai.shoukuan.databinding.ActivityRegisterBinding;

public class RegisterActivity extends Activity {

    private ActivityRegisterBinding binding;
    private UserBean mUserBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
//        binding.setClk(new Click());
        mUserBean = new UserBean();
        mUserBean.setUserName("hello");
        mUserBean.setPassword("world");
        mUserBean.setEnsurePassword("ddd");
        binding.setUser(mUserBean);
    }

    public class Click {
        public void clickRegister() {
            Toast.makeText(RegisterActivity.this, "userName:" + mUserBean.getUserName() + " passWord:" + mUserBean.getPassword() + " and:" + mUserBean.getEnsurePassword(), Toast.LENGTH_LONG).show();
        }
    }
}

