package com.speedata.xutest.cache;

import android.text.TextUtils;

import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author :Reginer in  2017/9/8 11:51.
 *         联系方式:QQ:282921012
 *         功能描述:缓存操作
 */
public class CacheManager {
    /**
     * 创建缓存键.
     *
     * @param param params
     * @return key
     */
    public static String createCacheKey(Object... param) {
        StringBuilder key = new StringBuilder();
        for (Object o : param) {
            key.append("-").append(o);
        }
        return key.toString().replaceFirst("-", "");
    }

    /**
     * 缓存内容到key 。
     *
     * @param key key
     * @param <T> bean
     * @return T
     */
    public static <T> ObservableTransformer<T, T> createCache(String key) {
//        return new ObservableTransformer<T, T>() {
//            @Override
//            public ObservableSource<T> apply(Observable<T> observable) {
//                return observable.subscribeOn(Schedulers.io()).doOnNext(new Consumer<T>() {
//                    @Override
//                    public void accept(T data) throws Exception {
//                        Schedulers.io().createWorker().schedule(new Runnable() {
//                            @Override
//                            public void run() {
//                                CacheUtils.getInstance().put(key, new Gson().toJson(data, data.getClass()));
//                            }
//                        });
//                    }
//                }).observeOn(AndroidSchedulers.mainThread());
//            }
//        };
        return observable -> observable.subscribeOn(Schedulers.io()).doOnNext(data
                -> Schedulers.io().createWorker().schedule(() ->
                CacheUtils.getInstance().put(key, new
                        Gson().toJson(data, data.getClass())))).observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 读取key数据 .
     *
     * @param key   key
     * @param clazz 转换类
     * @param <T>   bean
     * @return json bean
     */
    public static <T> Observable readCache(String key, Class<T> clazz) {
//        return Observable.create(new ObservableOnSubscribe<T>() {
//            @Override
//            public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
//                String content = CacheUtils.getInstance().getAsString(key);
//                if (!TextUtils.isEmpty(content)) {
//                    observableEmitter.onNext(new Gson().fromJson(content, clazz));
//                }
//                observableEmitter.onComplete();
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return Observable.create((ObservableOnSubscribe<T>) observableEmitter -> {
            String content = CacheUtils.getInstance().getAsString(key);
            if (!TextUtils.isEmpty(content)) {
                observableEmitter.onNext(new Gson().fromJson(content, clazz));
            }
            observableEmitter.onComplete();
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
