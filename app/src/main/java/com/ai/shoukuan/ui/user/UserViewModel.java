package com.ai.shoukuan.ui.user;

import android.app.Application;
import android.support.annotation.NonNull;

import com.ai.shoukuan.bean.AiskRepository;
import com.ai.shoukuan.ui.history.BillHistoryActivity;
import com.ai.shoukuan.ui.qrcode.QRCodeActivity;
import com.ai.shoukuan.ui.recharge.RechargeActivity;
import com.mvvm.library.base.BaseViewModel;
import com.mvvm.library.binding.command.BindingAction;
import com.mvvm.library.binding.command.BindingCommand;

public class UserViewModel extends BaseViewModel<AiskRepository> {

    public UserViewModel(@NonNull Application application, AiskRepository model) {
        super(application, model);
    }

    public BindingCommand qrCodeOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(QRCodeActivity.class);
        }
    });

    public BindingCommand historyOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(BillHistoryActivity.class);
        }
    });

    public BindingCommand rechargeClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(RechargeActivity.class);
        }
    });

    public BindingCommand logoutOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
        }
    });
}
