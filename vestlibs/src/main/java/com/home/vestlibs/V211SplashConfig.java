package com.home.vestlibs;

/**
 * Created by DDStar on 2018/9/6.
 */
public class V211SplashConfig {

    /**
     * success : true
     * AppConfig : {"PushKey":null,"AcceptCount":0,"AppId":"qianggengceshi001","ShowWeb":"1","Del":"0","Url":"https://bxvip.oss-cn-zhangjiakou.aliyuncs.com/bxvip/androidapk/152caizy.apk","Remark":"接口说明：appid为唯一标示APP的字符串，调用前需要配置好。需要用到的返回值：【success】：布尔值，true 调用成功，false 请求失败，出错的情况一般就是appid传错了。【ShowWeb】：字符串，\"0\"不跳转， \"1\"跳转【PushKey】：字符串，推送用的key【Url】：字符串 跳转的url地址。"}
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
         * PushKey : null
         * AcceptCount : 0
         * AppId : qianggengceshi001
         * ShowWeb : 1
         * Del : 0
         * Url : https://bxvip.oss-cn-zhangjiakou.aliyuncs.com/bxvip/androidapk/152caizy.apk
         * Remark : 接口说明：appid为唯一标示APP的字符串，调用前需要配置好。需要用到的返回值：【success】：布尔值，true 调用成功，false 请求失败，出错的情况一般就是appid传错了。【ShowWeb】：字符串，"0"不跳转， "1"跳转【PushKey】：字符串，推送用的key【Url】：字符串 跳转的url地址。
         */

        private String PushKey;
        private int AcceptCount;
        private String AppId;
        private String ShowWeb;
        private String Del;
        private String Url;
        private String Remark;

        public Object getPushKey() {
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

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }
    }
}
