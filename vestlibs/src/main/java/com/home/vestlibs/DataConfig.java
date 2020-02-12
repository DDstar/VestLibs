package com.home.vestlibs;

import java.util.List;

public class DataConfig {


    /**
     * httpCode : 200
     * response : [{"list":[{"androidname":"","off":"2","wangzhi":"aa","pingtai":"aaaaa"}]}]
     */

    private int httpCode;
    private List<ResponseBean> response;

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public List<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseBean> response) {
        this.response = response;
    }

    public static class ResponseBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * androidname :
             * off : 2   0 开，1关，2跳转H5，3跳转安卓APK
             * wangzhi : aa
             * pingtai : aaaaa
             */

            private String androidname;
            private String off;
            private String wangzhi;
            private String pingtai;

            public String getAndroidname() {
                return androidname;
            }

            public void setAndroidname(String androidname) {
                this.androidname = androidname;
            }

            public String getOff() {
                return off;
            }

            public void setOff(String off) {
                this.off = off;
            }

            public String getWangzhi() {
                return wangzhi;
            }

            public void setWangzhi(String wangzhi) {
                this.wangzhi = wangzhi;
            }

            public String getPingtai() {
                return pingtai;
            }

            public void setPingtai(String pingtai) {
                this.pingtai = pingtai;
            }
        }
    }
}
