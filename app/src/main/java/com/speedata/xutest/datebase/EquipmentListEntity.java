package com.speedata.xutest.datebase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @author :Reginer in  2017/9/20 13:49.
 *         联系方式:QQ:282921012
 *         功能描述:资产列表
 */
@Entity
public class EquipmentListEntity {
    /**
     * Eid : 1
     * Rfid : 电子编码001
     * EquipmentTitle : 设备名称001
     * Cid : 1
     * Model : 设备型号001
     * ProjYear : 2017
     * ConfirmNo : 确认书号001
     * UnitPrice : 11
     * BuyDate : 2017-1-1
     * WarrantyPeriod : 10
     * EquipmentSn : 出厂编号001
     * FreqRange : 频率范围001
     * Sid : 1001
     * ArchNo : 档案号001
     * ProjId : 1
     * TotolAmount : 1
     * User : 管理员001
     * Manufacturer : 生产厂商001
     * EqStatus : 1
     * EqMemo : 备注001
     */
    @Id
    private Long id;
    @Unique
    private String Eid;
    private String Rfid;
    private String EquipmentTitle;
    private String Cid;
    private String Model;
    private String ProjYear;
    private String ConfirmNo;
    private String UnitPrice;
    private String BuyDate;
    private String WarrantyPeriod;
    private String EquipmentSn;
    private String FreqRange;
    private String Sid;
    private String ArchNo;
    private String ProjId;
    private String TotolAmount;
    private String User;
    private String Manufacturer;
    private String EqStatus;
    private String EqMemo;
    private boolean requestUpload;
    private String UserToken;
    private String DeviceId;
    private String DeptId;

    private int OverageOrLoss = 0; //添加一个键存放盘盈盘亏状态


    @Generated(hash = 82421835)
    public EquipmentListEntity(Long id, String Eid, String Rfid,
            String EquipmentTitle, String Cid, String Model, String ProjYear,
            String ConfirmNo, String UnitPrice, String BuyDate,
            String WarrantyPeriod, String EquipmentSn, String FreqRange, String Sid,
            String ArchNo, String ProjId, String TotolAmount, String User,
            String Manufacturer, String EqStatus, String EqMemo,
            boolean requestUpload, String UserToken, String DeviceId, String DeptId,
            int OverageOrLoss) {
        this.id = id;
        this.Eid = Eid;
        this.Rfid = Rfid;
        this.EquipmentTitle = EquipmentTitle;
        this.Cid = Cid;
        this.Model = Model;
        this.ProjYear = ProjYear;
        this.ConfirmNo = ConfirmNo;
        this.UnitPrice = UnitPrice;
        this.BuyDate = BuyDate;
        this.WarrantyPeriod = WarrantyPeriod;
        this.EquipmentSn = EquipmentSn;
        this.FreqRange = FreqRange;
        this.Sid = Sid;
        this.ArchNo = ArchNo;
        this.ProjId = ProjId;
        this.TotolAmount = TotolAmount;
        this.User = User;
        this.Manufacturer = Manufacturer;
        this.EqStatus = EqStatus;
        this.EqMemo = EqMemo;
        this.requestUpload = requestUpload;
        this.UserToken = UserToken;
        this.DeviceId = DeviceId;
        this.DeptId = DeptId;
        this.OverageOrLoss = OverageOrLoss;
    }

    @Generated(hash = 175501367)
    public EquipmentListEntity() {
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEid() {
        return this.Eid;
    }

    public void setEid(String Eid) {
        this.Eid = Eid;
    }

    public String getRfid() {
        return this.Rfid;
    }

    public void setRfid(String Rfid) {
        this.Rfid = Rfid;
    }

    public String getEquipmentTitle() {
        return this.EquipmentTitle;
    }

    public void setEquipmentTitle(String EquipmentTitle) {
        this.EquipmentTitle = EquipmentTitle;
    }

    public String getCid() {
        return this.Cid;
    }

    public void setCid(String Cid) {
        this.Cid = Cid;
    }

    public String getModel() {
        return this.Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getProjYear() {
        return this.ProjYear;
    }

    public void setProjYear(String ProjYear) {
        this.ProjYear = ProjYear;
    }

    public String getConfirmNo() {
        return this.ConfirmNo;
    }

    public void setConfirmNo(String ConfirmNo) {
        this.ConfirmNo = ConfirmNo;
    }

    public String getUnitPrice() {
        return this.UnitPrice;
    }

    public void setUnitPrice(String UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public String getBuyDate() {
        return this.BuyDate;
    }

    public void setBuyDate(String BuyDate) {
        this.BuyDate = BuyDate;
    }

    public String getWarrantyPeriod() {
        return this.WarrantyPeriod;
    }

    public void setWarrantyPeriod(String WarrantyPeriod) {
        this.WarrantyPeriod = WarrantyPeriod;
    }

    public String getEquipmentSn() {
        return this.EquipmentSn;
    }

    public void setEquipmentSn(String EquipmentSn) {
        this.EquipmentSn = EquipmentSn;
    }

    public String getFreqRange() {
        return this.FreqRange;
    }

    public void setFreqRange(String FreqRange) {
        this.FreqRange = FreqRange;
    }

    public String getSid() {
        return this.Sid;
    }

    public void setSid(String Sid) {
        this.Sid = Sid;
    }

    public String getArchNo() {
        return this.ArchNo;
    }

    public void setArchNo(String ArchNo) {
        this.ArchNo = ArchNo;
    }

    public String getProjId() {
        return this.ProjId;
    }

    public void setProjId(String ProjId) {
        this.ProjId = ProjId;
    }

    public String getTotolAmount() {
        return this.TotolAmount;
    }

    public void setTotolAmount(String TotolAmount) {
        this.TotolAmount = TotolAmount;
    }

    public String getUser() {
        return this.User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getManufacturer() {
        return this.Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public String getEqStatus() {
        return this.EqStatus;
    }

    public void setEqStatus(String EqStatus) {
        this.EqStatus = EqStatus;
    }

    public String getEqMemo() {
        return this.EqMemo;
    }

    public void setEqMemo(String EqMemo) {
        this.EqMemo = EqMemo;
    }

    public boolean getRequestUpload() {
        return this.requestUpload;
    }

    public void setRequestUpload(boolean requestUpload) {
        this.requestUpload = requestUpload;
    }

    public String getUserToken() {
        return this.UserToken;
    }

    public void setUserToken(String UserToken) {
        this.UserToken = UserToken;
    }

    public String getDeviceId() {
        return this.DeviceId;
    }

    public void setDeviceId(String DeviceId) {
        this.DeviceId = DeviceId;
    }


    public int getOverageOrLoss() {
        return this.OverageOrLoss;
    }

    public void setOverageOrLoss(int OverageOrLoss) {
        this.OverageOrLoss = OverageOrLoss;
    }

    public String getDeptId() {
        return this.DeptId;
    }

    public void setDeptId(String DeptId) {
        this.DeptId = DeptId;
    }


}
