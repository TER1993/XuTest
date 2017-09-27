package com.speedata.xutest.main.sync.entity;


import com.speedata.xutest.datebase.ProjListEntity;

import java.util.List;

/**
 * @author :Reginer in  2017/9/20 16:38.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class AssetsLocationEntity {

    /**
     * ErrCode : 1
     * ErrMsg :
     * SysDate : 2017-09-20 16:38:20
     * ProjList : [{"ProjId":"1","ProjName":"B库房","ProjArea":"朝阳区","ProjAddr":"北京市朝阳区广渠路36号"},{"ProjId":"2","ProjName":"A库房","ProjArea":"石景山","ProjAddr":"北京市石景山区鲁谷路74号"}]
     */

    private String ResponseCode;
    private String ErrMsg;
    private String SysDate;
    private List<ProjListEntity> ProjList;

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

    public List<ProjListEntity> getProjList() {
        return ProjList;
    }

    public void setProjList(List<ProjListEntity> ProjList) {
        this.ProjList = ProjList;
    }

}
