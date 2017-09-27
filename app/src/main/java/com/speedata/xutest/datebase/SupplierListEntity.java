package com.speedata.xutest.datebase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @author :Reginer in  2017/9/21 14:27.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
@Entity
public class SupplierListEntity {
    /**
     * SupplierId : 1
     * SupplierName : s01
     * LinkMan :
     * LinkPhone :
     * LinkQq :
     */
    @Id
    private Long id;
    @Unique
    private String SupplierId;
    private String SupplierName;
    private String LinkMan;
    private String LinkPhone;
    private String LinkQq;

    @Generated(hash = 542337581)
    public SupplierListEntity(Long id, String SupplierId, String SupplierName,
            String LinkMan, String LinkPhone, String LinkQq) {
        this.id = id;
        this.SupplierId = SupplierId;
        this.SupplierName = SupplierName;
        this.LinkMan = LinkMan;
        this.LinkPhone = LinkPhone;
        this.LinkQq = LinkQq;
    }

    @Generated(hash = 1005981726)
    public SupplierListEntity() {
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String SupplierId) {
        this.SupplierId = SupplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public String getLinkMan() {
        return LinkMan;
    }

    public void setLinkMan(String LinkMan) {
        this.LinkMan = LinkMan;
    }

    public String getLinkPhone() {
        return LinkPhone;
    }

    public void setLinkPhone(String LinkPhone) {
        this.LinkPhone = LinkPhone;
    }

    public String getLinkQq() {
        return LinkQq;
    }

    public void setLinkQq(String LinkQq) {
        this.LinkQq = LinkQq;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
