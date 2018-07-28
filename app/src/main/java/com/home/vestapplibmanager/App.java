package com.home.vestapplibmanager;

import com.home.vestlibs.DfApp;
import com.home.vestlibs.VestType;

/**
 * Created by DDStar on 2018/7/23.
 */
public class App extends DfApp {
    @Override
    protected Class setMainActivityClass() {
        //返回壳子的首页
        return MainActivity.class;
    }

    @Override
    protected VestType setVestType() {
        //设置cp类型
        return VestType.VEST_TYPE_1;
    }

    @Override
    protected int setSplashRes() {
        //返回欢迎页的图片资源
        return R.mipmap.ic_launcher;
    }

    @Override
    protected String setAppId() {
        //id
        return "newxk20180719005";
    }

    @Override
    protected String setApplicationIId() {
        //返回应用id
        return BuildConfig.APPLICATION_ID;
    }
}
