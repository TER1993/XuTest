package com.speedata.xutest.inventory;

import com.google.gson.Gson;
import com.speedata.xutest.base.BaseMvpPresenter;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.datebase.UploadRptChkInfoListEntity;
import com.speedata.xutest.net.NetApi;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author :Reginer in  2017/9/22 12:03.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class TakePresenterImpl extends BaseMvpPresenter<TakeInventoryActivity> implements ITakePresenter {

    public void uploadInventory(UploadRptChkInfoListEntity entity, Throwable throwable) {
        if (throwable != null) {
            getView().completeUploadRptChkInfo(throwable, null);
            return;
        }
        if (entity != null ) {
            upload(entity);
        }
    }

         private void upload(UploadRptChkInfoListEntity entity) {

        NetApi.getInstance().uploadRptChkInfo(new Gson().toJson(entity)).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<InventoryResultEntity>() {


        @Override
        public void onSubscribe(Disposable d) {
                addDisposable(d);
        }

        @Override
        public void onNext(InventoryResultEntity s) {
            if ("1".equals(s.getErrCode())) {
                entity.setUploadAlready(true);
                GreenDaoManager.updateInventory(entity);
                getView().completeUploadRptChkInfo(null, entity);
            } else {
                uploadInventory(entity, new Exception(s.getErrMsg()));
            }
        }

        @Override
        public void onError(Throwable e) {
            uploadInventory(entity, e);
            getView().completeUploadRptChkInfo(e, null);
        }

        @Override
        public void onComplete() {

        }
    });
    }
}


