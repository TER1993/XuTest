package com.speedata.xutest.main.sync;

import android.support.annotation.IdRes;

import com.speedata.xutest.main.sync.entity.AssetsLocationEntity;
import com.speedata.xutest.main.sync.entity.CateEntity;
import com.speedata.xutest.main.sync.entity.DeptEntity;
import com.speedata.xutest.main.sync.entity.StatusEntity;
import com.speedata.xutest.main.sync.entity.SupplierEntity;
import com.speedata.xutest.main.sync.entity.UserEntity;


/**
 * @author :Reginer in  2017/9/20 15:00.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public interface ISyncView {
    void process(@IdRes int viewId);

    void getStatusList(Throwable e, StatusEntity entity);

    void getUserList(Throwable e, UserEntity entity);

    void getProList(Throwable e, AssetsLocationEntity entity);

    void getCateList(Throwable e, CateEntity entity);

    void getSupplierList(Throwable e, SupplierEntity entity);

    void getDeptList(Throwable e, DeptEntity entity);

    void upload(Throwable throwable);
}
