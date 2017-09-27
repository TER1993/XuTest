package com.speedata.xutest.main.sync.entity;


import com.speedata.xutest.datebase.SupplierListEntity;

import java.util.List;

/**
 * @author :Reginer in  2017/9/21 14:27.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class SupplierEntity {

    /**
     * ErrCode : 1
     * ErrMsg :
     * SysDate : 2017-09-21 14:26:55
     * SupplierList : [{"SupplierId":"1","SupplierName":"s01","LinkMan":"","LinkPhone":"","LinkQq":""},{"SupplierId":"2","SupplierName":"s02","LinkMan":"","LinkPhone":"","LinkQq":""}]
     */

    private String ResponseCode;
    private String ErrMsg;
    private String SysDate;
    private List<SupplierListEntity> SupplierList;

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

    public List<SupplierListEntity> getSupplierList() {
        return SupplierList;
    }

    public void setSupplierList(List<SupplierListEntity> SupplierList) {
        this.SupplierList = SupplierList;
    }

}
