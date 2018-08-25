package com.zrdev.xposedhook4lp.utils;

import android.util.Log;

/**
 * Created by initialize on 2018/8/25.
 */

public class ZRLog {
    public static void d(String tag, String msg){
        Log.d(tag, msg);
    }

    public static void i(String tag, String msg){
        Log.i(tag, msg);
    }

    public static void e(String tag, String msg){
        Log.e(tag, msg);
    }

    public static void v(String tag, String msg){
        Log.v(tag, msg);
    }

    public static void w(String tag, String msg){
        Log.w(tag, msg);
    }


    public static void d(String tag, String msg, Throwable th){
        Log.d(tag, msg, th);
    }

    public static void i(String tag, String msg, Throwable th){
        Log.i(tag, msg, th);
    }

    public static void e(String tag, String msg, Throwable th){
        Log.e(tag, msg, th);
    }

    public static void v(String tag, String msg, Throwable th){
        Log.v(tag, msg, th);
    }

    public static void w(String tag, String msg, Throwable th){
        Log.w(tag, msg, th);
    }

}
