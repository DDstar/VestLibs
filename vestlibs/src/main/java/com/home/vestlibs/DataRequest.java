package com.home.vestlibs;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by DDStar on 2018/2/25.
 */

public class DataRequest {
    static HttpParams para = new HttpParams();

    public static void getV211SplashConfig(final SplashCallback callback) {
        para.clear();
        para.put("androidname", V211App.getInstance().getApplicationId());
        OkGo.post("http://abcqp8.com:8081/jeesite/f/guestbook/androidAPI")
                .params(para)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        SplashConfig splashConfig = new Gson().fromJson(s, SplashConfig.class);
                        if (splashConfig != null) {
                            try {
                                SplashConfig.ResponseBean responseBean = splashConfig.getResponse().get(0);
                                List<SplashConfig.ResponseBean.ListBean> beanList = responseBean.getList();
                                SplashConfig.ResponseBean.ListBean listBean = beanList.get(0);
                                boolean state = Integer.valueOf(listBean.getOff()) > 1;
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
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        callback.onFail("数据异常");
                    }
                });
    }
}
