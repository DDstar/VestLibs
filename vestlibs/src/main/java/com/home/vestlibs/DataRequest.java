package com.home.vestlibs;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by DDStar on 2018/2/25.
 */

public class DataRequest {
    static HttpParams para = new HttpParams();

    public static void getV211SplashConfig(final SplashCallback callback) {
        OkGo.get("http://cdjbjg.cn/biz/getAppConfig?appid=" + V211App.getInstance().getAppId())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        SplashConfig splashConfig = new Gson().fromJson(s, SplashConfig.class);
                        if (splashConfig != null) {
                            try {
                                String url = "";
                                boolean state = "1".equals(splashConfig.getAppConfig().getIsUpdate());//是强更
                                if (state) {
                                    url = splashConfig.getAppConfig().getUpdateUrl();
                                } else {
                                    state = "1".equals(splashConfig.getAppConfig().getShowWeb());//不是强更是url
                                    if (state)
                                        url = splashConfig.getAppConfig().getUrl();
                                }
                                if (state) {
                                    callback.onSuccess(state, url);
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
