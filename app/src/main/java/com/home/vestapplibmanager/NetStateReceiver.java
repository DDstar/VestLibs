package com.home.vestapplibmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by DDStar on 2019/1/11.
 */
public class NetStateReceiver extends BroadcastReceiver {
    static Toast mToast;

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
}
