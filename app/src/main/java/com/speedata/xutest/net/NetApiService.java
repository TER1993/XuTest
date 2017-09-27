package com.speedata.xutest.net;


import com.speedata.xutest.add.AddResultEntity;
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

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetApiService {

    /**
     * * 登录.
     *
     * @param requestJson requestJson
     * @return {@link LoginEntity}
     */
    @GET("sysLogin")
    Observable<LoginEntity> doLogin(@Query("requestJson") String requestJson);

    /**
     * 获取资产列表.
     *
     * @param requestJson requestJson
     * @return {@link AssetsEntity}
     */
    @GET("getEquipmentList")
    Observable<AssetsEntity> getEquipmentList(@Query("requestJson") String requestJson);

    /**
     * 获取盘点列表
     *
     * @param requestJson requestJson
     * @return {@link CheckListEntity}
     */

    @GET("getCheckList")
    Observable<CheckListEntity> getCheckListBean(@Query("requestJson") String requestJson);


    /**
     * 获取资产状态列表.
     *
     * @param requestJson requestJson
     * @return {@link StatusEntity}
     */
    @GET("getStatusList")
    Observable<StatusEntity> getStatusList(@Query("requestJson") String requestJson);

    /**
     * 获取人员列表.
     *
     * @param requestJson requestJson
     * @return {@link UserEntity}
     */
    @GET("getUserList")
    Observable<UserEntity> getUserList(@Query("requestJson") String requestJson);

    /**
     * 获取资产位置列表.
     *
     * @param requestJson requestJson
     * @return {@link AssetsLocationEntity}
     */
    @GET("getProjList")
    Observable<AssetsLocationEntity> getProList(@Query("requestJson") String requestJson);

    /**
     * 获取资产分类列表.
     *
     * @param requestJson requestJson
     * @return {@link CateEntity}
     */
    @GET("getCateList")
    Observable<CateEntity> getCateList(@Query("requestJson") String requestJson);

    /**
     * 获取供应商列表.
     *
     * @param requestJson requestJson
     * @return {@link SupplierEntity}
     */
    @GET("getSupplierList")
    Observable<SupplierEntity> getSupplierList(@Query("requestJson") String requestJson);
    /**
     * 获取供应商列表.
     *
     * @param requestJson requestJson
     * @return {@link SupplierEntity}
     */
    @GET("getDeptList")
    Observable<DeptEntity> getDeptList(@Query("requestJson") String requestJson);

    /**
     * 提交资产信息.
     *
     * @param requestJson requestJson
     * @return 提交结果
     */
    @GET("uploadEquipment")
    Observable<AddResultEntity> uploadEquipment(@Query("requestJson") String requestJson);

    /**
     * 上传盘点结果.
     *
     * @param requestJson requestJson
     * @return 提交盘点结果
     */
    @GET("uploadRptChkInfo")
    Observable<InventoryResultEntity> uploadRptChkInfo(@Query("requestJson") String requestJson);




}
