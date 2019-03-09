package com.home.vestapplibmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import static com.home.vestapplibmanager.NetStateReceiver.mToast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (mToast == null) {
                mToast = Toast.makeText(context, "la", Toast.LENGTH_SHORT);
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(
                    Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                int type2 = networkInfo.getType();
                String typeName = networkInfo.getTypeName();
                Log.e("networkInfo", "typeName = " + typeName);
                switch (type2) {
                    case 0://移动 网络    2G 3G 4G 都是一样的 实测 mix2s 联通卡
                        mToast.setText("当前是移动网络");
                        break;
                    case 1: //wifi网络
                        mToast.setText("当前是wifi网络");
                        break;
                    case 9:  //网线连接
                        mToast.setText("网线连接");
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
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.ethernet.ETHERNET_STATE_CHANGED");
        filter.addAction("android.net.ethernet.STATE_CHANGE");
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        filter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
