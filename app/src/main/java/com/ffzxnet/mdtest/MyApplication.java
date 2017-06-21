package com.ffzxnet.mdtest;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 创建者： feifan.pi 在 2017/3/27.
 */

public class MyApplication extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        context=this;
    }
}
