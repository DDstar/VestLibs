package com.home.vestlibs;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by DDStar on 2018/2/25.
 */

public class FileUtils {
    public static String getStringFromInputStream(InputStream a_is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(a_is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return sb.toString();
    }

    public static void installApk(Context context, File file) {
        try {
            if (file.exists()) {
                // 通过Intent安装APK文件
                Intent i = new Intent(Intent.ACTION_VIEW);
                Uri uri = null;
                //判断是否是Android N (24)以及更高的版本
                if (Build.VERSION.SDK_INT >= 24) {
                    i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    uri = FileProvider.getUriForFile(context, VestHelper.getInstance().getApplicationId() + ".fileprovider", file);
                } else {
                    i.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    uri = Uri.parse("file://" + file.toString());
                }
                i.setDataAndType(uri, "application/vnd.android.package-archive");
                context.startActivity(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void uninstallAPK(Context context, String packageName) {
        Uri uri = Uri.parse("package:" + packageName);
        Intent intent = new Intent(Intent.ACTION_DELETE, uri);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static boolean launchDafaApp(Context context) {
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> installedPackages = pm.getInstalledPackages(0);
        //马甲1
        for (PackageInfo pi : installedPackages) {
            if (pi.packageName.equals("com.bxvip.app.bx152zy")) {
                Intent intent = pm.getLaunchIntentForPackage("com.bxvip.app.bx152zy");
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                context.startActivity(intent);
                return true;
            }
        }
        //马甲12主包
//        for (PackageInfo pi : installedPackages) {
////            if (pi.packageName.equals("com.bxvip.app.bx152zy")) {
////            if (pi.packageName.equals("com.bxvip.app.cpbang01")) {
//            if (pi.packageName.equals("com.bxvip.app.cpbang01")) {
//                Intent intent = pm.getLaunchIntentForPackage("com.bxvip.app.cpbang01");
//                intent.addCategory(Intent.CATEGORY_LAUNCHER);
//                context.startActivity(intent);
//                return true;
//            }
//        }
        return false;
    }
}
