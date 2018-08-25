package com.zrdev.xposedhook4lp.hook;

import com.zrdev.xposedhook4lp.utils.ZRLog;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/**
 * Created by initialize on 2018/8/25.
 */
/*
* Hook掉检测是否有装运动模拟器GPS修改器类APP方法
* 经测试目前被检测的APP包名如下(此列表从服务端获得,估计以后会有改动)
* com.deniu.daniu
* com.txy.anywhere
* com.miaoding.ui
* top.a1024bytes.mockloc.ca.pro
* net.anylocation
* de.robv.android.xposed.installer
* com.saurik.substrate
* com.qgwapp.shadowside
* com.rong.xposed.fakelocation
* com.phoneinfo.changerpro
* com.qianbajin.sportaccelerator
* com.specher.sm
* com.example.myxposed
* name.caiyao.fakegps
* net.superal
* */
public class HookInstallUtils{

    private static final String TAG = "com.zrdev.xpo...4lp.hook.HookInstallUtils";
    private static final String ClazzPath0 = "com.lptiyu.tanke.utils.InstallUtils";
    private static final String Method0_0 = "isAppInstalled";

    public static void handleLoadPackageParam(ClassLoader classLoader) throws Throwable{
        Class clazz = classLoader.loadClass(ClazzPath0);
        try{
            XposedHelpers.findAndHookMethod(clazz, Method0_0, String.class,
                    new XC_MethodHook() {
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                            ZRLog.i(TAG,"Method0_0 param0(packageName): " + (String) param.args[0]);
                        }

                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            param.setResult(false);
                            ZRLog.i(TAG,"Method0_0(isAppInstalled) return value has been changed.");
                        }
                    }
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
