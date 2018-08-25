package com.zrdev.xposedhook4lp.hook;

import android.content.Context;

import com.zrdev.xposedhook4lp.utils.ZRLog;

import org.json.JSONObject;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/*
* Hook检测设备环境等方法,重点是isEmulator与isRunningOnVirtualDevice方法,检测是否为android模拟器等,使其全部返回false
* isSupportKitkatWithStepSensor方法为检测是否有高精度记步传感器,Hook后直接返回false,强制使其使用加速度传感器,配合运动模拟器效果更佳
* 其他方法可忽略
* */
public class HookDeviceUtils {
    private static final String TAG = "com.zrdev.xpo...4lp.hook.HookDeviceUtils";
    private static final String ClazzPath0 = "com.lptiyu.tanke.utils.DeviceUtils";
    private static final String Method0_0 = "isEmulator";
    private static final String Method0_1 = "getDeviceInfo";
    private static final String Method0_2 = "getUniquePsuedoID";
    private static final String Method0_3 = "getUniversalID";
    private static final String Method0_4 = "isSupportKitkatWithStepSensor";
    private static final String Method0_5 = "isRunningOnVirtualDevice";

    public static void handleLoadPackageParam(ClassLoader classLoader) throws Throwable{
        Class clazz = classLoader.loadClass(ClazzPath0);
        try{
            XposedHelpers.findAndHookMethod(clazz, Method0_0,
                    new XC_MethodHook() {
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                        }

                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            param.setResult(false);
                            ZRLog.i(TAG, "Method0_0(isEmulator) return value has been changed.");
                        }
                    }
            );
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            XposedHelpers.findAndHookMethod(clazz, Method0_1, Context.class,
                    new XC_MethodHook() {
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                        }

                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            JSONObject jsonObject = (JSONObject)param.getResult();
                            ZRLog.i(TAG, "Method0_1(getDeviceInfo) return value is:\n" + jsonObject.toString());
                        }
                    }
            );
        }catch (Exception e){
            e.printStackTrace();
        }
//        /*实测Hook这个方法会报MethodNotFoundException异常,暂时注释*/
//        XposedHelpers.findAndHookMethod(clazz, Method0_2,
//                new XC_MethodHook() {
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//                    }
//
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        String s = (String) param.getResult();
//                        ZRLog.i(TAG, "Method0_2(getUniquePsuedoID) return value is:\n" + s);
//                    }
//                }
//        );

        try{
            XposedHelpers.findAndHookMethod(clazz, Method0_3, Context.class,
                    new XC_MethodHook() {
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                        }

                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            String s = (String)param.getResult();
                            ZRLog.i(TAG, "Method0_3(getUniversalID) return value is:\n" + s);
                        }
                    }
            );
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            XposedHelpers.findAndHookMethod(clazz, Method0_4,
                    new XC_MethodHook() {
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                        }

                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            param.setResult(false);
                            ZRLog.i(TAG, "Method0_4(isSupportKitkatWithStepSensor) return value has been changed.");
                        }
                    }
            );
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            XposedHelpers.findAndHookMethod(clazz, Method0_5,
                    new XC_MethodHook() {
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                        }

                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            param.setResult(false);
                            ZRLog.i(TAG, "Method0_5(isRunningOnVirtualDevice) return value has been changed.");
                        }
                    }
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
