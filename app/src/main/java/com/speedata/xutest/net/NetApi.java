package com.speedata.xutest.net;


import com.speedata.xutest.add.AddResultEntity;
import com.speedata.xutest.base.AppFid;
import com.speedata.xutest.inventory.InventoryResultEntity;
import com.speedata.xutest.login.LoginEntity;
import com.speedata.xutest.main.assets.AssetsEntity;
import com.speedata.xutest.main.inventory.CheckListEntity;
import com.speedata.xutest.main.sync.entity.AssetsLocationEntity;
import com.speedata.xutest.main.sync.entity.CateEntity;
import com.speedata.xutest.main.sync.entity.DeptEntity;
import com.speedata.xutest.main.sync.entity.StatusEntity;
import com.speedata.xutest.main.sync.entity.SupplierEntity;
import com.speedata.xutest.main.sync.entity.UserEntity;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author :Reginer in  2017/9/7 23:19.
 *         联系方式:QQ:282921012
 *         功能描述:请求
 */
public class NetApi {
    private NetApiService service;

    private NetApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(NetApiService.class);
    }

    private static class NetApiHolder {
        private static final NetApi instance = new NetApi(getOkHttpClient());
    }

    /**
     * getInstance .
     *
     * @return NetApi
     */
    public static NetApi getInstance() {
        return NetApiHolder.instance;
    }

    private static OkHttpClient getOkHttpClient() {
        Cache cache = new Cache(new File(AppFid.getInstance().getCacheDir(), "HttpCache"),
                1024 * 1024 * 100);
        OkHttpClient.Builder builder = new OkHttpClient.Builder().cache(cache).connectTimeout(6, TimeUnit.SECONDS)
                .connectTimeout(6 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(6 * 1000, TimeUnit.MILLISECONDS)
//                .addInterceptor(new LogInterceptor())
                .retryOnConnectionFailure(true);
        return builder.build();
    }

    public Observable<LoginEntity> doLogin(String requestJson) {
        return service.doLogin(requestJson);
    }

    public Observable<AssetsEntity> getEquipmentList(String requestJson) {
        return service.getEquipmentList(requestJson);
    }

    public Observable<StatusEntity> getStatusList(String requestJson) {
        return service.getStatusList(requestJson);
    }

    public Observable<UserEntity> getUserList(String requestJson) {
        return service.getUserList(requestJson);
    }

    public Observable<AssetsLocationEntity> getProList(String requestJson) {
        return service.getProList(requestJson);
    }

    public Observable<CateEntity> getCateList(String requestJson) {
        return service.getCateList(requestJson);
    }

    public Observable<CheckListEntity> getCheckListBean(String requestJson) {
        return service.getCheckListBean(requestJson);
    }

    public Observable<SupplierEntity> getSupplierList(String requestJson) {
        return service.getSupplierList(requestJson);
    }

    public Observable<DeptEntity> getDeptList(String requestJson) {
        return service.getDeptList(requestJson);
    }

    public Observable<AddResultEntity> uploadEquipment(String requestJson) {
        return service.uploadEquipment(requestJson);
    }

    public Observable<InventoryResultEntity> uploadRptChkInfo(String requestJson) {
        return service.uploadRptChkInfo(requestJson);
    }
}
