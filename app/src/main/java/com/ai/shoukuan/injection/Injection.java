package com.ai.shoukuan.injection;

import com.ai.shoukuan.bean.AiskRepository;
import com.ai.shoukuan.http.source.HttpDataSource;
import com.ai.shoukuan.http.source.LocalDataSource;
import com.ai.shoukuan.http.ApiService;
import com.ai.shoukuan.http.RetrofitClient;
import com.ai.shoukuan.http.source.impl.HttpDataSourceImpl;
import com.ai.shoukuan.http.source.impl.LocalDataSourceImpl;


/**
 * 注入全局的数据仓库
 */
public class Injection {
    public static AiskRepository provideRepository() {
        //网络API服务
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        //网络数据源
        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance(apiService);
        //本地数据源
        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return AiskRepository.getInstance(httpDataSource, localDataSource);
    }
}
