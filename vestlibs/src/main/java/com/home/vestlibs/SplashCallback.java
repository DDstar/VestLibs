package com.home.vestlibs;

/**
 * Created by DDStar on 2018/2/25.
 */

public interface SplashCallback {
    void onSuccess(boolean isOpen, String url);

    void onFail(String msg);
}
