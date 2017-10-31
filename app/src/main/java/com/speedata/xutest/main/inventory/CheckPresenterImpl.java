package com.speedata.xutest.main.inventory;

import com.google.gson.Gson;
import com.speedata.xutest.base.AppFid;
import com.speedata.xutest.base.BaseMvpPresenter;
import com.speedata.xutest.cache.CacheManager;
import com.speedata.xutest.net.Constant;
import com.speedata.xutest.net.NetApi;
import com.speedata.xutest.utils.DeviceUtils;
import com.speedata.xutest.utils.SPUtils;
import com.speedata.xutest.utils.ToastUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author :Reginer in  2017/9/19 17:54.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class CheckPresenterImpl extends BaseMvpPresenter<InventoryFragment> implements ICheckPresenter {

    @Override
    public void getCheckListBean() {
        String cacheKey = CacheManager.createCacheKey("getCheckList");
        if ((boolean) SPUtils.get(AppFid.getInstance(), Constant.ONLINE, true)) {

            CheckParams params = new CheckParams();
            params.setDeviceId(DeviceUtils.getAndroidID(AppFid.getInstance()));
            params.setUserToken((String) SPUtils.get(AppFid.getInstance(), Constant.TOKEN, ""));
            params.setLastRequestTime("2000-01-01 00:00:00");
            NetApi.getInstance().getCheckListBean(new Gson().toJson(params)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<CheckListEntity>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            addDisposable(d);
                        }

                        @Override
                        public void onNext(CheckListEntity checkListEntity) {
                            getView().completeGetCheckListbean(null, checkListEntity);
                        }


                        @Override
                        public void onError(Throwable e) {
                            getView().completeGetCheckListbean(e, null);
                            ToastUtils.showShortToastSafe(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }

        else {
            CacheManager.readCache(cacheKey, CheckListEntity.class).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<CheckListEntity>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(CheckListEntity checkListEntity) {
                            getView().completeGetCheckListbean(null, checkListEntity);
                        }

                        @Override
                        public void onError(Throwable e) {
                            getView().completeGetCheckListbean(e, null);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }

    }
}
