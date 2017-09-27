package com.speedata.xutest.main.sync.entity;


import com.speedata.xutest.datebase.CateListEntity;

import java.util.List;

/**
 * @author :Reginer in  2017/9/20 16:47.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class CateEntity {

    /**
     * ErrCode : 1
     * ErrMsg :
     * SysDate : 2017-09-20 16:47:52
     * CateList : [{"Cid":"1","CategoryName":"c01","ParentId":""},{"Cid":"2","CategoryName":"c02","ParentId":"1"}]
     */

    private String ResponseCode;
    private String ErrMsg;
    private String SysDate;
    private List<CateListEntity> CateList;

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

    public List<CateListEntity> getCateList() {
        return CateList;
    }

    public void setCateList(List<CateListEntity> CateList) {
        this.CateList = CateList;
    }

}
