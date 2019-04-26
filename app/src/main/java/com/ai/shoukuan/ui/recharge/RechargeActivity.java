package com.ai.shoukuan.ui.recharge;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.ai.shoukuan.R;
import com.ai.shoukuan.bean.RechargeExplainBean;
import com.ai.shoukuan.databinding.ActivityRechargeBinding;


public class RechargeActivity extends Activity {

    private ActivityRechargeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recharge);
        RechargeExplainBean rechargeExplainBean = new RechargeExplainBean();
        rechargeExplainBean.setExplain(getResources().getString(R.string.rechare_title));
        rechargeExplainBean.setExplainDetail(getResources().getString(R.string.rechare_explain_detail));
        binding.setRechargeExplain(rechargeExplainBean);
    }

}
