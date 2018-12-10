package com.home.vestlibs;

/**
 * Created by GuoJi on 2018/2/28.
 */

public class SplashConfig {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1544410683
     * data : {"appId":"xk20181015001","status":"0","appInfo":"https://www.zg572.com/?intr=app88888"}
     */

    private int code;
    private String msg;
    private String time;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * appId : xk20181015001
         * status : 0
         * appInfo : https://www.zg572.com/?intr=app88888
         */

        private String appId;
        private String status;
        private String appInfo;

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

        public String getAppInfo() {
            return appInfo;
        }

        public void setAppInfo(String appInfo) {
            this.appInfo = appInfo;
        }
    }
}
