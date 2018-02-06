package com.speedata.xutest.Utils;

import android.app.Application;


/**
 * 继承Application
 *
 * @author TER
 * @date 2018/1/25
 */

public class AppScan extends Application {

    private static AppScan sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static AppScan getInstance() {
        return sInstance;
    }
}
