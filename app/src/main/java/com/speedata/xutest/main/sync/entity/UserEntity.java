package com.speedata.xutest.main.sync.entity;


import com.speedata.xutest.datebase.UserListEntity;

import java.util.List;

/**
 * @author :Reginer in  2017/9/20 16:32.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class UserEntity {

    /**
     * ErrCode : 1
     * ErrMsg :
     * SysDate : 2017-09-20 16:32:08
     * UserList : [{"UserAccount":"002","RealName":"李瑞","DeptId":"12"},{"UserAccount":"admin","RealName":"结局","DeptId":"1"},{"UserAccount":"lidong","RealName":"李东","DeptId":"11"},{"UserAccount":"liuliu","RealName":"柳柳","DeptId":"11"},{"UserAccount":"luli","RealName":"鲁丽","DeptId":"11"},{"UserAccount":"test","RealName":"宏伟","DeptId":"11"},{"UserAccount":"ws01","RealName":"李斌","DeptId":"12"},{"UserAccount":"wyd","RealName":"王叶东","DeptId":"13"},{"UserAccount":"wyr","RealName":"何伟","DeptId":"14"},{"UserAccount":"xiami","RealName":"夏米","DeptId":"11"}]
     */

    private String ResponseCode;
    private String ErrMsg;
    private String SysDate;
    private List<UserListEntity> UserList;

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

    public List<UserListEntity> getUserList() {
        return UserList;
    }

    public void setUserList(List<UserListEntity> UserList) {
        this.UserList = UserList;
    }

}
