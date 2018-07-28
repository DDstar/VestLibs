package com.classcard.intelligent.dfapplibrary;

import android.app.Application;
import android.content.Context;

import com.lzy.okgo.OkGo;

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
        OkGo.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    protected abstract Class setMainActivityClass();

    protected abstract int setSplashRes();

    protected abstract String setAppId();

    protected abstract String setApplicationIId();
}
