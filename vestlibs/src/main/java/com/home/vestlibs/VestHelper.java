package com.home.vestlibs;

import android.app.Application;

import com.lzy.okgo.OkGo;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by DDStar on 2019/1/22.
 */
public class VestHelper {
    private Class mainClass;
    private int splashRes;
    private static VestHelper instance;
    private String appId;
    private String applicationId;
    private int downBg = R.drawable.update_bg;

    public VestHelper(Class mainClass, int splashRes, String appId, String applicationId) {
        this.mainClass = mainClass;
        this.splashRes = splashRes;
        this.appId = appId;
        this.applicationId = applicationId;
    }

    public static void init(Application application, Class mainClass, int splashRes, String appId, String applicationId) {
        if (instance == null) {
            instance = new VestHelper(mainClass, splashRes, appId, applicationId);
        }
        JPushInterface.setDebugMode(true);
        JPushInterface.init(application);
        OkGo.init(application);
    }

    public Class getMainClass() {
        return mainClass;
    }

    public void setMainClass(Class mainClass) {
        this.mainClass = mainClass;
    }

    public int getSplashRes() {
        return splashRes;
    }

    public void setSplashRes(int splashRes) {
        this.splashRes = splashRes;
    }

    public static VestHelper getInstance() {
        return instance;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public int getDownBg() {
        return downBg;
    }

    public void setDownBg(int downBg) {
        this.downBg = downBg;
    }
}
