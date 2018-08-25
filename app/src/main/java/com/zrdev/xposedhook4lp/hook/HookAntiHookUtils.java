package com.zrdev.xposedhook4lp.hook;

import com.zrdev.xposedhook4lp.utils.ZRLog;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/**
 * Created by initialize on 2018/8/25.
 */

/*
* Hook检测系统环境是否异常的方法,使其全部返回false
* */
public class HookAntiHookUtils{
    private static final String TAG = "com.zrdev.xpo...4lp.hook.HookAntiHookUtils";
    private static final String ClazzPath0 = "com.lptiyu.tanke.utils.AntiHookUtils";
    private static final String Method0_0 = "detect_1";
    private static final String Method0_1 = "detect_2";

    public static void handleLoadPackageParam(ClassLoader classLoader) throws Throwable{
        Class clazz = classLoader.loadClass(ClazzPath0);
        try{

        }catch (Exception e){

        }
        XposedHelpers.findAndHookMethod(clazz, Method0_0,
                new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(false);
                        ZRLog.i(TAG, "Method0_0(detect_1) return value has been changed.");
                    }
                }
        );
        try{

        }catch (Exception e){

        }
        XposedHelpers.findAndHookMethod(clazz, Method0_1,
                new XC_MethodHook() {
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(false);
                        ZRLog.i(TAG, "Method0_1(detect_2) return value has been changed.");
                    }
                }
        );
    }
}
