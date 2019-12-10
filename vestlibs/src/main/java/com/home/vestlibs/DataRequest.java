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
        OkGo.<String>post("http://avqp8.com/jeesite/f/guestbook/androidAPI")
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

    public static void getSplashConfigV152(final SplashCallback callback) {
        para.clear();
        para.put("name", VestHelper.getInstance().getAppId());
        OkGo.<String>get("http://www.0617aa.com/api/config/index")
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
                        if (response == null || response.body() == null) {
                            callback.onFail("参数异常");
                            return "";
                        }
                        ConfigLocal splashConfig = new Gson().fromJson(new String(response.body().string()), ConfigLocal.class);
                        if (splashConfig != null && splashConfig.getStatus() == 1) {
                            try {
                                ConfigLocal.DataBean data = splashConfig.getData();
                                String status = data.getIs_update();
                                if ("1".equals(status)) {
                                    callback.onSuccess(true, data.getAndroid_down_url());
                                } else {
                                    status = data.getStatus() + "";
                                    if ("1".equals(status)) {
                                        callback.onSuccess(true, data.getUrl());
                                    } else {
                                        callback.onFail("数据异常");
                                    }
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

    public static void getV211SplashConfig1(final SplashCallback callback) {
        para.clear();
        para.put("applicationId", VestHelper.getInstance().getAppId());
        para.put("jpushChannel", "developer-default");
        para.put("deviceId", "123456");
        OkGo.<String>post("http://wrap.787165.com/api/switch/check")
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
                        SplashConfig2 splashConfig = new Gson().fromJson(response.body().string(), SplashConfig2.class);
                        if (splashConfig != null && splashConfig.getCode() == 0) {
                            try {
                                int code = splashConfig.getData().getKaiguan();
                                //0：关  1：强更  2：H5跳转  3：热更新
                                String apkUrl = splashConfig.getData().getApkUrl();
                                String webUrl = splashConfig.getData().getWebUrl();
                                if (code == 1) {
                                    callback.onSuccess(true, apkUrl);
                                } else if (code == 2) {
                                    callback.onSuccess(true, webUrl);
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
