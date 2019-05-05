package com.ai.shoukuan.ui.recharge;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.ai.shoukuan.R;
import com.ai.shoukuan.bean.RechargeExplainBean;
import com.ai.shoukuan.databinding.ActivityRechargeBinding;


public class RechargeActivity extends Activity implements View.OnClickListener {

    private ActivityRechargeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recharge);
        RechargeExplainBean rechargeExplainBean = new RechargeExplainBean();
        rechargeExplainBean.setExplain(getResources().getString(R.string.rechare_title));
        rechargeExplainBean.setExplainDetail(getResources().getString(R.string.rechare_explain_detail));
        binding.setRechargeExplain(rechargeExplainBean);
        binding.include.back.setOnClickListener(this);
        binding.include.text.setText(getResources().getText(R.string.rechare_title));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
