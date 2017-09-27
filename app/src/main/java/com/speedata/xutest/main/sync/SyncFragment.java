package com.speedata.xutest.main.sync;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.speedata.xutest.R;
import com.speedata.xutest.base.BaseMvpFragment;
import com.speedata.xutest.datebase.GreenDaoManager;
import com.speedata.xutest.main.sync.entity.AssetsLocationEntity;
import com.speedata.xutest.main.sync.entity.CateEntity;
import com.speedata.xutest.main.sync.entity.DeptEntity;
import com.speedata.xutest.main.sync.entity.StatusEntity;
import com.speedata.xutest.main.sync.entity.SupplierEntity;
import com.speedata.xutest.main.sync.entity.UserEntity;


/**
 * @author :Reginer in  2017/9/18 18:59.
 *         联系方式:QQ:282921012
 *         功能描述:同步
 */
public class SyncFragment extends BaseMvpFragment<SyncFragment, SyncPresenterImpl> implements View.OnClickListener, ISyncView {


    private SyncItemView mLoadAssets;
    private SyncItemView mLoadUser;
    private SyncItemView mLoadLocation;
    private SyncItemView mLoadStatus;
    private SyncItemView mLoadSupplier;
    private SyncItemView mLoadDept;
    private SyncItemView mUploadAssets;

    public SyncFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sync;
    }

    @Override
    protected void initView(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.btn_sync).setOnClickListener(this);
        mLoadAssets = view.findViewById(R.id.load_assets);
        mLoadUser = view.findViewById(R.id.load_user);
        mLoadLocation = view.findViewById(R.id.load_location);
        mLoadStatus = view.findViewById(R.id.load_status);
        mLoadSupplier = view.findViewById(R.id.load_supplier);
        mLoadDept = view.findViewById(R.id.load_dept);
        mUploadAssets = view.findViewById(R.id.upload_assets);
    }

    @Override
    protected SyncPresenterImpl createPresenter() {
        return new SyncPresenterImpl();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sync:
                mPresenter.loadData(mLoadAssets.isChecked(), mLoadUser.isChecked(), mLoadLocation.isChecked(), mLoadStatus.isChecked(),
                        mLoadSupplier.isChecked(), mLoadDept.isChecked(), mUploadAssets.isChecked());
                break;

            default:
                break;
        }
    }

    @Override
    public void process(int viewId) {
        switch (viewId) {
            case R.id.load_assets:
                mLoadAssets.setProgressVisible(true);
                break;
            case R.id.load_user:
                mLoadUser.setProgressVisible(true);
                break;
            case R.id.load_location:
                mLoadLocation.setProgressVisible(true);
                break;
            case R.id.load_status:
                mLoadStatus.setProgressVisible(true);
                break;
            case R.id.load_supplier:
                mLoadSupplier.setProgressVisible(true);
                break;
            case R.id.load_dept:
                mLoadDept.setProgressVisible(true);
                break;
            case R.id.upload_assets:
                mUploadAssets.setProgressVisible(true);
                break;

            default:
                break;
        }
    }

    @Override
    public void getStatusList(Throwable e, StatusEntity entity) {
        mLoadStatus.setProgressVisible(false);
        mLoadStatus.setComplete(e == null);
        if (entity != null && "1".equals(entity.getErrCode())) {
            GreenDaoManager.saveStatusList(entity.getStatusList());
        }
    }

    @Override
    public void getUserList(Throwable e, UserEntity entity) {
        mLoadUser.setProgressVisible(false);
        mLoadUser.setComplete(e == null);
        if (entity != null && "1".equals(entity.getErrCode())) {
            GreenDaoManager.saveUserList(entity.getUserList());
        }
    }

    @Override
    public void getProList(Throwable e, AssetsLocationEntity entity) {
        mLoadLocation.setProgressVisible(false);
        mLoadLocation.setComplete(e == null);
        if (entity != null && "1".equals(entity.getErrCode())) {
            GreenDaoManager.saveProjList(entity.getProjList());
        }
    }

    @Override
    public void getCateList(Throwable e, CateEntity entity) {
        mLoadAssets.setProgressVisible(false);
        mLoadAssets.setComplete(e == null);
        if (entity != null && "1".equals(entity.getErrCode())) {
            GreenDaoManager.saveCateList(entity.getCateList());
        }
    }

    @Override
    public void getSupplierList(Throwable e, SupplierEntity entity) {
        mLoadSupplier.setProgressVisible(false);
        mLoadSupplier.setComplete(e == null);
        if (entity != null && "1".equals(entity.getErrCode())) {
            GreenDaoManager.saveSupplierList(entity.getSupplierList());
        }
    }

    @Override
    public void getDeptList(Throwable e, DeptEntity entity) {
        mLoadDept.setProgressVisible(false);
        mLoadDept.setComplete(e == null);
        if (entity != null && "1".equals(entity.getResponseCode())) {
            GreenDaoManager.saveDeptList(entity.getDeptList());
        }
    }

    @Override
    public void upload(Throwable throwable) {
        mUploadAssets.setProgressVisible(false);
        mUploadAssets.setComplete(throwable == null);
    }
}
