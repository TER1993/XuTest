package com.speedata.xutest.datebase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * @author :Reginer in  2017/9/20 16:48.
 *         联系方式:QQ:282921012
 *         功能描述:资产分类信息
 */
@Entity
public class CateListEntity {
    /**
     * Cid : 1
     * CategoryName : c01
     * ParentId :
     */
    @Id
    private Long id;
    @Unique
    private String Cid;
    private String CategoryName;
    private String ParentId;

    @Generated(hash = 1130480350)
    public CateListEntity(Long id, String Cid, String CategoryName,
            String ParentId) {
        this.id = id;
        this.Cid = Cid;
        this.CategoryName = CategoryName;
        this.ParentId = ParentId;
    }

    @Generated(hash = 2000676739)
    public CateListEntity() {
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String Cid) {
        this.Cid = Cid;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String ParentId) {
        this.ParentId = ParentId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
