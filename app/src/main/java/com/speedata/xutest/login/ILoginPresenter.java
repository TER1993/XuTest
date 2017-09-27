package com.speedata.xutest.login;

/**
 * @author :Reginer in  2017/9/18 19:29.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public interface ILoginPresenter {
    /**
     * 登录.
     *
     * @param username 账号
     * @param pwd      密码
     */
    void doLogin(String username, String pwd);
}
