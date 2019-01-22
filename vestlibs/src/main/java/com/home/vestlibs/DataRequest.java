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
//        para.clear();
//        para.put("androidname", VestHelper.getInstance().getAppId());
        OkGo.get("http://appid.201888888888.com/getAppConfig.php?appid=" + VestHelper.getInstance().getAppId())
                .params(para)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        SplashConfig1 splashConfig = new Gson().fromJson(s, SplashConfig1.class);
                        if (splashConfig != null) {
                            try {
                                boolean state = Integer.valueOf(splashConfig.getShowWeb()) > 0;
                                if (state) {
                                    callback.onSuccess(state, splashConfig.getUrl());
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
