package com.home.vestapplibmanager;

import com.home.vestlibs.V211App;

/**
 * Created by DDStar on 2018/7/23.
 */
public class App extends V211App {
    @Override
    protected Class setMainActivityClass() {
        //返回壳子的首页
        return MainActivity.class;
    }

    @Override
    protected int setSplashRes() {
        //返回欢迎页的图片资源
        return R.mipmap.ic_launcher;
    }

    @Override
    protected String setAppId() {
        return "jiabai365tyqianggeng";
    }

    @Override
    protected int setDownloadBg() {
        return R.mipmap.ic_launcher;
    }

    @Override
    protected String setApplicationIId() {
        //返回应用id
        return BuildConfig.APPLICATION_ID;
    }
}
