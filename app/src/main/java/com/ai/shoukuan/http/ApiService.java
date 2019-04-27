package com.ai.shoukuan.http;


import com.ai.shoukuan.bean.DemoEntity;
import com.ai.shoukuan.bean.LoginBean;
import com.mvvm.library.http.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("AppAuthentication/login.action")
    Observable<LoginBean> login(@Field("username") String username, @Field("password") String password, @Field("verifyCode") String verifyCode);

    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<DemoEntity>> demoGet();

    @FormUrlEncoded
    @POST("action/apiv2/banner")
    Observable<BaseResponse<DemoEntity>> demoPost(@Field("catalog") String catalog);
}
