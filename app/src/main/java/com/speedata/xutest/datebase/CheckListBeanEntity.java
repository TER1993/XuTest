package com.speedata.xutest.datebase;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xu on 2017/9/20.
 */

public class CheckListBeanEntity implements Serializable {

        /**
         * ChkId : 1
         * ChkName : 盘点名称001
         * ChkAccount : admin
         * CreateAccount : admin
         * CreateTime : 2017-01-01 08:00:00
         * ProjList : [{"ProjId":"1"},{"ProjId":"2"}]
         * EqList : [{"EqId": "1"},{"EqId": "2"}]
         */


        private String ChkId;
        private String ChkName;
        private String ChkAccount;
        private String CreateAccount;
        private String CreateTime;

        private List<ProjListBean> ProjList;
        private List<EqListBean> EqList;

    public String getChkId() {
        return ChkId;
    }

    public void setChkId(String chkId) {
        ChkId = chkId;
    }

    public String getChkName() {
        return ChkName;
    }

    public void setChkName(String chkName) {
        ChkName = chkName;
    }

    public String getChkAccount() {
        return ChkAccount;
    }

    public void setChkAccount(String chkAccount) {
        ChkAccount = chkAccount;
    }

    public String getCreateAccount() {
        return CreateAccount;
    }

    public void setCreateAccount(String createAccount) {
        CreateAccount = createAccount;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public List<ProjListBean> getProjList() {
        return ProjList;
    }

    public void setProjList(List<ProjListBean> projList) {
        ProjList = projList;
    }

    public List<EqListBean> getEqList() {
        return EqList;
    }

    public void setEqList(List<EqListBean> eqList) {
        EqList = eqList;
    }
}
