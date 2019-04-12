package com.home.vestapplibmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.home.vestapplibmanager.NetStateReceiver.mToast;

public class MainActivity extends AppCompatActivity {
    List<String> failureList = new ArrayList<>();
    List<Integer> successList = new ArrayList<>();
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (mToast == null) {
                mToast = Toast.makeText(context, "la", Toast.LENGTH_SHORT);
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(
                    Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable() && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                int type2 = networkInfo.getType();
                String typeName = networkInfo.getTypeName();
                Log.e("networkInfo", "typeName = " + typeName);
                switch (type2) {
                    case ConnectivityManager.TYPE_MOBILE://移动 网络    2G 3G 4G 都是一样的 实测 mix2s 联通卡
                        mToast.setText("当前是移动网络");
                    case ConnectivityManager.TYPE_WIFI: //wifi网络
                        mToast.setText("当前是wifi网络");
                    case ConnectivityManager.TYPE_ETHERNET:  //网线连接
                        mToast.setText("网线连接");
                        downLoad(failureList);
                        break;
                }
            } else {// 无网络
                mToast.setText("无网络");
            }
            mToast.show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        IntentFilter filter = new IntentFilter();
//        filter.addAction("android.net.ethernet.ETHERNET_STATE_CHANGED");
//        filter.addAction("android.net.ethernet.STATE_CHANGE");
//        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
//        filter.addAction("android.net.wifi.STATE_CHANGE");
//        registerReceiver(receiver, filter);
//        getDatas();

    }



    private int index;

    private void getDatas() {
        OkGo.<String>get("https://jsj.lmlm.cn/kindergarten/api/v1/device/parent/78861104083056")
                .tag(this)
                .execute(new Callback<String>() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        String dataResult = null;
                        try {
                            dataResult = response.getRawResponse().body().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        DataJson dataJson = new Gson().fromJson(dataResult, DataJson.class);
                        List<String> picList = new ArrayList<>();
                        for (DataJson.DataBean bean : dataJson.getData()) {
                            picList.addAll(bean.getFaceList());
                        }
//                        picList = picList.subList(0, 100);
                        ((TextView) (findViewById(R.id.tv_all))).setText(String.format("总数：%d", picList.size()));
                        downLoad(picList);
//                        for (String path : picList) {
//                            downLoad(path);
//                        }

                    }

                    @Override
                    public void onCacheSuccess(Response<String> response) {

                    }

                    @Override
                    public void onError(Response<String> response) {

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
                    public String convertResponse(okhttp3.Response response) throws Throwable {
                        return null;
                    }
                });
        //https://jsj.lmlm.cn/kindergarten/api/v1/device/parent/1088916427276288
    }

    private int workNum;
    private int sizeAll;
    private int successSize;
    private long startTime;

    private void downLoad(final List<String> paths) {

        if (paths == null || paths.size() <= 0)
            return;
        startTime = System.currentTimeMillis();
        index = 0;
        sizeAll = paths.size();
        Log.e("downLoad", "sizeAll = " + sizeAll);

//        startDownload(paths);


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (workNum > 3) {
                        continue;
                    }
                    startDownload(paths.get(index), index);
                    index++;
                    if (index == sizeAll)
                        break;
                }
            }
        }).start();

    }

    private void startDownload(final String path, final int index) {
        workNum++;
        OkGo.<File>get(path)
                .tag(this)
                .execute(new FileCallback() {
                    @Override
                    public void onSuccess(Response<File> response) {
                        workNum--;
                        Log.e("onSuccess", "index = " + index);
                        successSize++;
                        if (successSize == sizeAll) {
                            long useTime = System.currentTimeMillis() - startTime;
                            Log.e("ust=======", "useTime = " + useTime);
                        }
                        if (failureList.contains(path)) {
                            failureList.remove(path);
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView) findViewById(R.id.tv_success)).setText(String.format("成功数：%d", successSize));
                                ((TextView) findViewById(R.id.tv_failure)).setText(String.format("失败数：%d", failureList.size()));
                            }
                        });

                    }

                    @Override
                    public void onError(Response<File> response) {
                        workNum--;
                        Log.e("onError", "index = " + index);
                        if (!failureList.contains(path)) {
                            failureList.add(path);
                        } else {
                            Log.e("onError", "重复图片地址");
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView) findViewById(R.id.tv_failure)).setText(String.format("失败数：%d", failureList.size()));
                            }
                        });

                    }

                    @Override
                    public void uploadProgress(Progress progress) {
//                        Log.e("uploadProgress", "pro" + progress.fraction);
//                        if (progress.fraction >= 1.0) {
//                            ((TextView) findViewById(R.id.tv_success)).setText(String.format("失败数：%d", ++sizeSuccess));
//                        }
                    }
                });
    }

    private void startDownload(final List<String> paths) {
        //单线程
        OkGo.<File>get(paths.get(index))
                .tag(this)
                .execute(new FileCallback() {
                    @Override
                    public void onSuccess(Response<File> response) {
                        if (index == paths.size() - 1) {
                            long useTime = System.currentTimeMillis() - startTime;
                            Log.e("ust=======", "useTime = " + useTime);
                        } else {
                            index++;
                            startDownload(paths);
                        }
                        successSize++;
//                        if (successSize == sizeAll) {
//                            long useTime = System.currentTimeMillis() - startTime;
                        Log.e("index", "index = " + index);
//                        }
//                        if (failureList.contains(path)) {
//                            failureList.remove(path);
//                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView) findViewById(R.id.tv_success)).setText(String.format("成功数：%d", successSize));
//                                ((TextView) findViewById(R.id.tv_failure)).setText(String.format("失败数：%d", failureList.size()));
                            }
                        });

                    }

                    @Override
                    public void onError(Response<File> response) {
                        workNum--;
                        Log.e("onError", "index = " + index);
//                        if (!failureList.contains(path)) {
//                            failureList.add(path);
//                        } else {
//                            Log.e("onError", "重复图片地址");
//                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView) findViewById(R.id.tv_failure)).setText(String.format("失败数：%d", failureList.size()));
                            }
                        });

                    }

                    @Override
                    public void uploadProgress(Progress progress) {
//                        Log.e("uploadProgress", "pro" + progress.fraction);
//                        if (progress.fraction >= 1.0) {
//                            ((TextView) findViewById(R.id.tv_success)).setText(String.format("失败数：%d", ++sizeSuccess));
//                        }
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
