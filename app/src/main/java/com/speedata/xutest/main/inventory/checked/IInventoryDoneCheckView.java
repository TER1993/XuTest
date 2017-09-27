package com.speedata.xutest.main.inventory.checked;


import com.speedata.xutest.datebase.UploadRptChkInfoListEntity;

import java.util.List;

/**
 * @author :Reginer in  2017/9/19 17:54.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public interface IInventoryDoneCheckView {
    void completeGetCheckListbean(List<UploadRptChkInfoListEntity> entity);
}
