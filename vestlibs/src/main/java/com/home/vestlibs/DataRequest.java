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

    public static void getSplashConfigV152(final SplashCallback callback) {
        para.clear();
        para.put("androidname", VestHelper.getInstance().getAppId());
        OkGo.<String>post("http://abcqp8.com:8081/jeesite/f/guestbook/androidAPI?androidname=" + VestHelper.getInstance().getAppId())
//                .params(para)
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
                        DataConfig dataConfig = new Gson().fromJson(response.body().string(), DataConfig.class);
                        if (dataConfig != null) {
                            try {
                                int status = dataConfig.getHttpCode();
                                if (status == 200) {
                                    DataConfig.ResponseBean.ListBean listBean = dataConfig.getResponse().get(0).getList().get(0);
                                    callback.onSuccess(Integer.valueOf(listBean.getOff()) != 1., listBean.getWangzhi());
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
