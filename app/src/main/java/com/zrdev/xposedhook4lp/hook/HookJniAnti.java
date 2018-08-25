package com.zrdev.xposedhook4lp.hook;

import android.content.Context;

import com.zrdev.xposedhook4lp.utils.ZRLog;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/**
 * Created by initialize on 2018/8/25.
 */

/*
* Hook掉反Hook方法,返回为false
* */
public class HookJniAnti{

    private static final String TAG = "com.zrdev.xpo...4lp.hook.HookJniAnti";
    private static final String ClazzPath0 = "com.lptiyu.tanke.emulator.JniAnti";
    private static final String Method0_0 = "anti";

    public static void handleLoadPackageParam(ClassLoader classLoader) throws Throwable{
        Class clazz = classLoader.loadClass(ClazzPath0);
        try{
            XposedHelpers.findAndHookMethod(clazz, Method0_0, Context.class,
                    new XC_MethodHook() {
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                        }

                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            param.setResult(false);
                            ZRLog.i(TAG,"Method0_0(anti) return value has been changed.");
                        }
                    }
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
