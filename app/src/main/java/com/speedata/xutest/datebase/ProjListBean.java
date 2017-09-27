package com.speedata.xutest.datebase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by xu on 2017/9/21.
 */
@Entity
public class ProjListBean {
    /**
     * ProjId : 1
     */
    @Id
    private Long id;
    private Long uniqueNum; //外键，保存对应checklistbean对应的id
    private String ProjId;
    @Generated(hash = 1782701860)
    public ProjListBean(Long id, Long uniqueNum, String ProjId) {
        this.id = id;
        this.uniqueNum = uniqueNum;
        this.ProjId = ProjId;
    }
    @Generated(hash = 1752441336)
    public ProjListBean() {
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
    public String getProjId() {
        return this.ProjId;
    }
    public void setProjId(String ProjId) {
        this.ProjId = ProjId;
    }

}
