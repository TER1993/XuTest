package com.speedata.xutest.inventory;

/**
 * Created by xu on 2017/9/25.
 */

public class InventoryResultEntity {

    /**
     * ResponseCode : 1
     * ErrMsg :
     * SysDate : 2017-09-25 11:13:40
     */

    private String ResponseCode;
    private String ErrMsg;
    private String SysDate;

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
}
