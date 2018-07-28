package com.home.vestlibs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DDStar on 2018/2/23.
 */

public abstract class BaseActivity extends FragmentActivity {
    protected Context mContext;
    private LoadingDialog loadingDialog;
    protected boolean isLoadErr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentLayout());
        mContext = this;
        loadingDialog = new LoadingDialog(mContext);
        initView();
        initData();
    }

    protected void setTitleText(int titleId, String titleText) {
        ((TextView) findViewById(titleId)).setText(titleText);
    }

    protected void showLoading() {
        if (loadingDialog != null && !loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    protected void dismissLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    private static Toast mToast;

    protected void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    protected abstract int setContentLayout();

    protected abstract void initView();

    protected abstract void initData();
}
