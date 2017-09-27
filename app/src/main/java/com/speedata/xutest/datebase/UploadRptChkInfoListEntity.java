package com.speedata.xutest.datebase;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

/**
 * Created by xu on 2017/9/23.
 *
 * 用于盘点上传
 */
@Entity
public class UploadRptChkInfoListEntity {
    @Id
    private Long id;
    private String UserToken; //使用用户Token
    private String DeviceId; //资产唯一编号
    @Unique
    private String ChkId; //盘点ID
    private String AllCount; //待盘点资产数量
    private String ChkAllCount; //盘点资产数量
    private String InventoryProfitCount; //盘盈数量
    private String InventoryShortagesCount; //盘亏数量
    private String ChkDate; //盘点日期
    private String ChkAccount; //盘点人

    private boolean UploadAlready; //记录上传状态,默认false未上传，上传成功记录为true
    private String ChechName; //记录此盘点单名

    @ToMany(referencedJoinProperty = "uniqueNum")
    private List<EqListEntity> EqList; //盘点的结果list
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1806374150)
    private transient UploadRptChkInfoListEntityDao myDao;

    @Generated(hash = 252542024)
    public UploadRptChkInfoListEntity(Long id, String UserToken, String DeviceId,
            String ChkId, String AllCount, String ChkAllCount,
            String InventoryProfitCount, String InventoryShortagesCount,
            String ChkDate, String ChkAccount, boolean UploadAlready,
            String ChechName) {
        this.id = id;
        this.UserToken = UserToken;
        this.DeviceId = DeviceId;
        this.ChkId = ChkId;
        this.AllCount = AllCount;
        this.ChkAllCount = ChkAllCount;
        this.InventoryProfitCount = InventoryProfitCount;
        this.InventoryShortagesCount = InventoryShortagesCount;
        this.ChkDate = ChkDate;
        this.ChkAccount = ChkAccount;
        this.UploadAlready = UploadAlready;
        this.ChechName = ChechName;
    }

    @Generated(hash = 1109949674)
    public UploadRptChkInfoListEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserToken() {
        return this.UserToken;
    }

    public void setUserToken(String UserToken) {
        this.UserToken = UserToken;
    }

    public String getDeviceId() {
        return this.DeviceId;
    }

    public void setDeviceId(String DeviceId) {
        this.DeviceId = DeviceId;
    }

    public String getChkId() {
        return this.ChkId;
    }

    public void setChkId(String ChkId) {
        this.ChkId = ChkId;
    }

    public String getAllCount() {
        return this.AllCount;
    }

    public void setAllCount(String AllCount) {
        this.AllCount = AllCount;
    }

    public String getChkAllCount() {
        return this.ChkAllCount;
    }

    public void setChkAllCount(String ChkAllCount) {
        this.ChkAllCount = ChkAllCount;
    }

    public String getInventoryProfitCount() {
        return this.InventoryProfitCount;
    }

    public void setInventoryProfitCount(String InventoryProfitCount) {
        this.InventoryProfitCount = InventoryProfitCount;
    }

    public String getInventoryShortagesCount() {
        return this.InventoryShortagesCount;
    }

    public void setInventoryShortagesCount(String InventoryShortagesCount) {
        this.InventoryShortagesCount = InventoryShortagesCount;
    }

    public String getChkDate() {
        return this.ChkDate;
    }

    public void setChkDate(String ChkDate) {
        this.ChkDate = ChkDate;
    }

    public String getChkAccount() {
        return this.ChkAccount;
    }

    public void setChkAccount(String ChkAccount) {
        this.ChkAccount = ChkAccount;
    }

    public boolean getUploadAlready() {
        return this.UploadAlready;
    }

    public void setUploadAlready(boolean UploadAlready) {
        this.UploadAlready = UploadAlready;
    }

    public String getChechName() {
        return this.ChechName;
    }

    public void setChechName(String ChechName) {
        this.ChechName = ChechName;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 888510485)
    public List<EqListEntity> getEqList() {
        if (EqList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EqListEntityDao targetDao = daoSession.getEqListEntityDao();
            List<EqListEntity> EqListNew = targetDao
                    ._queryUploadRptChkInfoListEntity_EqList(id);
            synchronized (this) {
                if (EqList == null) {
                    EqList = EqListNew;
                }
            }
        }
        return EqList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1652769646)
    public synchronized void resetEqList() {
        EqList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1088755469)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUploadRptChkInfoListEntityDao() : null;
    }
 

}
