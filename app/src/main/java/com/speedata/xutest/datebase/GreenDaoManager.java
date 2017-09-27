package com.speedata.xutest.datebase;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import java.util.List;

/**
 * @author :Reginer in  2017/9/12 20:55.
 *         联系方式:QQ:282921012
 *         功能描述:GreenDao操作类
 */
public class GreenDaoManager {
    private static GreenDaoManager sInstance = new GreenDaoManager();
    private static DaoSession sDaoSession;

    public static void init(Application application) {
        SQLiteHelper helper = new SQLiteHelper(application, "rfid.db");
        Database db = helper.getWritableDb();
        sDaoSession = new DaoMaster(db).newSession();
    }

    public static GreenDaoManager getInstance() {
        return sInstance;
    }

    public DaoSession getDao() {
        return sDaoSession;
    }

    /**
     * 保存资产列表
     *
     * @param list 资产列表
     */
    public static void saveAssetsList(List<EquipmentListEntity> list) {
        sDaoSession.getEquipmentListEntityDao().insertOrReplaceInTx(list);
    }

    /**
     * 保存状态列表
     *
     * @param list 状态列表
     */
    public static void saveStatusList(List<StatusListEntity> list) {
        sDaoSession.getStatusListEntityDao().insertOrReplaceInTx(list);
    }

    /**
     * 保存人员列表
     *
     * @param list 人员列表
     */
    public static void saveUserList(List<UserListEntity> list) {
        sDaoSession.getUserListEntityDao().insertOrReplaceInTx(list);
    }

    /**
     * 保存资产位置列表
     *
     * @param list 资产位置列表
     */
    public static void saveProjList(List<ProjListEntity> list) {
        sDaoSession.getProjListEntityDao().insertOrReplaceInTx(list);
    }

    /**
     * 保存资产分类信息列表
     *
     * @param list 资产分类信息列表
     */
    public static void saveCateList(List<CateListEntity> list) {
        sDaoSession.getCateListEntityDao().insertOrReplaceInTx(list);
    }

    /**
     * 保存供应商列表.
     *
     * @param list 供应商列表
     */
    public static void saveSupplierList(List<SupplierListEntity> list) {
        sDaoSession.getSupplierListEntityDao().insertOrReplaceInTx(list);
    }
    /**
     * 保存部门信息列表.
     *
     * @param list 部门列表
     */
    public static void saveDeptList(List<DeptListEntity> list) {
        sDaoSession.getDeptListEntityDao().insertOrReplaceInTx(list);
    }


    /**
     * 保存盘点任务及下属两个list的信息列表
     *
     * @param list 盘点任务信息列表
     */
    public static void saveCheckListBean(List<CheckListBeanEntity> list) {
        sDaoSession.getCheckListBeanEntityDao().insertOrReplaceInTx(list);
        List<CheckListBeanEntity> mList = sDaoSession.getCheckListBeanEntityDao().loadAll();
        for (int i = 0; i < list.size(); i++){
            List<ProjListBean> projList = list.get(i).getProjList(); //获取list的内list
            List<EqListBean> eqList =  list.get(i).getEqList();
            if (projList.size()!=0) {
                for (int j = 0; j < projList.size(); j++){
                    projList.get(j).setUniqueNum(mList.get(i).getId());
                }
                sDaoSession.getProjListBeanDao().insertOrReplaceInTx(projList);
            }
            if (eqList.size()!=0){
                for (int k = 0; k < eqList.size(); k++){
                    eqList.get(k).setUniqueNum(mList.get(i).getId());
                }
            sDaoSession.getEqListBeanDao().insertOrReplaceInTx(eqList);
            }
        }
    }


    /**
     * 根据状态值获取状态名.
     *
     * @param status 状态值
     * @return name
     */
    public static String getNameByStatus(String status) {
        StatusListEntity entity = sDaoSession.getStatusListEntityDao()
                .queryBuilder().where(StatusListEntityDao.Properties.StatusId.eq(status)).unique();
        return entity != null ? entity.getStatusName() : status;
    }

    /**
     * 根据名称查找.
     *
     * @param title 资产名称
     * @return 资产列表
     */
    public static List<EquipmentListEntity> getEquipmentListByTitle(String title) {
        return sDaoSession.getEquipmentListEntityDao().queryBuilder().where(EquipmentListEntityDao.Properties.EquipmentTitle.like("%" + title + "%")).list();
    }

    /**
     * 查询未上传资产.
     *
     * @return 资产列表
     */
    public static List<EquipmentListEntity> queryUpload() {
        return sDaoSession.getEquipmentListEntityDao().queryBuilder().where(EquipmentListEntityDao.
                Properties.RequestUpload.eq(true)).list();
    }

    /**
     * 更新已上传资产.
     */
    public static void updateEquipment(EquipmentListEntity entity) {
        entity.setRequestUpload(false);
        sDaoSession.getEquipmentListEntityDao().insertOrReplace(entity);
    }

    /**
     * 根据名称查找.
     *
     * @param eid 资产名称
     * @return 资产
     */
    public static EquipmentListEntity getEquipmentByEid(String eid) {
        return sDaoSession.getEquipmentListEntityDao().queryBuilder().where(EquipmentListEntityDao.Properties.Eid.like(eid)).unique();
    }

