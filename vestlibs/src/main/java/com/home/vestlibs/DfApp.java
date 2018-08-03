package com.home.vestlibs;

import android.app.Application;

import com.lzy.okgo.OkGo;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by DDStar on 2018/7/19.
 */
public abstract class DfApp extends Application {
    private Class mainClass;
    private int splashRes;
    private static DfApp instance;
    private String appId;
    private String applicationId;


    public String getApplicationId() {
        return applicationId;
    }

    public String getAppId() {
        return appId;
    }

    public static DfApp getInstance() {
        return instance;
    }

    public Class getMainClass() {
        return mainClass;
    }

    public int getSplashRes() {
        return splashRes;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mainClass = setMainActivityClass();
        splashRes = setSplashRes();
        appId = setAppId();
        applicationId = setApplicationIId();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        OkGo.init(this);
    }

    protected abstract Class setMainActivityClass();

    protected abstract int setSplashRes();

    protected abstract String setAppId();

    protected abstract String setApplicationIId();
}
