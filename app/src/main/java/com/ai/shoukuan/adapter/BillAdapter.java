package com.ai.shoukuan.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ai.shoukuan.BR;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillViewHolder> {

    public List<BindingAdapterItem> getItems() {
        return items;
    }

    public void setItems(List<BindingAdapterItem> items) {
        this.items = items;
    }
    List<BindingAdapterItem> items = new ArrayList<>();

    /**
     * @return 返回的是adapter的view
     */
    @Override
    public BillAdapter.BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new BillAdapter.BillViewHolder(binding);
    }
    /*
     * 数据绑定
     * */
    @Override
    public void onBindViewHolder(BillAdapter.BillViewHolder holder, int position) {
        holder.bindData(items.get(position));
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    @Override
    public int getItemViewType(int position) {
        return items.get(position).getViewType();
    }

    static class BillViewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding binding;
        /**
         * @param binding   可以看作是这个hodler代表的布局的马甲，getRoot()方法会返回整个holder的最顶层的view
         * */
        public BillViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(BindingAdapterItem item) {
//            binding.setVariable(BR.item,item);
        }

    }
}
