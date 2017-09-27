package com.speedata.xutest.datebase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @author :Reginer in  2017/9/26 11:25.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
@Entity
public class DeptListEntity {
    /**
     * DeptId : 1
     * DeptName : 绯荤粺绠＄悊閮�
     */
    @Id
    private Long id;
    @Unique
    private String DeptId;
    private String DeptName;

    @Generated(hash = 110452457)
    public DeptListEntity(Long id, String DeptId, String DeptName) {
        this.id = id;
        this.DeptId = DeptId;
        this.DeptName = DeptName;
    }

    @Generated(hash = 1436815362)
    public DeptListEntity() {
    }

    public String getDeptId() {
        return DeptId;
    }

    public void setDeptId(String DeptId) {
        this.DeptId = DeptId;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String DeptName) {
        this.DeptName = DeptName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
