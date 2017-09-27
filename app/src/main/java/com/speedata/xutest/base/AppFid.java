package com.speedata.xutest.base;

import android.app.Application;

import com.speedata.xutest.datebase.GreenDaoManager;


/**
 * @author :Reginer in  2017/9/18 19:06.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class AppFid extends Application {
    private static AppFid sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initConfig();
    }

    private void initConfig() {
        GreenDaoManager.init(this);
    }


    public static AppFid getInstance() {
        return sInstance;
    }
}
