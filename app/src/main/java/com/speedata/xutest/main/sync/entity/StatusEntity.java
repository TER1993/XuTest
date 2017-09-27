package com.speedata.xutest.main.sync.entity;


import com.speedata.xutest.datebase.StatusListEntity;

import java.util.List;

/**
 * @author :Reginer in  2017/9/20 15:26.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class StatusEntity {

    /**
     * ErrCode : 1
     * ErrMsg :
     * SysDate : 2017-09-20 15:26:10
     * StatusList : [{"StatusId":"1","StatusName":"在库"},{"StatusId":"5","StatusName":"部门在用"},{"StatusId":"6","StatusName":"维修中"},{"StatusId":"7","StatusName":"报废"}]
     */

    private String ResponseCode;
    private String ErrMsg;
    private String SysDate;
    private List<StatusListEntity> StatusList;

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

    public List<StatusListEntity> getStatusList() {
        return StatusList;
    }

    public void setStatusList(List<StatusListEntity> StatusList) {
        this.StatusList = StatusList;
    }

}
