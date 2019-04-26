package com.ai.shoukuan.ui.history;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.ai.shoukuan.R;
import com.ai.shoukuan.adapter.BillAdapter;
import com.ai.shoukuan.adapter.BindingAdapterItem;
import com.ai.shoukuan.bean.BillBean;
import com.ai.shoukuan.databinding.ActivityBillHistoryBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillHistoryActivity extends Activity {
    private ActivityBillHistoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bill_history);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<BindingAdapterItem> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BillBean billBean = new BillBean();
            billBean.setType("收款");
            billBean.setSource("来源:微信收款");
            billBean.setTime(sdf.format(new Date()));
            billBean.setMoney("+50000");
            items.add(billBean);
        }
        BillAdapter adapter = new BillAdapter();
        adapter.setItems(items);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        binding.billRecycler.setLayoutManager(manager);
        binding.billRecycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
