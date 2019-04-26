package com.ai.shoukuan.ui.qrcode;

import android.app.Application;
import android.support.annotation.NonNull;

import com.ai.shoukuan.bean.AiskRepository;
import com.mvvm.library.base.BaseViewModel;
import com.mvvm.library.binding.command.BindingAction;
import com.mvvm.library.binding.command.BindingCommand;

public class QRCodeViewModel extends BaseViewModel<AiskRepository> {

    public QRCodeViewModel(@NonNull Application application, AiskRepository model) {
        super(application, model);
    }

    public BindingCommand qrCodeOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });
}
