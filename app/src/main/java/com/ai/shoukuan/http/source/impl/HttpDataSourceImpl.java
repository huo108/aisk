package com.ai.shoukuan.http.source.impl;

import com.ai.shoukuan.http.source.HttpDataSource;
import com.ai.shoukuan.http.ApiService;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class HttpDataSourceImpl implements HttpDataSource {
    private ApiService apiService;
    private volatile static HttpDataSourceImpl INSTANCE = null;

    public static HttpDataSourceImpl getInstance(ApiService apiService) {
        if (INSTANCE == null) {
            synchronized (HttpDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataSourceImpl(apiService);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private HttpDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<Object> login() {
        return Observable.just(new Object()).delay(3, TimeUnit.SECONDS); //延迟3秒
    }

//    @Override
//    public Observable<DemoEntity> loadMore() {
//        return Observable.create(new ObservableOnSubscribe<DemoEntity>() {
//            @Override
//            public void subscribe(ObservableEmitter<DemoEntity> observableEmitter) throws Exception {
//                DemoEntity entity = new DemoEntity();
//                List<DemoEntity.ItemsEntity> itemsEntities = new ArrayList<>();
//                //模拟一部分假数据
//                for (int i = 0; i < 10; i++) {
//                    DemoEntity.ItemsEntity item = new DemoEntity.ItemsEntity();
//                    item.setId(-1);
//                    item.setName("模拟条目");
//                    itemsEntities.add(item);
//                }
//                entity.setItems(itemsEntities);
//                observableEmitter.onNext(entity);
//            }
//        }).delay(3, TimeUnit.SECONDS); //延迟3秒
//    }
//
//    @Override
//    public Observable<BaseResponse<DemoEntity>> demoGet() {
//        return apiService.demoGet();
//    }
//
//    @Override
//    public Observable<BaseResponse<DemoEntity>> demoPost(String catalog) {
//        return apiService.demoPost(catalog);
//    }
}
