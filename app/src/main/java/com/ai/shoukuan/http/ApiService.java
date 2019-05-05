package com.ai.shoukuan.http;


import com.ai.shoukuan.bean.DemoEntity;
import com.ai.shoukuan.bean.LoginBean;
import com.ai.shoukuan.bean.UploadResult;
import com.mvvm.library.http.BaseResponse;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiService {

    @GET("AppAuthentication/login.action")
    Observable<LoginBean> login(@Query("username") String username, @Query("password") String password, @Query("verifyCode") String verifyCode);

    @GET("member/register.action")
    Observable<LoginBean> register(@Query("userName") String username, @Query("password") String password);

    @GET("AppAuthentication/verifyCode.action")
    Observable<Object> verifyCode();

    @Multipart
    @POST("/common/FilesUpload!upload.action")
    Call<UploadResult> upload(@Part MultipartBody.Part file);

    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<DemoEntity>> demoGet();

    @FormUrlEncoded
    @POST("action/apiv2/banner")
    Observable<BaseResponse<DemoEntity>> demoPost(@Field("catalog") String catalog);
}
