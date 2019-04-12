package com.home.vestlibs;

/**
 * Created by DDStar on 2019/4/12 0012.
 */
public class SplashConfig2 {

    /**
     * code : 0
     * data : {"apkUrl":"string","kaiguan":0,"versionCode":0,"webUrl":"string"}
     * message : string
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * apkUrl : string
         * kaiguan : 0
         * versionCode : 0
         * webUrl : string
         */

        private String apkUrl;
        private int kaiguan;
        private int versionCode;
        private String webUrl;

        public String getApkUrl() {
            return apkUrl;
        }

        public void setApkUrl(String apkUrl) {
            this.apkUrl = apkUrl;
        }

        public int getKaiguan() {
            return kaiguan;
        }

        public void setKaiguan(int kaiguan) {
            this.kaiguan = kaiguan;
        }

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }
    }
}
