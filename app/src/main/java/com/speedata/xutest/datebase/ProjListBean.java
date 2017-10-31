package com.speedata.xutest.datebase;

import java.io.Serializable;

/**
 * Created by xu on 2017/9/21.
 */

public class ProjListBean implements Serializable {
    /**
     * ProjId : 1
     */

    private Long id;

    private String ProjId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjId() {
        return ProjId;
    }

    public void setProjId(String projId) {
        ProjId = projId;
    }
}
