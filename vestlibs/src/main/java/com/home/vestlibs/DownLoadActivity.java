package com.home.vestlibs;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;

import java.io.File;

import okhttp3.Call;
import okhttp3.Response;

public class DownLoadActivity extends BaseActivity {


    private static String url_key = "url";
    TextView tv_progress;
    ProgressBar progressBar;
    ImageView image_bg;

    @Override
    protected int setContentLayout() {
        return R.layout.activity_down_load;
    }

    public static void startActivity(Context context, String url) {
        Intent intent = new Intent(context, DownLoadActivity.class);
        intent.putExtra(url_key, url);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        progressBar = findViewById(R.id.progressBar);
        tv_progress = findViewById(R.id.tv_progress);
        image_bg = findViewById(R.id.image_bg);
        progressBar.setMax(100);
        image_bg.setImageResource(V211App.getInstance().downBg);
        String url = getIntent().getStringExtra(url_key);
        if (url.trim().endsWith("apk")) {
            downLoad(url);
        }
    }

    private void downLoad(String url) {
        OkGo.get(url)
                .execute(new FileCallback() {
                    @Override
                    public void onSuccess(File file, Call call, Response response) {
                        FileUtils.installApk(DownLoadActivity.this, file);
                        finish();
                    }

                    @Override
                    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        super.downloadProgress(currentSize, totalSize, progress, networkSpeed);
                        Log.e("downloadProgress", "currentSize = " + currentSize + "totalSize = " + totalSize + "progress = " + progress);
                        tv_progress.setText((int) ((currentSize * 1.0f / 3240433L) * 100) + "%");
                        progressBar.setProgress((int) (currentSize * 1.0f / 3240433L * 100));
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        showToast("下载失败");
                    }
                });
    }

    @Override
    protected void initData() {

    }
}
