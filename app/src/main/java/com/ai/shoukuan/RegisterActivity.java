package com.ai.shoukuan;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ai.shoukuan.databinding.ActivityRegisterBinding;

public class RegisterActivity extends Activity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setClk(new Click());
    }

    public class Click {
        public void clickRegister() {
        }
    }
}

