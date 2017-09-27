package com.speedata.xutest.main.sync;

import com.google.gson.Gson;
import com.speedata.xutest.R;
import com.speedata.xutest.add.AddResultEntity;
import com.speedata.xutest.base.BaseMvpPresenter;
import com.speedata.xutest.datebase.EquipmentListEntity;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.main.sync.entity.AssetsLocationEntity;
import com.speedata.xutest.main.sync.entity.CateEntity;
import com.speedata.xutest.main.sync.entity.DeptEntity;
import com.speedata.xutest.main.sync.entity.StatusEntity;
import com.speedata.xutest.main.sync.entity.SupplierEntity;
import com.speedata.xutest.main.sync.entity.UserEntity;
import com.speedata.xutest.net.NetApi;
import com.speedata.xutest.net.NetParams;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author :Reginer in  2017/9/20 15:01.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class SyncPresenterImpl extends BaseMvpPresenter<SyncFragment> implements ISyncPresenter {
    @Override
    public void loadData(boolean loadAssets, boolean loadUser, boolean loadLocation, boolean loadStatus, boolean loadSupplier,
                         boolean loadDept, boolean uploadAssets) {
        if (loadAssets) {
            loadAssets();
        }
        if (loadUser) {
            loadUser();
        }
        if (loadLocation) {
            loadLocation();
        }
        if (loadStatus) {
            loadStatus();
        }
        if (loadSupplier) {
            loadSupplier();
        }
        if (loadDept) {
            loadDept();
        }
        if (uploadAssets) {
            getView().process(R.id.upload_assets);
            uploadAssets(null);
        }
    }

    private void loadDept() {
        getView().process(R.id.load_dept);
        NetApi.getInstance().getDeptList(NetParams.getParams("2001-01-01 00:00:00")).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<DeptEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onNext(DeptEntity entity) {
                getView().getDeptList(null, entity);
            }

            @Override
            public void onError(Throwable e) {
                getView().getSupplierList(e, null);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void loadSupplier() {
        getView().process(R.id.load_supplier);
        NetApi.getInstance().getSupplierList(NetParams.getParams("2001-01-01 00:00:00")).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<SupplierEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onNext(SupplierEntity entity) {
                getView().getSupplierList(null, entity);
            }

            @Override
            public void onError(Throwable e) {
                getView().getSupplierList(e, null);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void loadAssets() {
        getView().process(R.id.load_assets);
        NetApi.getInstance().getCateList(NetParams.getParams("2001-01-01 00:00:00")).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CateEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onNext(CateEntity entity) {
                getView().getCateList(null, entity);
            }

            @Override
            public void onError(Throwable e) {
                getView().getCateList(e, null);
            }

            @Override
            public void onComplete() {

            }
        });

    }

    private void loadUser() {
        getView().process(R.id.load_user);
        NetApi.getInstance().getUserList(NetParams.getParams("2001-01-01 00:00:00")).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<UserEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onNext(UserEntity entity) {
                getView().getUserList(null, entity);
            }

            @Override
            public void onError(Throwable e) {
                getView().getUserList(e, null);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void loadLocation() {
        getView().process(R.id.load_location);
        NetApi.getInstance().getProList(NetParams.getParams("2001-01-01 00:00:00")).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<AssetsLocationEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onNext(AssetsLocationEntity entity) {
                getView().getProList(null, entity);
            }

            @Override
            public void onError(Throwable e) {
                getView().getProList(e, null);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void loadStatus() {
        getView().process(R.id.load_status);
        NetApi.getInstance().getStatusList(NetParams.getParams("2000-01-01 00:00:00")).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<StatusEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onNext(StatusEntity statusEntity) {
                getView().getStatusList(null, statusEntity);
            }

            @Override
            public void onError(Throwable e) {
                getView().getStatusList(e, null);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void uploadAssets(Throwable throwable) {
        if (throwable != null) {
            getView().upload(throwable);
            return;
        }
        List<EquipmentListEntity> listEntityList = GreenDaoManager.queryUpload();
        if (listEntityList != null && !listEntityList.isEmpty()) {
            upload(listEntityList.get(listEntityList.size() - 1));
        } else {
            getView().upload(null);
        }
    }

    private void upload(EquipmentListEntity entity) {
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
                    uploadAssets(null);
                } else {
                    uploadAssets(new Exception(s.getErrMsg()));
                }

            }

            @Override
            public void onError(Throwable e) {
                uploadAssets(e);
            }

            @Override
            public void onComplete() {

            }
        });
    }


}
