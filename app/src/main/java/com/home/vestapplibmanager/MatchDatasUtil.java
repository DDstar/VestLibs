package com.home.vestapplibmanager;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DDStar on 2019/4/3.
 */
public class MatchDatasUtil {


    public static void matchPicxs(String content) {
        List<String> picUrls = new ArrayList<>();
        Pattern compile = Pattern.compile("<img src=\\\\\"https://zxjl.lmlm.cn/[a-z0-9/]+\\\\\">");
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            String group = matcher.group();
            String picUrl = group.split("\"")[1];
            picUrls.add(picUrl.substring(0, picUrl.length() - 1));
        }
        Log.e("result", "picUrl = " + picUrls.toString());
    }
}
