package com.ai.shoukuan.http.source;

import com.ai.shoukuan.bean.DemoEntity;
import com.ai.shoukuan.bean.LoginBean;
import com.mvvm.library.http.BaseResponse;

import io.reactivex.Observable;

public interface HttpDataSource {
    //模拟登录
    Observable<LoginBean> login(String userName, String password, String verifyCode);
    Observable<Object> register();
    Observable<BaseResponse<DemoEntity>> demoGet();
    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);
    //模拟上拉加载
    Observable<DemoEntity> loadMore();
}
