package com.ai.shoukuan.http.source;

import io.reactivex.Observable;

public interface HttpDataSource {
    //模拟登录
    Observable<Object> login();
    Observable<Object> register();

}
