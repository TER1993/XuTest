package com.speedata.xutest.datebase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @author :Reginer in  2017/9/20 16:32.
 *         联系方式:QQ:282921012
 *         功能描述:人员信息
 */
@Entity
public class UserListEntity {
    /**
     * UserAccount : 002
     * RealName : 李瑞
     * DeptId : 12
     */
    @Id
    private Long id;
    @Unique
    private String UserAccount;
    private String RealName;
    private String DeptId;

    @Generated(hash = 1757211944)
    public UserListEntity(Long id, String UserAccount, String RealName,
            String DeptId) {
        this.id = id;
        this.UserAccount = UserAccount;
        this.RealName = RealName;
        this.DeptId = DeptId;
    }

    @Generated(hash = 881371734)
    public UserListEntity() {
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String UserAccount) {
        this.UserAccount = UserAccount;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String RealName) {
        this.RealName = RealName;
    }

    public String getDeptId() {
        return DeptId;
    }

    public void setDeptId(String DeptId) {
        this.DeptId = DeptId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
