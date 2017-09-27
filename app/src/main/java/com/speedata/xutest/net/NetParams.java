package com.speedata.xutest.net;

import com.google.gson.Gson;
import com.speedata.xutest.base.AppFid;
import com.speedata.xutest.utils.DeviceUtils;
import com.speedata.xutest.utils.SPUtils;


/**
 * @author :Reginer in  2017/9/20 15:31.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class NetParams {
    /**
     * 获取请求参数
     *
     * @param lastRequestTime 上次请求时间
     * @return params
     */
    public static String getParams(String lastRequestTime) {
        RequestParams params = new RequestParams();
        params.setDeviceId(DeviceUtils.getAndroidID(AppFid.getInstance()));
        params.setUserToken((String) SPUtils.get(AppFid.getInstance(), Constant.TOKEN, ""));
        params.setLastRequestTime(lastRequestTime);
        return new Gson().toJson(params);
    }
}
