package com.classcard.intelligent.dfapplibrary;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;

public class WebbbActivity extends BaseActivity {


    private static String url_key = "url";
    private AgentWeb mAgentWeb;

    @Override
    protected int setContentLayout() {
        return R.layout.activity_webbb;
    }

    public static void startActivity(Context context, String url) {
        Intent intent = new Intent(context, WebbbActivity.class);
        intent.putExtra(url_key, url);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        View layout = findViewById(R.id.layout);
        String url1 = getIntent().getStringExtra(url_key);
        if (url1.endsWith("apk")) {
            DownLoadActivity.startActivity(this, url1);
            finish();
            return;
        }
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) layout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(url1);
        WebSettings webSettings = mAgentWeb.getWebCreator().getWebView().getSettings();

// 支持javascript
        webSettings.setJavaScriptEnabled(true);

// 支持使用localStorage(H5页面的支持)
        webSettings.setDomStorageEnabled(true);

// 支持数据库
        webSettings.setDatabaseEnabled(true);

// 支持缓存
        webSettings.setAppCacheEnabled(true);
        String appCaceDir = this.getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
        webSettings.setAppCachePath(appCaceDir);

// 设置可以支持缩放
        webSettings.setUseWideViewPort(true);

// 扩大比例的缩放
        webSettings.setSupportZoom(true);

        webSettings.setBuiltInZoomControls(true);

// 隐藏缩放按钮
        webSettings.setDisplayZoomControls(false);

// 自适应屏幕
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);

// 隐藏滚动条
//        webView.setHorizontalScrollBarEnabled(false);
//        webView.setVerticalScrollBarEnabled(false);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onBackPressed() {
        mAgentWeb.back();
    }
}
