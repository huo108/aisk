package com.ai.shoukuan.ui.user;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.ai.shoukuan.R;
import com.ai.shoukuan.ui.recharge.RechargeActivity;
import com.ai.shoukuan.databinding.ActivityUserBinding;
import com.ai.shoukuan.ui.history.BillHistoryActivity;
import com.ai.shoukuan.ui.login.LoginActivity;
import com.ai.shoukuan.ui.qrcode.QRCodeActivity;

public class UserActivity extends Activity {

    private ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user);
//        binding.setClk(new Click());
    }

    public class Click {
        public void clickLogin() {
            Intent intent = new Intent(UserActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        public void qucode() {
            Intent intent = new Intent(UserActivity.this, QRCodeActivity.class);
            startActivity(intent);
        }

        public void recharge() {
            Intent intent = new Intent(UserActivity.this, RechargeActivity.class);
            startActivity(intent);
        }

        public void historyBill() {
            Intent intent = new Intent(UserActivity.this, BillHistoryActivity.class);
            startActivity(intent);
        }

        public void logout() {

        }
    }
}
