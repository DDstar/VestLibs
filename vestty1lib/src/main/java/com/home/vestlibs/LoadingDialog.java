package com.home.vestlibs;

import android.content.Context;
import android.support.annotation.NonNull;



/**
 * Created by DDStar on 2018/2/2.
 */

public class LoadingDialog extends BaseDialog {
    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void initView(Context context) {
        super.initView(context);
        setRootView(R.layout.layout_loading);
    }
}
