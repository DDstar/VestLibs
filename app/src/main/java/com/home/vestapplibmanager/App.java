package com.home.vestapplibmanager;

import com.home.vestlibs.DfApp;
import com.home.vestlibs.VestType;

/**
 * Created by DDStar on 2018/7/23.
 */
public class App extends DfApp {
    @Override
    protected Class setMainActivityClass() {
        return MainActivity.class;
    }

    @Override
    protected VestType setVestType() {
        return VestType.VEST_TYPE_1;
    }

    @Override
    protected int setSplashRes() {
        return R.mipmap.ic_launcher;
    }

    @Override
    protected String setAppId() {
        return "newxk20180719005";
    }

    @Override
    protected String setApplicationIId() {
        return BuildConfig.APPLICATION_ID;
    }
}
