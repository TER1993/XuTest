package com.speedata.xutest.datebase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @author :Reginer in  2017/9/20 15:26.
 *         联系方式:QQ:282921012
 *         功能描述:资产状态
 */
@Entity
public class StatusListEntity {
    /**
     * StatusId : 1
     * StatusName : 在库
     */
    @Id
    private Long id;
    @Unique
    private String StatusId;
    private String StatusName;

    @Generated(hash = 19005929)
    public StatusListEntity(Long id, String StatusId, String StatusName) {
        this.id = id;
        this.StatusId = StatusId;
        this.StatusName = StatusName;
    }

    @Generated(hash = 1824893721)
    public StatusListEntity() {
    }

    public String getStatusId() {
        return StatusId;
    }

    public void setStatusId(String StatusId) {
        this.StatusId = StatusId;
    }

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName(String StatusName) {
        this.StatusName = StatusName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
