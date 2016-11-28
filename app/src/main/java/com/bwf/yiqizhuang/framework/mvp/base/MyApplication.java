package com.bwf.yiqizhuang.framework.mvp.base;

import android.app.Application;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Log.d("QingdanApplication", "onCreate");
    }
}
