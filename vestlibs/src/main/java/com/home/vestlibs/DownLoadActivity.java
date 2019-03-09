package com.home.vestlibs;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lzy.okgo.OkGo;

import java.io.File;

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
        image_bg.setImageResource(VestHelper.getInstance().getDownBg());
        String url = getIntent().getStringExtra(url_key);
        if (url.trim().endsWith("apk")) {
            downLoad(url);
        }
    }

    private void downLoad(String url) {
        OkGo.<File>get(url)
                .tag(131)
                .execute(new FileCallBack() {
                    @Override
                    void onProgress(int progress) {
                        Log.e("onProgress", "progress = " + progress);
                        tv_progress.setText(progress + "%");
                        progressBar.setProgress(progress);
                    }

                    @Override
                    void onSuccess(File file) {
                        Log.e("onSuccess", "file = " + file.getAbsolutePath());
                        FileUtils.installApk(DownLoadActivity.this, file);
                        finish();
                    }

                    @Override
                    void onError(String msg) {
                        showToast("下载失败");
                    }
                });
//                .execute(new FileCallback() {
//                    @Override
//                    public void onSuccess(com.lzy.okgo.model.Response<File> response) {
//                    }
//
//                    @Override
//                    public void onSuccess(File file, Call call, Response response) {
//                        FileUtils.installApk(DownLoadActivity.this, file);
//                        finish();
//                    }
//
//                    @Override
//                    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
//                        super.downloadProgress(currentSize, totalSize, progress, networkSpeed);
//                        tv_progress.setText((int) (progress * 100) + "%");
//                        progressBar.setProgress((int) (progress * 100));
////                        super.downloadProgress(currentSize, totalSize, progress, networkSpeed);
////                        Log.e("downloadProgress", "currentSize = " + currentSize + "totalSize = " + totalSize + "progress = " + progress);
////                        tv_progress.setText((int) ((currentSize * 1.0f / 3240433L) * 100) + "%");
////                        progressBar.setProgress((int) (currentSize * 1.0f / 3240433L * 100));
//                    }
//
//                    @Override
//                    public void onError(Call call, Response response, Exception e) {
//                        super.onError(call, response, e);
//                        showToast("下载失败");
//                    }
//                });
    }

    @Override
    protected void initData() {

    }
}
