package com.zrdev.xposedhook4lp.hook;

import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by initialize on 2018/8/25.
 */

public class Entry implements IXposedHookLoadPackage {
    private static final String TARGET_PACKAGE_NAME = "com.lptiyu.tanke";
    protected static ClassLoader classLoader = null;
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals(TARGET_PACKAGE_NAME)){
            if(classLoader == null){
                /*有Legu加固,需要使用加固后的类入口获取ClassLoader来替换掉默认ClassLoader,不然会报ClassNotFoundException异常*/
                XposedHelpers.findAndHookMethod("com.tencent.StubShell.TxAppEntry", loadPackageParam.classLoader,
                        "attachBaseContext", Context.class, new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                super.afterHookedMethod(param);
                                ClassLoader classLoader = ((Context) param.args[0]).getClassLoader();
                                Entry.this.setClassLoader(classLoader);
                                HookAntiHookUtils.handleLoadPackageParam(classLoader);
                                HookInstallUtils.handleLoadPackageParam(classLoader);
                                HookJniAnti.handleLoadPackageParam(classLoader);
                                HookDeviceUtils.handleLoadPackageParam(classLoader);
                            }
                        });
            }else{
                HookAntiHookUtils.handleLoadPackageParam(classLoader);
                HookInstallUtils.handleLoadPackageParam(classLoader);
                HookJniAnti.handleLoadPackageParam(classLoader);
                HookDeviceUtils.handleLoadPackageParam(classLoader);
            }
        }
    }
    protected void setClassLoader(ClassLoader classLoader){
        this.classLoader = classLoader;
    }
}
