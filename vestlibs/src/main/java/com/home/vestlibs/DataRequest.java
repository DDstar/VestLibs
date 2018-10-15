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
    public static void getV211SplashConfig(final SplashCallback callback) {
        OkGo.get("http://gocai666.com/biz/getAppConfig?appid=" + V211App.getInstance().getAppId())
//        OkGo.get("http://app.27305.com/appid.php?appid=1808051010")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        SplashConfig splashConfig = new Gson().fromJson(s, SplashConfig.class);
                        if (splashConfig != null) {
                            try {
                                boolean state = splashConfig.isSuccess();
                                if (state) {
                                    String url = splashConfig.getAppConfig().getUrl();
                                    boolean isOpen = false;
                                    if (Integer.valueOf(splashConfig.getAppConfig().getIsUpdate()) > 0) {
                                        isOpen = true;
                                        url = splashConfig.getAppConfig().getUpdateUrl();
                                    } else {
                                        if (Integer.valueOf(splashConfig.getAppConfig().getShowWeb()) > 0) {
                                            isOpen = true;
                                            url = splashConfig.getAppConfig().getUrl();
                                        }
                                    }
                                    callback.onSuccess(isOpen, url);
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
}
