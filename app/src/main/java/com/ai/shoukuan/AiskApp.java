package com.ai.shoukuan;

import com.ai.shoukuan.bean.LoginBean;
import com.ai.shoukuan.factory.AppViewModelFactory;
import com.ai.shoukuan.http.ApiService;
import com.ai.shoukuan.http.RetrofitClient;
import com.ai.shoukuan.http.source.impl.HttpDataSourceImpl;
import com.ai.shoukuan.ui.login.LoginActivity;

import com.ai.shoukuan.ui.user.UserActivity;
import com.ai.shoukuan.utils.MD5Util;
import com.mvvm.library.base.BaseApplication;
import com.mvvm.library.crash.CaocConfig;
import com.mvvm.library.utils.KLog;
import com.mvvm.library.utils.RxUtils;
import com.mvvm.library.utils.ToastUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class AiskApp extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        forCookie();
        //是否开启日志打印
        KLog.init(true);
        //配置全局异常崩溃操作
        CaocConfig.Builder.create()
//                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
//                .enabled(true) //是否启动全局异常捕获
//                .showErrorDetails(true) //是否显示错误详细信息
//                .showRestartButton(true) //是否显示重启按钮
//                .trackActivities(true) //是否跟踪Activity
//                .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
//                .errorDrawable(R.drawable.ic_launcher) //错误图标
//                .restartActivity(LoginActivity.class) //重新启动后的activity
                //.errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
                //.eventListener(new YourCustomEventListener()) //崩溃后的错误监听
                .apply();
    }

    //为了获得验证码图片cookie，模拟登录一次
    private void forCookie() {
        HttpDataSourceImpl.getInstance(RetrofitClient.getInstance().create(ApiService.class)).login("username", MD5Util.MD5("password").toUpperCase(),"VERI")
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                    }
                })
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean o) throws Exception {
                    }
                });
    }
}
