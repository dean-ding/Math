package com.tvt.math;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created: 1895 on 2020/6/18 10:46
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
        ARouter.openDebug();
        ARouter.openLog();
    }
}
