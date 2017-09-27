package com.speedata.xutest.datebase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @author :Reginer in  2017/9/20 16:38.
 *         联系方式:QQ:282921012
 *         功能描述:资产位置列表
 */
@Entity
public class ProjListEntity {
    /**
     * ProjId : 1
     * ProjName : B库房
     * ProjArea : 朝阳区
     * ProjAddr : 北京市朝阳区广渠路36号
     */
    @Id
    private Long id;
    @Unique
    private String ProjId;
    private String ProjName;
    private String ProjArea;
    private String ProjAddr;

    @Generated(hash = 990579972)
    public ProjListEntity(Long id, String ProjId, String ProjName, String ProjArea,
            String ProjAddr) {
        this.id = id;
        this.ProjId = ProjId;
        this.ProjName = ProjName;
        this.ProjArea = ProjArea;
        this.ProjAddr = ProjAddr;
    }

    @Generated(hash = 1112444974)
    public ProjListEntity() {
    }

    public String getProjId() {
        return ProjId;
    }

    public void setProjId(String ProjId) {
        this.ProjId = ProjId;
    }

    public String getProjName() {
        return ProjName;
    }

    public void setProjName(String ProjName) {
        this.ProjName = ProjName;
    }

    public String getProjArea() {
        return ProjArea;
    }

    public void setProjArea(String ProjArea) {
        this.ProjArea = ProjArea;
    }

    public String getProjAddr() {
        return ProjAddr;
    }

    public void setProjAddr(String ProjAddr) {
        this.ProjAddr = ProjAddr;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
