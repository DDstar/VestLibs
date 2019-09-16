package com.home.vestapplibmanager;

import android.app.Application;

import com.home.vestlibs.VestHelper;

/**
 * Created by DDStar on 2018/7/23.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VestHelper.init(this, MainActivity.class, R.drawable.choose_game_single_player, "1200000", BuildConfig.APPLICATION_ID);
        VestHelper.getInstance().setDownBg(R.mipmap.sp158_);
    }
}
