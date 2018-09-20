package com.home.vestlibs;

import android.util.Base64;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by DDStar on 2018/2/25.
 */

public class DataRequest {

    public static void getSplashConfig(final SplashCallback callback) {
        OkGo.get("http://df0234.com:8081/?appId=" + DfApp.getInstance().getAppId())
//        OkGo.get("http://201888888888.com:8080/biz/getAppConfig?appid=" + DfApp.getInstance().getAppId())
//        OkGo.get("http://app.27305.com/appid.php?appid=1806051526")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        com.ddstar.caiplayer.datamodel.SplashConfig splashConfig = new Gson().fromJson(s, com.ddstar.caiplayer.datamodel.SplashConfig.class);
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

    public static void getV211SplashConfig(final SplashCallback callback) {
        OkGo.get("http://aigoodies.com/bick/public/index.php/api/index/get_appid/appid/" + V211App.getInstance().getAppId())
//        OkGo.get("http://app.27305.com/appid.php?appid=1808051010")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        com.ddstar.caiplayer.datamodel.SplashConfig splashConfig = new Gson().fromJson(s, com.ddstar.caiplayer.datamodel.SplashConfig.class);
                        if (splashConfig != null) {
                            try {
                                Integer state = Integer.valueOf(new String(Base64.decode(splashConfig.getShowWeb(), 0)));
                                if (state == 1) {
                                    callback.onSuccess(true, new String(Base64.decode(splashConfig.getUrl(), 0)));
                                } else {
                                    callback.onFail("数据异常");
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

    public static void getSplashVestType2Config(final SplashCallback callback) {
//        OkGo.get("http://df0234.com:8081/?appId=" + DfApp.getInstance().getAppId())
        OkGo.get("http://app.27305.com/appid.php?appid" + DfApp.getInstance().getAppId())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        com.ddstar.caiplayer.datamodel.SplashConfig splashConfig = new Gson().fromJson(s, com.ddstar.caiplayer.datamodel.SplashConfig.class);
                        if (splashConfig != null) {
                            try {
                                String status = splashConfig.getStatus();
                                if ("2".equals(status)) {
                                    callback.onSuccess(true, splashConfig.getDesc());
                                } else {
                                    callback.onSuccess(Integer.valueOf(status) == 1, splashConfig.getUrl());
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
