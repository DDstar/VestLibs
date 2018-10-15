package com.home.vestlibs;

/**
 * Created by GuoJi on 2018/2/28.
 */

public class SplashConfig {

    /**
     * success : true
     * AppConfig : {"PushKey":"15f1a6db5e5d3de7cca0f23a","AcceptCount":42,"AppId":"123456789","ShowWeb":"0","Del":"0","Url":"https://www.goucai666.com","UpdateUrl":"https://dfhy18.com/d/file/gc/goucai666.apk","Remark":"接口说明：appid为唯一标示APP的字符串，调用前需要配置好。需要用到的返回值：【success】：布尔值，true 调用成功，false 请求失败，出错的情况一般就是appid传错了。【ShowWeb】：字符串，\"0\"不跳转， \"1\"跳转【PushKey】：字符串，推送用的key【Url】：字符串 跳转的url地址。","IsUpdate":"0"}
     */

    private boolean success;
    private AppConfigBean AppConfig;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public AppConfigBean getAppConfig() {
        return AppConfig;
    }

    public void setAppConfig(AppConfigBean AppConfig) {
        this.AppConfig = AppConfig;
    }

    public static class AppConfigBean {
        /**
         * PushKey : 15f1a6db5e5d3de7cca0f23a
         * AcceptCount : 42
         * AppId : 123456789
         * ShowWeb : 0
         * Del : 0
         * Url : https://www.goucai666.com
         * UpdateUrl : https://dfhy18.com/d/file/gc/goucai666.apk
         * Remark : 接口说明：appid为唯一标示APP的字符串，调用前需要配置好。需要用到的返回值：【success】：布尔值，true 调用成功，false 请求失败，出错的情况一般就是appid传错了。【ShowWeb】：字符串，"0"不跳转， "1"跳转【PushKey】：字符串，推送用的key【Url】：字符串 跳转的url地址。
         * IsUpdate : 0
         */

        private String PushKey;
        private int AcceptCount;
        private String AppId;
        private String ShowWeb;
        private String Del;
        private String Url;
        private String UpdateUrl;
        private String Remark;
        private String IsUpdate;

        public String getPushKey() {
            return PushKey;
        }

        public void setPushKey(String PushKey) {
            this.PushKey = PushKey;
        }

        public int getAcceptCount() {
            return AcceptCount;
        }

        public void setAcceptCount(int AcceptCount) {
            this.AcceptCount = AcceptCount;
        }

        public String getAppId() {
            return AppId;
        }

        public void setAppId(String AppId) {
            this.AppId = AppId;
        }

        public String getShowWeb() {
            return ShowWeb;
        }

        public void setShowWeb(String ShowWeb) {
            this.ShowWeb = ShowWeb;
        }

        public String getDel() {
            return Del;
        }

        public void setDel(String Del) {
            this.Del = Del;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public String getUpdateUrl() {
            return UpdateUrl;
        }

        public void setUpdateUrl(String UpdateUrl) {
            this.UpdateUrl = UpdateUrl;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public String getIsUpdate() {
            return IsUpdate;
        }

        public void setIsUpdate(String IsUpdate) {
            this.IsUpdate = IsUpdate;
        }
    }
}
