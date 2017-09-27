package com.speedata.xutest.main.assets;

import com.google.gson.Gson;
import com.speedata.xutest.base.AppFid;
import com.speedata.xutest.base.BaseMvpPresenter;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.net.Constant;
import com.speedata.xutest.net.NetApi;
import com.speedata.xutest.net.RequestParams;
import com.speedata.xutest.utils.DeviceUtils;
import com.speedata.xutest.utils.SPUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author :Reginer in  2017/9/19 17:54.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class AssetsPresenterImpl extends BaseMvpPresenter<AssetsFragment> implements IAssetsPresenter {

    @Override
    public void getEquipmentList() {
        RequestParams params = new RequestParams();
        params.setDeviceId(DeviceUtils.getAndroidID(AppFid.getInstance()));
        params.setUserToken((String) SPUtils.get(AppFid.getInstance(), Constant.TOKEN, ""));
        params.setLastRequestTime("2000-01-01 00:00:00");
        NetApi.getInstance().getEquipmentList(new Gson().toJson(params)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AssetsEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(AssetsEntity assetsEntity) {
                        getView().completeGetEquipmentList(null, assetsEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().completeGetEquipmentList(e, null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void searchByTitle(String title) {
        getView().completeQuery(GreenDaoManager.getEquipmentListByTitle(title));
    }
}
