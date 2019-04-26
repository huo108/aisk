package com.mvvm.library.binding.viewadapter.viewgroup;


import android.databinding.ViewDataBinding;

public interface IBindingItemViewModel<V extends ViewDataBinding> {
    void injecDataBinding(V binding);
}
