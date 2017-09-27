package com.speedata.xutest.main.assets;


import com.speedata.xutest.datebase.EquipmentListEntity;

import java.util.List;

/**
 * @author :Reginer in  2017/9/19 17:54.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public interface IAssetsView {
    void completeGetEquipmentList(Throwable throwable, AssetsEntity entity);

    void completeQuery(List<EquipmentListEntity> listEntities);
}
