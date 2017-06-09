package com.windman.trainings.Base;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;


/**
 * Created by Vtrump on 2017/3/20.
 */

public class WindManApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}
