package com.speedata.xutest.add;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.speedata.xutest.R;
import com.speedata.xutest.base.AppFid;
import com.speedata.xutest.base.BaseMvpPresenter;
import com.speedata.xutest.datebase.EquipmentListEntity;
import com.speedata.xutest.datebase.GreenDaoManager;
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
 * @author :Reginer in  2017/9/21 15:35.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class AddPresenterImpl extends BaseMvpPresenter<AddAssetsActivity> implements IAddPresenter {
    @Override
    public void commit(String Rfid, String EquipmentTitle, String Model,
                       String ProjYear, String ConfirmNo, String UnitPrice,
                       String BuyDate, String WarrantyPeriod, String EquipmentSn,
                       String FreqRange, String Sid, String ArchNo, String ProjId,
                       String TotalAmount, String User, String Manufacturer, String EqStatus,
                       String EqMemo, String AssetsCate, String deptId) {
        if (TextUtils.isEmpty(Rfid) || TextUtils.isEmpty(EquipmentTitle) ||
                TextUtils.isEmpty(Model) || TextUtils.isEmpty(ProjYear) ||
                TextUtils.isEmpty(ConfirmNo) || TextUtils.isEmpty(UnitPrice) ||
                TextUtils.isEmpty(BuyDate) || TextUtils.isEmpty(WarrantyPeriod) ||
                TextUtils.isEmpty(EquipmentSn) || TextUtils.isEmpty(FreqRange) ||
                TextUtils.isEmpty(Sid) || TextUtils.isEmpty(ArchNo) ||
                TextUtils.isEmpty(ProjId) || TextUtils.isEmpty(TotalAmount) ||
                TextUtils.isEmpty(User) || TextUtils.isEmpty(Manufacturer) ||
                TextUtils.isEmpty(AssetsCate) || TextUtils.isEmpty(deptId) ||
                TextUtils.isEmpty(EqStatus) || TextUtils.isEmpty(EqMemo)) {
            ToastUtils.showShortToastSafe(R.string.content_null);
            return;
        }

        EquipmentListEntity entity = new EquipmentListEntity();
        entity.setUserToken((String) SPUtils.get(AppFid.getInstance(), Constant.TOKEN, ""));
        entity.setDeviceId(DeviceUtils.getAndroidID(AppFid.getInstance()));
        entity.setRfid(Rfid);
        entity.setEquipmentTitle(EquipmentTitle);
        entity.setModel(Model);
        entity.setProjYear(ProjYear);
        entity.setConfirmNo(ConfirmNo);
        entity.setUnitPrice(UnitPrice);
        entity.setBuyDate(BuyDate);
        entity.setWarrantyPeriod(WarrantyPeriod);
        entity.setEquipmentSn(EquipmentSn);
        entity.setFreqRange(FreqRange);
        entity.setSid(Sid);
        entity.setArchNo(ArchNo);
        entity.setProjId(ProjId);
        entity.setDeptId(deptId);
        entity.setTotolAmount(TotalAmount);
        entity.setUser(User);
        entity.setManufacturer(Manufacturer);
        entity.setEqStatus(EqStatus);
        entity.setEqMemo(EqMemo);
        entity.setCid(AssetsCate);
        entity.setRequestUpload(true);

        if ((boolean) SPUtils.get(AppFid.getInstance(), Constant.ONLINE, true)) {
            entity.setEid("0");
            NetApi.getInstance().uploadEquipment(new Gson().toJson(entity)).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<AddResultEntity>() {
                @Override
                public void onSubscribe(Disposable d) {
                    addDisposable(d);
                }

                @Override
                public void onNext(AddResultEntity s) {
                    if ("1".equals(s.getErrCode())) {
                        entity.setEid(s.getEid());
                        GreenDaoManager.updateEquipment(entity);
                    }
                    getView().completeCommit(0, s, null);
                }

                @Override
                public void onError(Throwable e) {
                    getView().completeCommit(0, null, e);
                }

                @Override
                public void onComplete() {

                }
            });
        } else {
            entity.setEid(String.valueOf(System.currentTimeMillis()));
            GreenDaoManager.saveEquipment(entity);
            getView().completeCommit(1, null, null);
        }
    }
}
