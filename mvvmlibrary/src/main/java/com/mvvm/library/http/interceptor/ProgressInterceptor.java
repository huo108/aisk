package com.mvvm.library.http.interceptor;

import java.io.IOException;

import com.mvvm.library.http.download.ProgressResponseBody;
import okhttp3.Interceptor;
import okhttp3.Response;



public class ProgressInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .body(new ProgressResponseBody(originalResponse.body()))
                .build();
    }
}
