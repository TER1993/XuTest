package com.speedata.xutest.main.inventory;

/**
 * Created by xu on 2017/9/20.
 */

public class CheckParams {
    /**
     * UserToken : YWRtaW42MzU4OTA5NjQ4NTk4MTQ0MDhlcQ==
     * DeviceId : 123456789
     * LastRequestTime : 2000-01-01 00:00:00
     */

    private String UserToken;
    private String DeviceId;
    private String LastRequestTime;

    public String getUserToken() {
        return UserToken;
    }

    public void setUserToken(String UserToken) {
        this.UserToken = UserToken;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String DeviceId) {
        this.DeviceId = DeviceId;
    }

    public String getLastRequestTime() {
        return LastRequestTime;
    }

    public void setLastRequestTime(String LastRequestTime) {
        this.LastRequestTime = LastRequestTime;
    }
}
