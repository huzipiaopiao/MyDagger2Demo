package com.ssdt.banbury.mydagger2demo;

import android.app.Application;
import android.content.Context;

import com.ssdt.banbury.mydagger2demo.dagger.component.BaseComponent;
import com.ssdt.banbury.mydagger2demo.dagger.component.DaggerBaseComponent;
import com.ssdt.banbury.mydagger2demo.dagger.module.BaseModule;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/22_9:29.
 * @description
 *
 * demo参考的是简书：http://www.jianshu.com/p/1d84ba23f4d2
 */

public class MyApplication extends Application {


    private BaseComponent baseComponent;
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        baseComponent = DaggerBaseComponent.builder().baseModule(new BaseModule()).build();
    }

    public BaseComponent getBaseComponent() {
        return baseComponent;
    }
}