    /**
     * 保存待上传资产.
     *
     * @param entity 资产
     */
    public static void saveEquipment(EquipmentListEntity entity) {
        sDaoSession.getEquipmentListEntityDao().insertOrReplaceInTx(entity);
    }

    /**
     * 根据ProjId查找所在位置.
     *
     * @param projId 位置id
     * @return 所在位置
     */
    public static String getProjName(String projId) {
        ProjListEntity entity = sDaoSession.getProjListEntityDao().queryBuilder().where(ProjListEntityDao.Properties.ProjId.like(projId)).unique();
        return entity != null ? entity.getProjName() : projId;
    }

    /**
     * 根据sid查找供应商名称.
     *
     * @param sid 位置id
     * @return 供应商名称
     */
    public static String getSupplierName(String sid) {
        SupplierListEntity entity = sDaoSession.getSupplierListEntityDao().queryBuilder().where(SupplierListEntityDao.Properties.SupplierId.like(sid)).unique();
        return entity != null ? entity.getSupplierName() : sid;
    }


    /**
     * 根据盘点单id查找.
     *
     * @param chkid 盘点单id
     * @return 盘点单
     */
    public static CheckListBeanEntity getCheckListBeanByEid(String chkid) {
        return sDaoSession.getCheckListBeanEntityDao().queryBuilder().where(CheckListBeanEntityDao.Properties.ChkId.like(chkid)).unique();
    }


    /**
     * 根据uniqueNum查eqlist盘点单id符合的内容.
     *
     * @param uniqueNum 盘点单详情uniqueNum
     * @return 盘点单要查的部分
     */
    public static List<EqListBean> getEqListBeanByUniqueNum(Long uniqueNum) {
        return sDaoSession.getEqListBeanDao()._queryCheckListBeanEntity_EqList(uniqueNum);
    }

    /**
     * 根据uniqueNum查projlist盘点单id符合的内容.
     *
     * @param uniqueNum 盘点单详情uniqueNum
     * @return 盘点单要查的部分
     */
    public static List<ProjListBean> getProjListBeanByUniqueNum(Long uniqueNum) {
        return sDaoSession.getProjListBeanDao()._queryCheckListBeanEntity_ProjList(uniqueNum);
    }

    /**
     * 根据projlist查找显示内容.
     *
     * @param projid 资产
     * @return 资产列表
     */
    public static List<EquipmentListEntity> getEquipmentListByProjid(String projid) {
        return sDaoSession.getEquipmentListEntityDao().queryBuilder().where(EquipmentListEntityDao.Properties.ProjId.like("%" + projid + "%")).list();
    }


    /**
     * 根据rfid查找.
     *
     * @param rfid 扫描到的标签rfid
     * @return 资产
     */
    public static EquipmentListEntity getEquipmentByRfid(String rfid) {
        return sDaoSession.getEquipmentListEntityDao().queryBuilder().where(EquipmentListEntityDao.Properties.Rfid.like(rfid)).unique();
    }

    /**
     * 保存待上传的盘点单主要内容.
     *
     * @param entity 盘点单主要内容
     */
    public static void saveUploadRptChkInfo(UploadRptChkInfoListEntity entity) {
        sDaoSession.getUploadRptChkInfoListEntityDao().insertOrReplaceInTx(entity);
    }

    /**
     * 根据chkid查找保存的盘点主内容.
     *
     * @param chkid 盘点单的chkid
     * @return 资产
     */
    public static UploadRptChkInfoListEntity getUploadRptChkInfoByChkid(String chkid) {
        return sDaoSession.getUploadRptChkInfoListEntityDao().queryBuilder().where(UploadRptChkInfoListEntityDao.Properties.ChkId.like(chkid)).unique();
    }

    /**
     * 保存待上传的盘点单的eqlist.
     *
     * @param list 盘点单主要内容下的eqlist
     */
    public static void saveEqListEntity(List<EqListEntity> list) {
        sDaoSession.getEqListEntityDao().insertOrReplaceInTx(list);
    }


    /**
     * 更新已上传盘点结果.
     */
    public static void updateInventory(UploadRptChkInfoListEntity entity) {

        sDaoSession.getUploadRptChkInfoListEntityDao().insertOrReplace(entity);
    }

    /**
     * 删除所选盘点单.
     */
    public static void delInventory(UploadRptChkInfoListEntity entity) {

        //先删除它关联的子表
        List<EqListEntity> list = sDaoSession.getEqListEntityDao()._queryUploadRptChkInfoListEntity_EqList(entity.getId());
        sDaoSession.getEqListEntityDao().deleteInTx(list);
        sDaoSession.getUploadRptChkInfoListEntityDao().deleteInTx(entity);
    }


    /**
     * 删除本地已上传盘点单.
     */
    public static void delCheckListById(Long id) {

        //先删除它关联的子表
        List<EqListBean> eqlist = sDaoSession.getEqListBeanDao()._queryCheckListBeanEntity_EqList(id);
        List<ProjListBean> projlist = sDaoSession.getProjListBeanDao()._queryCheckListBeanEntity_ProjList(id);
        sDaoSession.getEqListBeanDao().deleteInTx(eqlist);
        sDaoSession.getProjListBeanDao().deleteInTx(projlist);
        sDaoSession.getCheckListBeanEntityDao().deleteByKeyInTx(id);
    }



}
