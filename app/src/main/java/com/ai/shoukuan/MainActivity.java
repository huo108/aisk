package com.ai.shoukuan;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.ai.shoukuan.bean.RechargeExplainBean;
import com.ai.shoukuan.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClk(new Click());
    }

    public class Click {
        public void clickLogin() {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        public void qucode() {
            Intent intent = new Intent(MainActivity.this, QRCodeActivity.class);
            startActivity(intent);
        }

        public void recharge() {
            Intent intent = new Intent(MainActivity.this, RechargeActivity.class);
            startActivity(intent);
        }

        public void historyBill() {
            Intent intent = new Intent(MainActivity.this, BillHistoryActivity.class);
            startActivity(intent);
        }

        public void logout() {

        }
    }
}
