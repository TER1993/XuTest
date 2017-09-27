package com.speedata.xutest.login;

/**
 * @author :Reginer in  2017/9/19 15:57.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class LoginEntity {


    /**
     * ErrCode : 1
     * ErrMsg :
     * UserAccount : admin
     * UserToken : YWRtaW42MzU4OTA5NjQ4NTk4MTQ0MDhlcQ==
     * TokenViladeDate : 2019-11-22
     * SysDate : 2017-09-19 16:41:01
     */

    private String ResponseCode;
    private String ErrMsg;
    private String UserAccount;
    private String UserToken;
    private String TokenViladeDate;
    private String SysDate;

    public String getErrCode() {
        return ResponseCode;
    }

    public void setErrCode(String ErrCode) {
        this.ResponseCode = ErrCode;
    }

    public String getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(String ErrMsg) {
        this.ErrMsg = ErrMsg;
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String UserAccount) {
        this.UserAccount = UserAccount;
    }

    public String getUserToken() {
        return UserToken;
    }

    public void setUserToken(String UserToken) {
        this.UserToken = UserToken;
    }

    public String getTokenViladeDate() {
        return TokenViladeDate;
    }

    public void setTokenViladeDate(String TokenViladeDate) {
        this.TokenViladeDate = TokenViladeDate;
    }

    public String getSysDate() {
        return SysDate;
    }

    public void setSysDate(String SysDate) {
        this.SysDate = SysDate;
    }
}
