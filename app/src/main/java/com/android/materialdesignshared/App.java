package com.android.materialdesignshared;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Application
 *
 * @Description: App
 * @Author: ZhaoRuYang
 * @Update: ZhaoRuYang(2015-11-09 15:41)
 */
public class App extends Application {
    private static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化OOM检测
        LeakCanary.install(this);
    }
}
