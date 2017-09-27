package com.speedata.xutest.main.assets;


import com.speedata.xutest.datebase.EquipmentListEntity;

import java.util.List;

/**
 * @author :Reginer in  2017/9/20 12:04.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class AssetsEntity {

    /**
     * ErrCode : 1
     * ErrMsg :
     * SysDate : 2017-09-20 12:04:01
     * EquipmentList : [{"Eid":"1","Rfid":"电子编码001","EquipmentTitle":"设备名称001","Cid":"1","Model":"设备型号001","ProjYear":"2017","ConfirmNo":"确认书号001","UnitPrice":"11","BuyDate":"2017-1-1","WarrantyPeriod":"10","EquipmentSn":"出厂编号001","FreqRange":"频率范围001","Sid":"1001","ArchNo":"档案号001","ProjId":"1","TotolAmount":"1","User":"管理员001","Manufacturer":"生产厂商001","EqStatus":"1","EqMemo":"备注001"},{"Eid":"2","Rfid":"电子编码002","EquipmentTitle":"设备名称002","Cid":"1","Model":"设备型号002","ProjYear":"2017","ConfirmNo":"确认书号002","UnitPrice":"11","BuyDate":"2017-1-1","WarrantyPeriod":"10","EquipmentSn":"出厂编号002","FreqRange":"频率范围002","Sid":"1002","ArchNo":"档案号002","ProjId":"1","TotolAmount":"1","User":"管理员002","Manufacturer":"生产厂商002","EqStatus":"1","EqMemo":"备注002"},{"Eid":"3","Rfid":"电子编码003","EquipmentTitle":"设备名称003","Cid":"1","Model":"设备型号003","ProjYear":"2017","ConfirmNo":"确认书号003","UnitPrice":"11","BuyDate":"2017-1-1","WarrantyPeriod":"10","EquipmentSn":"出厂编号003","FreqRange":"频率范围003","Sid":"1003","ArchNo":"档案号003","ProjId":"1","TotolAmount":"1","User":"管理员003","Manufacturer":"生产厂商003","EqStatus":"1","EqMemo":"备注003"}]
     */

    private String ResponseCode;
    private String ErrMsg;
    private String SysDate;
    private List<EquipmentListEntity> EquipmentList;

    public String getErrCode() {
        return ResponseCode;
    }

    public void setErrCode(String ErrCode) {
        this.ResponseCode = ErrCode;
    }

    public String getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(String ErrMsg) {
        this.ErrMsg = ErrMsg;
    }

    public String getSysDate() {
        return SysDate;
    }

    public void setSysDate(String SysDate) {
        this.SysDate = SysDate;
    }

    public List<EquipmentListEntity> getEquipmentList() {
        return EquipmentList;
    }

    public void setEquipmentList(List<EquipmentListEntity> EquipmentList) {
        this.EquipmentList = EquipmentList;
    }

}
