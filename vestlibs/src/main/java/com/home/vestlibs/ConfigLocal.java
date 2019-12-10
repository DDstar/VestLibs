package com.home.vestlibs;

/**
 * Created by DDStar on 2019/12/10.
 */
public class ConfigLocal {

    /**
     * msg : 获取成功
     * status : 1
     * data : {"id":1,"url":"http://www.baidu.com","android_down_url":"https://www.baidu.com.apk","is_update":"0","name":"aaa","status":0}
     */

    private String msg;
    private int status;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * url : http://www.baidu.com
         * android_down_url : https://www.baidu.com.apk
         * is_update : 0
         * name : aaa
         * status : 0
         */

        private int id;
        private String url;
        private String android_down_url;
        private String is_update;
        private String name;
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAndroid_down_url() {
            return android_down_url;
        }

        public void setAndroid_down_url(String android_down_url) {
            this.android_down_url = android_down_url;
        }

        public String getIs_update() {
            return is_update;
        }

        public void setIs_update(String is_update) {
            this.is_update = is_update;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
