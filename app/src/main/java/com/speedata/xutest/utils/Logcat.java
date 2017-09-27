package com.speedata.xutest.utils;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;


/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 *
 * @author Reginer on 2016/5/24 19:40.
 *         Logcat统一管理类
 */

public class Logcat {

    private Logcat() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static final String TAG = "Reginer";

    // 下面四个是默认tag的函数

    /**
     * i.
     *
     * @param msg msg
     */
    public static void i(String msg) {
            Log.i(TAG, msg);
    }

    /**
     * d.
     *
     * @param msg msg
     */
    public static void d(String msg) {
            Log.d(TAG, msg);
    }

    /**
     * e.
     *
     * @param msg msg
     */
    public static void e(String msg) {
            Log.e(TAG, msg);
    }

    /**
     * e.
     *
     * @param msg msg
     */
    public static void e(Throwable msg) {
            Writer writer = new StringWriter();
            PrintWriter pw = new PrintWriter(writer);
            msg.printStackTrace(pw);
            Log.e(TAG, writer.toString());
    }


    /**
     * v.
     *
     * @param msg msg
     */
    public static void v(String msg) {
            Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数

    /**
     * i.
     *
     * @param tag tag
     * @param msg msg
     */
    public static void i(String tag, String msg) {
            Log.i(tag, msg);
    }

    /**
     * d.
     *
     * @param tag tag
     * @param msg msg
     */
    public static void d(String tag, String msg) {
            Log.i(tag, msg);
    }

    /**
     * e.
     *
     * @param tag tag
     * @param msg msg
     */
    public static void e(String tag, String msg) {
            Log.i(tag, msg);
    }

    /**
     * v.
     *
     * @param tag tag
     * @param msg msg
     */
    public static void v(String tag, String msg) {
            Log.i(tag, msg);
    }
}