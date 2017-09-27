package com.speedata.xutest.inventory;


import com.speedata.xutest.datebase.UploadRptChkInfoListEntity;

/**
 * @author :Reginer in  2017/9/22 12:03.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public interface ITakePresenter {
    void uploadInventory(UploadRptChkInfoListEntity entity, Throwable throwable);
}
