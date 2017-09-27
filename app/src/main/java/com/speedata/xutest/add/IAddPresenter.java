package com.speedata.xutest.add;

/**
 * @author :Reginer in  2017/9/21 15:35.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public interface IAddPresenter {
    /**
     * 提交资产信息.
     *
     * @param Rfid           电子编号
     * @param EquipmentTitle 设备名称
     * @param Model          设备型号
     * @param ProjYear       立项年份
     * @param ConfirmNo      确认书号
     * @param UnitPrice      设备价格
     * @param BuyDate        合同日期
     * @param WarrantyPeriod 质保期
     * @param EquipmentSn    出厂编号
     * @param FreqRange      频率范围
     * @param Sid            供应商
     * @param ArchNo         档案号
     * @param ProjId         位置
     * @param TotalAmount    数量
     * @param User           管理员
     * @param Manufacturer   生产厂商
     * @param EqStatus       状态
     * @param EqMemo         备注
     */
    void commit(String Rfid, String EquipmentTitle, String Model, String ProjYear
            , String ConfirmNo, String UnitPrice, String BuyDate, String WarrantyPeriod, String EquipmentSn,
                String FreqRange, String Sid, String ArchNo, String ProjId, String TotalAmount,
                String User, String Manufacturer, String EqStatus, String EqMemo, String AssetsCate, String deptId);
}
