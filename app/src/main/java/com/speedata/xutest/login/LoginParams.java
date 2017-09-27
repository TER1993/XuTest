package com.speedata.xutest.login;

/**
 * @author :Reginer in  2017/9/19 14:56.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class LoginParams {

    /**
     * UserAccount : admin
     * UserPwd : MDAwMA==
     */

    private String UserAccount;
    private String UserPwd;
    private String DeviceId;

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String UserAccount) {
        this.UserAccount = UserAccount;
    }

    public String getUserPwd() {
        return UserPwd;
    }

    public void setUserPwd(String UserPwd) {
        this.UserPwd = UserPwd;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }
}
