package com.speedata.xutest.Utils;

import android.content.Intent;

import static com.speedata.xutest.Utils.BaseConstant.SCAN;

/**
 * @author :xu in  2018/2/6 11:02.
 *         联系方式:QQ:2419646399
 *         功能描述:
 */
public class BaseUtil {

    /**
     * 将扫描结果放在焦点上
     *
     */
    public static void sendBroadcasts() {
        Intent intents = new Intent();
        intents.setAction(SCAN);
        AppScan.getInstance().sendBroadcast(intents);
    }
}
