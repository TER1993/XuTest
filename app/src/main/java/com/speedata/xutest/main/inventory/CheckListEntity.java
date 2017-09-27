package com.speedata.xutest.main.inventory;


import com.speedata.xutest.datebase.CheckListBeanEntity;

import java.util.List;

/**
 * Created by xu on 2017/9/20.
 */

public class CheckListEntity {

    /**
     * ResponseCode : 1
     * ErrMsg :
     * SysDate : 2017-09-20 16:35:10
     * CheckList : [{"ChkId":"1","ChkName":"盘点名称001","ChkAccount":"admin","CreateAccount":"admin","CreateTime":"2017-01-01 08:00:00","ProjList":[{"ProjId":"1"},{"ProjId":"2"}],"EqList":[]},{"ChkId":"2","ChkName":"盘点名称002","ChkAccount":"admin","CreateAccount":"admin","CreateTime":"2017-01-01 08:00:00","ProjList":[],"EqList":[{"EqId":"1"},{"EqId":"2"}]}]
     */

    private String ResponseCode;
    private String ErrMsg;
    private String SysDate;
    private List<CheckListBeanEntity> CheckList;

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

    public List<CheckListBeanEntity> getCheckListBean() {
        return CheckList;
    }

    public void setCheckListBean(List<CheckListBeanEntity> CheckList) {
        this.CheckList = CheckList;
    }


}
