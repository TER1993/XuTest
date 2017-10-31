package com.speedata.xutest.datebase;

import java.io.Serializable;

/**
 * Created by xu on 2017/9/21.
 */

public class EqListBean implements Serializable {
    /**
     * EqId : 1
     */

    private Long id;

    private String EqId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEqId() {
        return EqId;
    }

    public void setEqId(String eqId) {
        EqId = eqId;
    }
}
