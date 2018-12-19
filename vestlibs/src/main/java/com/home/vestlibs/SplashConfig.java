package com.home.vestlibs;

import java.util.List;

/**
 * Created by GuoJi on 2018/2/28.
 */

public class SplashConfig {

    /**
     * httpCode : 200
     * response : [{"pageNo":1,"pageSize":30,"count":1,"list":[{"id":"37bc7f5332e44ed88c86b9825ea1760f","isNewRecord":false,"androidname":"xiaoduTset","off":"2","createtime":"2018-12-17 11:06:01","pingtai":"百度","wangzhi":"https://www.8905a.com/?intr=sf8905","yingyongming":""}],"html":"<ul>\n<li class=\"disabled\"><a href=\"javascript:\">« 上一页<\/a><\/li>\n<li class=\"active\"><a href=\"javascript:\">1<\/a><\/li>\n<li class=\"disabled\"><a href=\"javascript:\">下一页 »<\/a><\/li>\n<li class=\"disabled controls\"><a href=\"javascript:\">当前 <input type=\"text\" value=\"1\" onkeypress=\"var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,30,'');\" onclick=\"this.select();\"/> / <input type=\"text\" value=\"30\" onkeypress=\"var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');\" onclick=\"this.select();\"/> 条，共 1 条<\/a><\/li>\n<\/ul>\n<div style=\"clear:both;\"><\/div>","firstResult":0,"maxResults":30}]
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
        /**
         * pageNo : 1
         * pageSize : 30
         * count : 1
         * list : [{"id":"37bc7f5332e44ed88c86b9825ea1760f","isNewRecord":false,"androidname":"xiaoduTset","off":"2","createtime":"2018-12-17 11:06:01","pingtai":"百度","wangzhi":"https://www.8905a.com/?intr=sf8905","yingyongming":""}]
         * html : <ul>
         * <li class="disabled"><a href="javascript:">« 上一页</a></li>
         * <li class="active"><a href="javascript:">1</a></li>
         * <li class="disabled"><a href="javascript:">下一页 »</a></li>
         * <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,30,'');" onclick="this.select();"/> / <input type="text" value="30" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 1 条</a></li>
         * </ul>
         * <div style="clear:both;"></div>
         * firstResult : 0
         * maxResults : 30
         */

        private int pageNo;
        private int pageSize;
        private int count;
        private String html;
        private int firstResult;
        private int maxResults;
        private List<ListBean> list;

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public int getFirstResult() {
            return firstResult;
        }

        public void setFirstResult(int firstResult) {
            this.firstResult = firstResult;
        }

        public int getMaxResults() {
            return maxResults;
        }

        public void setMaxResults(int maxResults) {
            this.maxResults = maxResults;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 37bc7f5332e44ed88c86b9825ea1760f
             * isNewRecord : false
             * androidname : xiaoduTset
             * off : 2
             * createtime : 2018-12-17 11:06:01
             * pingtai : 百度
             * wangzhi : https://www.8905a.com/?intr=sf8905
             * yingyongming :
             */

            private String id;
            private boolean isNewRecord;
            private String androidname;
            private String off;
            private String createtime;
            private String pingtai;
            private String wangzhi;
            private String yingyongming;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

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

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getPingtai() {
                return pingtai;
            }

            public void setPingtai(String pingtai) {
                this.pingtai = pingtai;
            }

            public String getWangzhi() {
                return wangzhi;
            }

            public void setWangzhi(String wangzhi) {
                this.wangzhi = wangzhi;
            }

            public String getYingyongming() {
                return yingyongming;
            }

            public void setYingyongming(String yingyongming) {
                this.yingyongming = yingyongming;
            }
        }
    }
}
