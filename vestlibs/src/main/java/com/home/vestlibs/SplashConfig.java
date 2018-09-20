package com.ddstar.caiplayer.datamodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GuoJi on 2018/2/28.
 */

public class SplashConfig {


    /**
     * appid : 1802262051
     * appname :
     * isshowwap : 2
     * wapurl :
     * status : 1
     * desc : 成功返回数据
     */

    private String appid;
    private String appname;
    private String isshowwap;
    private String wapurl;
    //    private int status;
    private String desc;
    /**
     * appId : z1001
     * status : 0
     * url : http:www.baidu.com
     */

    private String appId;
    private String status;
    private String url;
    /**
     * data : {"appid":"baid2018no4","appname":"时时彩（百度）","is_jump":"2","jump_url":"https://apk.update-daquan369app.com/","status":"0"}
     * type : 200
     */

    private DataBean data;
    private String type;
    /**
     * ShowWeb : MQ==
     * PushKey : YXBwaWRjZXNoaTc3Nw==
     */

    private String ShowWeb;
    private String PushKey;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getIsshowwap() {
        return isshowwap;
    }

    public void setIsshowwap(String isshowwap) {
        this.isshowwap = isshowwap;
    }

    public String getWapurl() {
        return wapurl;
    }

    public void setWapurl(String wapurl) {
        this.wapurl = wapurl;
    }

//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShowWeb() {
        return ShowWeb;
    }

    public void setShowWeb(String ShowWeb) {
        this.ShowWeb = ShowWeb;
    }

    public String getPushKey() {
        return PushKey;
    }

    public void setPushKey(String PushKey) {
        this.PushKey = PushKey;
    }

    public static class DataBean {
        /**
         * appid : baid2018no4
         * appname : 时时彩（百度）
         * is_jump : 2
         * jump_url : https://apk.update-daquan369app.com/
         * status : 0
         */

        @SerializedName("appid")
        private String appidX;
        @SerializedName("appname")
        private String appnameX;
        private String is_jump;
        private String jump_url;
        @SerializedName("status")
        private String statusX;

        public String getAppidX() {
            return appidX;
        }

        public void setAppidX(String appidX) {
            this.appidX = appidX;
        }

        public String getAppnameX() {
            return appnameX;
        }

        public void setAppnameX(String appnameX) {
            this.appnameX = appnameX;
        }

        public String getIs_jump() {
            return is_jump;
        }

        public void setIs_jump(String is_jump) {
            this.is_jump = is_jump;
        }

        public String getJump_url() {
            return jump_url;
        }

        public void setJump_url(String jump_url) {
            this.jump_url = jump_url;
        }

        public String getStatusX() {
            return statusX;
        }

        public void setStatusX(String statusX) {
            this.statusX = statusX;
        }
    }
}
