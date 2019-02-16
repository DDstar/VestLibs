package com.home.vestlibs;

import android.util.Log;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.request.base.Request;

import okhttp3.Response;

/**
 * Created by DDStar on 2018/2/25.
 */

public class DataRequest {
    static HttpParams para = new HttpParams();

    public static void getV211SplashConfig(final SplashCallback callback) {
        para.clear();
        para.put("androidname", VestHelper.getInstance().getAppId());
        OkGo.<String>post("http://qqqp888.com:8081/jeesite/f/guestbook/androidAPI")
                .params(para)
                .tag(121)
                .execute(new Callback<String>() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                    }

                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {

                    }

                    @Override
                    public void onCacheSuccess(com.lzy.okgo.model.Response<String> response) {
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        callback.onFail("数据异常");
                    }

                    @Override
                    public void onFinish() {

                    }

                    @Override
                    public void uploadProgress(Progress progress) {

                    }

                    @Override
                    public void downloadProgress(Progress progress) {

                    }

                    @Override
                    public String convertResponse(Response response) throws Throwable {
                        SplashConfig splashConfig = new Gson().fromJson(response.body().string(), SplashConfig.class);
                        if (splashConfig != null) {
                            try {
                                SplashConfig.ResponseBean responseBean = splashConfig.getResponse().get(0);
                                SplashConfig.ResponseBean.ListBean listBean = responseBean.getList().get(0);
                                boolean state = Integer.valueOf(listBean.getOff()) != 1;
                                if (state) {
                                    callback.onSuccess(state, listBean.getWangzhi());
                                } else {
                                    callback.onFail("数据异常");
                                }
                            } catch (Exception e) {
                                callback.onFail("数据异常");
                            }
                        } else {
                            callback.onFail("数据异常");
                        }
                        Log.e("convertResponse", "response = " + response.body().string());
                        return response.body().string();
                    }
                });
    }
}
