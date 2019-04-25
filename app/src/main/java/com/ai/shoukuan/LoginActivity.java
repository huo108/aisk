package com.ai.shoukuan;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.ai.shoukuan.bean.UserBean;
import com.ai.shoukuan.databinding.ActivityLoginBinding;

public class LoginActivity extends Activity {

    private ActivityLoginBinding binding;
    private UserBean mUserBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setClk(new Click());
        mUserBean = new UserBean();
        mUserBean.setUserName("hello");
        mUserBean.setPassword("world");
        binding.setUser(mUserBean);
    }

    public class Click {
        public void clickLogin() {
            Toast.makeText(LoginActivity.this,"userName:"+ mUserBean.getUserName()+" passWord:"+ mUserBean.getPassword(),Toast.LENGTH_LONG).show();
        }

        public void clickRegister() {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
    }

}
