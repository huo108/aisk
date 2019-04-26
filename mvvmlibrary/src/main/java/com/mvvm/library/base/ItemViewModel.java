package com.mvvm.library.base;

import android.support.annotation.NonNull;

/**
 * ItemViewModel
 */

public class ItemViewModel<VM extends BaseViewModel> {
    protected VM viewModel;

    public ItemViewModel(@NonNull VM viewModel) {
        this.viewModel = viewModel;
    }
}
