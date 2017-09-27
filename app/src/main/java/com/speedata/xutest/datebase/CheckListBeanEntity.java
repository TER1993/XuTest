package com.speedata.xutest.datebase;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

/**
 * Created by xu on 2017/9/20.
 */
@Entity
public class CheckListBeanEntity {

        /**
         * ChkId : 1
         * ChkName : 盘点名称001
         * ChkAccount : admin
         * CreateAccount : admin
         * CreateTime : 2017-01-01 08:00:00
         * ProjList : [{"ProjId":"1"},{"ProjId":"2"}]
         * EqList : [{"EqId": "1"},{"EqId": "2"}]
         */
        @Id
        private Long id;
        @Unique
        private String ChkId;
        private String ChkName;
        private String ChkAccount;
        private String CreateAccount;
        private String CreateTime;
        @ToMany(referencedJoinProperty = "uniqueNum")
        private List<ProjListBean> ProjList;
        @ToMany(referencedJoinProperty = "uniqueNum")
        private List<EqListBean> EqList;
        /** Used to resolve relations */
        @Generated(hash = 2040040024)
        private transient DaoSession daoSession;
        /** Used for active entity operations. */
        @Generated(hash = 1210212686)
        private transient CheckListBeanEntityDao myDao;
        @Generated(hash = 1150283645)
        public CheckListBeanEntity(Long id, String ChkId, String ChkName,
                String ChkAccount, String CreateAccount, String CreateTime) {
            this.id = id;
            this.ChkId = ChkId;
            this.ChkName = ChkName;
            this.ChkAccount = ChkAccount;
            this.CreateAccount = CreateAccount;
            this.CreateTime = CreateTime;
        }
        @Generated(hash = 174575099)
        public CheckListBeanEntity() {
        }
        public Long getId() {
            return this.id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getChkId() {
            return this.ChkId;
        }
        public void setChkId(String ChkId) {
            this.ChkId = ChkId;
        }
        public String getChkName() {
            return this.ChkName;
        }
        public void setChkName(String ChkName) {
            this.ChkName = ChkName;
        }
        public String getChkAccount() {
            return this.ChkAccount;
        }
        public void setChkAccount(String ChkAccount) {
            this.ChkAccount = ChkAccount;
        }
        public String getCreateAccount() {
            return this.CreateAccount;
        }
        public void setCreateAccount(String CreateAccount) {
            this.CreateAccount = CreateAccount;
        }
        public String getCreateTime() {
            return this.CreateTime;
        }
        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }
        /**
         * To-many relationship, resolved on first access (and after reset).
         * Changes to to-many relations are not persisted, make changes to the target entity.
         */
        @Generated(hash = 1704550998)
        public List<ProjListBean> getProjList() {
            if (ProjList == null) {
                final DaoSession daoSession = this.daoSession;
                if (daoSession == null) {
                    throw new DaoException("Entity is detached from DAO context");
                }
                ProjListBeanDao targetDao = daoSession.getProjListBeanDao();
                List<ProjListBean> ProjListNew = targetDao
                        ._queryCheckListBeanEntity_ProjList(id);
                synchronized (this) {
                    if (ProjList == null) {
                        ProjList = ProjListNew;
                    }
                }
            }
            return ProjList;
        }
        /** Resets a to-many relationship, making the next get call to query for a fresh result. */
        @Generated(hash = 1848013941)
        public synchronized void resetProjList() {
            ProjList = null;
        }
        /**
         * To-many relationship, resolved on first access (and after reset).
         * Changes to to-many relations are not persisted, make changes to the target entity.
         */
        @Generated(hash = 263259578)
        public List<EqListBean> getEqList() {
            if (EqList == null) {
                final DaoSession daoSession = this.daoSession;
                if (daoSession == null) {
                    throw new DaoException("Entity is detached from DAO context");
                }
                EqListBeanDao targetDao = daoSession.getEqListBeanDao();
                List<EqListBean> EqListNew = targetDao
                        ._queryCheckListBeanEntity_EqList(id);
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
        @Generated(hash = 1277152106)
        public void __setDaoSession(DaoSession daoSession) {
            this.daoSession = daoSession;
            myDao = daoSession != null ? daoSession.getCheckListBeanEntityDao() : null;
        }

}
