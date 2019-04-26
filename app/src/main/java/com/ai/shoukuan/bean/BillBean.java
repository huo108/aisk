package com.ai.shoukuan.bean;

import android.databinding.BaseObservable;

import com.ai.shoukuan.R;
import com.ai.shoukuan.adapter.BindingAdapterItem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BillBean extends BaseObservable implements BindingAdapterItem {
    private String type;
    private String source;
    private String time;
    private String money;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public int getViewType() {
        return R.layout.item_bill;
    }
}
