package com.home.vestlibs;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by DDStar on 2018/2/25.
 */

public class DataRequest {

    public static void getSplashVestType1Config(final SplashCallback callback) {
        OkGo.get("http://df0234.com:8081/?appId=" + VestApp.getInstance().getAppId())
//        OkGo.get("http://app.27305.com/appid.php?appid=1806051526")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        SplashConfig splashConfig = new Gson().fromJson(s, SplashConfig.class);
                        if (splashConfig != null) {
                            try {
                                callback.onSuccess(Integer.valueOf(splashConfig.getStatus()) == 1, splashConfig.getUrl());
                            } catch (Exception e) {
                                callback.onFail("数据异常");
                            }
                        } else {
                            callback.onFail("数据异常");
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        callback.onFail("数据异常");
                    }
                });
    }

    public static void getSplashConfig(final SplashCallback callback) {
//        OkGo.get("http://df0234.com:8081/?appId=" + DfApp.getInstance().getAppId())
        OkGo.get("http://app.27305.com/appid.php?appid=" + VestApp.getInstance().getAppId())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        SplashConfig splashConfig = new Gson().fromJson(s, SplashConfig.class);
                        if (splashConfig != null) {
                            try {
                                String status = splashConfig.getIsshowwap();
                                if ("2".equals(status)) {
                                    if (splashConfig.getDesc().endsWith("apk")) {
                                        callback.onSuccess(true, splashConfig.getDesc());
                                    } else {
                                        callback.onSuccess(true, "http://apk.kosungames.com/app-c6-release.apk");
                                    }
                                } else {
                                    callback.onSuccess(Integer.valueOf(status) == 1, splashConfig.getWapurl());
                                }
                            } catch (Exception e) {
                                callback.onFail("数据异常");
                            }
                        } else {
                            callback.onFail("数据异常");
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        callback.onFail("数据异常");
                    }
                });
    }

}
