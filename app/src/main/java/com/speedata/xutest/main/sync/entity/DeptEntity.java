package com.speedata.xutest.main.sync.entity;


import com.speedata.xutest.datebase.DeptListEntity;

import java.util.List;

/**
 * @author :Reginer in  2017/9/26 11:25.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class DeptEntity {

    /**
     * ResponseCode : 1
     * ErrMsg :
     * SysDate : 2017-09-26 11:24:59
     * DeptList : [{"DeptId":"1","DeptName":"绯荤粺绠＄悊閮�"},{"DeptId":"11","DeptName":"甯傚満閮�"},{"DeptId":"12","DeptName":"鍔炲叕瀹�"},{"DeptId":"13","DeptName":"璐㈠姟閮�"},{"DeptId":"14","DeptName":"鎶\u20ac鏈儴"},{"DeptId":"15","DeptName":"鎬昏鍔�"}]
     */

    private String ResponseCode;
    private String ErrMsg;
    private String SysDate;
    private List<DeptListEntity> DeptList;

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String ResponseCode) {
        this.ResponseCode = ResponseCode;
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

    public List<DeptListEntity> getDeptList() {
        return DeptList;
    }

    public void setDeptList(List<DeptListEntity> DeptList) {
        this.DeptList = DeptList;
    }

}
