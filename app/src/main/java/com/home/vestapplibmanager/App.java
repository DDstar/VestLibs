package com.home.vestapplibmanager;

import android.app.Application;

/**
 * Created by DDStar on 2018/7/23.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        VestHelper.init(this, MainActivity.class, R.mipmap.ic_launcher, "xk20190128001", BuildConfig.APPLICATION_ID);
    }

    //    @Override
//    protected Class setMainActivityClass() {
//        //返回壳子的首页
//        return MainActivity.class;
//    }
//
//    @Override
//    protected int setSplashRes() {
//        //返回欢迎页的图片资源
//        return R.mipmap.ic_launcher;
//    }
//
//    @Override
//    protected String setAppId() {
//        return "xk181226001";
//    }
//
//    @Override
//    protected String setApplicationIId() {
//        //返回应用id
//        return BuildConfig.APPLICATION_ID;
//    }
}
