package com.speedata.xutest.utils;

import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.speedata.xutest.base.AppFid;


/**
 * @author :Reginer in  2017/9/22 13:57.
 *         联系方式:QQ:282921012
 *         功能描述:
 */
public class ViewSetUtils {
    public static void setStatusText(TextView textView, String status) {
        if ("1".equals(status)) {
            textView.setTextColor(ContextCompat.getColor(AppFid.getInstance(), android.R.color.holo_green_light));
        } else if ("5".equals(status)) {
            textView.setTextColor(ContextCompat.getColor(AppFid.getInstance(), android.R.color.holo_blue_light));
        } else if ("6".equals(status)) {
            textView.setTextColor(ContextCompat.getColor(AppFid.getInstance(), android.R.color.holo_orange_light));
        } else if ("7".equals(status)) {
            textView.setTextColor(ContextCompat.getColor(AppFid.getInstance(), android.R.color.holo_red_light));
        } else {
            textView.setTextColor(ContextCompat.getColor(AppFid.getInstance(), android.R.color.black));
        }
    }

    public static void setOverageOrLossText(TextView textView, int status) {
        if (status == 1) {
            textView.setTextColor(ContextCompat.getColor(AppFid.getInstance(), android.R.color.holo_green_light));
        } else if (status == 2) {
            textView.setTextColor(ContextCompat.getColor(AppFid.getInstance(), android.R.color.black));
        } else if (status == 0) {
            textView.setTextColor(ContextCompat.getColor(AppFid.getInstance(), android.R.color.holo_red_light));
        } else {
            textView.setTextColor(ContextCompat.getColor(AppFid.getInstance(), android.R.color.black));
        }
    }

    public static void setUploadAlreadyText(TextView textView, boolean status) {
        if (status) {
            textView.setTextColor(ContextCompat.getColor(AppFid.getInstance(), android.R.color.holo_green_light));
        } else {
            textView.setTextColor(ContextCompat.getColor(AppFid.getInstance(), android.R.color.holo_red_light));
        }
    }
}
