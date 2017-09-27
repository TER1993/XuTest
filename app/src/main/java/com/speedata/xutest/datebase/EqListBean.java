package com.speedata.xutest.datebase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by xu on 2017/9/21.
 */
@Entity
public class EqListBean {
    /**
     * EqId : 1
     */
    @Id
    private Long id;
    private Long uniqueNum; //外键，保存对应checklistbean对应的id
    private String EqId;
    @Generated(hash = 1336236451)
    public EqListBean(Long id, Long uniqueNum, String EqId) {
        this.id = id;
        this.uniqueNum = uniqueNum;
        this.EqId = EqId;
    }
    @Generated(hash = 588989744)
    public EqListBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUniqueNum() {
        return this.uniqueNum;
    }
    public void setUniqueNum(Long uniqueNum) {
        this.uniqueNum = uniqueNum;
    }
    public String getEqId() {
        return this.EqId;
    }
    public void setEqId(String EqId) {
        this.EqId = EqId;
    }


}
