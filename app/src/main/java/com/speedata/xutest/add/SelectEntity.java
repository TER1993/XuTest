package com.speedata.xutest.add;

/**
 * @author :Reginer in  2017/9/22 16:10.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class SelectEntity {
    private String code;
    private String show;

    SelectEntity(String code, String show) {
        this.code = code;
        this.show = show;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    String getShow() {
        return show;
    }


}
