package com.speedata.xutest.datebase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by xu on 2017/9/23.
 */
@Entity
public class EqListEntity {

    @Id
    private Long id;

    private String Eid;
    private String Rfid;
    private String ChkStatus;
    private Long uniqueNum; //外键，保存对应UploadRptChkIInfoList对应的id
    @Generated(hash = 425573845)
    public EqListEntity(Long id, String Eid, String Rfid, String ChkStatus,
            Long uniqueNum) {
        this.id = id;
        this.Eid = Eid;
        this.Rfid = Rfid;
        this.ChkStatus = ChkStatus;
        this.uniqueNum = uniqueNum;
    }
    @Generated(hash = 373918953)
    public EqListEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEid() {
        return this.Eid;
    }
    public void setEid(String Eid) {
        this.Eid = Eid;
    }
    public String getRfid() {
        return this.Rfid;
    }
    public void setRfid(String Rfid) {
        this.Rfid = Rfid;
    }
    public String getChkStatus() {
        return this.ChkStatus;
    }
    public void setChkStatus(String ChkStatus) {
        this.ChkStatus = ChkStatus;
    }
    public Long getUniqueNum() {
        return this.uniqueNum;
    }
    public void setUniqueNum(Long uniqueNum) {
        this.uniqueNum = uniqueNum;
    }
    
    
}
