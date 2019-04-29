package com.ai.shoukuan.http;


import com.ai.shoukuan.bean.DemoEntity;
import com.ai.shoukuan.bean.LoginBean;
import com.mvvm.library.http.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET("AppAuthentication/login.action")
    Observable<LoginBean> login(@Query("username") String username, @Query("password") String password, @Query("verifyCode") String verifyCode);

    @GET("MemberAction/register.action")
    Observable<Object> register(@Query("username") String username, @Query("password") String password);

    @GET("AppAuthentication/verifyCode.action")
    Observable<Object> verifyCode();


    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<DemoEntity>> demoGet();

    @FormUrlEncoded
    @POST("action/apiv2/banner")
    Observable<BaseResponse<DemoEntity>> demoPost(@Field("catalog") String catalog);
}
