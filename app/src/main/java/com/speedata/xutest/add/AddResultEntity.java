package com.speedata.xutest.add;

import com.google.gson.Gson;

/**
 * @author :Reginer in  2017/9/22 10:01.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class AddResultEntity {

    /**
     * ErrCode : 1
     * ErrMsg :
     * SysDate : 2017-09-22 10:01:29
     * Eid : 1
     */

    private String ResponseCode;
    private String ErrMsg;
    private String SysDate;
    private String Eid;

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

    public String getEid() {
        return Eid;
    }

    public void setEid(String Eid) {
        this.Eid = Eid;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
