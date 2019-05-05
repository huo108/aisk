package com.ai.shoukuan.ui.login;

import android.app.Application;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.ai.shoukuan.bean.LoginBean;
import com.ai.shoukuan.http.RetrofitClient;
import com.ai.shoukuan.ui.register.RegisterActivity;
import com.ai.shoukuan.ui.user.UserActivity;
import com.ai.shoukuan.bean.AiskRepository;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import com.ai.shoukuan.utils.MD5Util;
import com.mvvm.library.base.BaseViewModel;
import com.mvvm.library.binding.command.BindingAction;
import com.mvvm.library.binding.command.BindingCommand;
import com.mvvm.library.binding.command.BindingConsumer;
import com.mvvm.library.bus.event.SingleLiveEvent;
import com.mvvm.library.utils.RxUtils;
import com.mvvm.library.utils.ToastUtils;

public class LoginViewModel extends BaseViewModel<AiskRepository> {
    public String imgUrl = RetrofitClient.baseUrl + "/AppAuthentication/verifyCode.action";

    //用户名的绑定
    public ObservableField<String> userName = new ObservableField<>("");
    //密码的绑定
    public ObservableField<String> password = new ObservableField<>("");
    //验证码
    public ObservableField<String> verifyCode = new ObservableField<>("");
    //用户名清除按钮的显示隐藏绑定
    public ObservableInt clearBtnVisibility = new ObservableInt();
    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        //密码开关观察者
        public SingleLiveEvent<Boolean> pSwitchEvent = new SingleLiveEvent<>();
    }

    @Override
    public void onStart() {
        super.onStart();
//        verifyCode();
    }

    private void verifyCode() {

        addSubscribe(model.verifyCode()
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        showDialog();
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        ToastUtils.showLong("userName:" + userName.get() + " passWord:" + password.get());
                    }
                }));
    }

    public LoginViewModel(@NonNull Application application, AiskRepository repository) {
        super(application, repository);
        //从本地取得数据绑定到View层
        userName.set(model.getUserName());
        password.set(model.getPassword());
    }

    //清除用户名的点击事件, 逻辑从View层转换到ViewModel层
    public BindingCommand clearUserNameOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            userName.set("");
        }
    });
    //密码显示开关  (你可以尝试着狂按这个按钮,会发现它有防多次点击的功能)
    public BindingCommand passwordShowSwitchOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //让观察者的数据改变,逻辑从ViewModel层转到View层，在View层的监听则会被调用
            uc.pSwitchEvent.setValue(uc.pSwitchEvent.getValue() == null || !uc.pSwitchEvent.getValue());
        }
    });
    //用户名输入框焦点改变的回调事件
    public BindingCommand<Boolean> onFocusChangeCommand = new BindingCommand<>(new BindingConsumer<Boolean>() {
        @Override
        public void call(Boolean hasFocus) {
            if (hasFocus) {
                clearBtnVisibility.set(View.VISIBLE);
            } else {
                clearBtnVisibility.set(View.INVISIBLE);
            }
        }
    });
    //登录按钮的点击事件
    public BindingCommand loginOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            login();
        }
    });

    //登录按钮的点击事件
    public BindingCommand registerOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(RegisterActivity.class);
        }
    });

    /**
     * 网络模拟一个登陆操作
     **/
    private void login() {
        if (TextUtils.isEmpty(userName.get())) {
            ToastUtils.showShort("请输入账号！");
            return;
        }
        if (TextUtils.isEmpty(password.get())) {
            ToastUtils.showShort("请输入密码！");
            return;
        }
        if (TextUtils.isEmpty(verifyCode.get())) {
            ToastUtils.showShort("请输入验证码！");
            return;
        }
        //RaJava模拟登录
        addSubscribe(model.login(userName.get(), MD5Util.MD5(password.get()).toUpperCase(), verifyCode.get())
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        showDialog();
                    }
                })
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean o) throws Exception {
                        ToastUtils.showLong("userName:" + userName.get() + " passWord:" + password.get());
                        dismissDialog();
                        //保存账号密码
                        model.saveUserName(userName.get());
                        model.savePassword(password.get());
                        //进入UserActivity页面
                        startActivity(UserActivity.class);
                        //关闭页面
                        finish();
                    }
                }));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
