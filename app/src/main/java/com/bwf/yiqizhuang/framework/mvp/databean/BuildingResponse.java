package com.bwf.yiqizhuang.framework.mvp.databean;

import java.util.List;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class BuildingResponse {


    /**
     * data : [{"title":"建材","icon":"http://apptest-picture.oss-cn-beijing.aliyuncs.com/icon/jiancai@3x.png","children":[{"id":"12087","title":"瓷砖","icon":"http://static-news.17house.com/web/bbs/201604/20/1400025645.jpg","threadsnum":"375","postsnum":759},{"id":"5104","title":"卫浴","icon":"http://static-news.17house.com/web/bbs/201605/27/1041099278.jpg","threadsnum":"557","postsnum":1140},{"id":"10475","title":"橱柜","icon":"http://static-news.17house.com/web/bbs/201604/20/1358332470.jpg","threadsnum":"891","postsnum":1811},{"id":"5996","title":"地板","icon":"http://static-news.17house.com/web/bbs/201604/20/1357349797.jpg","threadsnum":"1175","postsnum":2367},{"id":"15965","title":"门窗","icon":"http://static-news.17house.com/web/bbs/201605/27/1041324340.jpg","threadsnum":"444","postsnum":892},{"id":"10027","title":"木门","icon":"http://static-news.17house.com/web/bbs/201604/20/1358187528.jpg","threadsnum":"348","postsnum":725},{"id":"5494","title":"吊顶","icon":"http://static-news.17house.com/web/bbs/201604/20/1356522038.jpg","threadsnum":"306","postsnum":642},{"id":"4364","title":"净水器","icon":"http://static-news.17house.com/web/bbs/201605/30/1715445493.jpg","threadsnum":"245","postsnum":518},{"id":"9347","title":"散热器","icon":"http://static-news.17house.com/web/bbs/201605/27/1039419177.jpg","threadsnum":"213","postsnum":451},{"id":"11650","title":"热水器","icon":"http://static-news.17house.com/web/bbs/201605/27/1059077899.jpg","threadsnum":"258","postsnum":545},{"id":"7032","title":"定制衣柜","icon":"http://static-news.17house.com/web/bbs/201605/27/1056052818.jpg","threadsnum":"13","postsnum":50},{"id":"21626","title":"烟机灶具","icon":"http://static-news.17house.com/web/bbs/201605/27/1417416643.jpg","threadsnum":"6","postsnum":18},{"id":"19602","title":"墙面材料","icon":"http://static-news.17house.com/web/bbs/201605/27/1054472824.jpg","threadsnum":"1","postsnum":6},{"id":"22497","title":"其他建材","icon":"http://static-news.17house.com/web/bbs/201605/27/1055268152.jpg","threadsnum":"14","postsnum":42}]},{"title":"家具","icon":"http://apptest-picture.oss-cn-beijing.aliyuncs.com/icon/jiaju@3x.png","children":[{"id":"7958","title":"床垫","icon":"http://static-news.17house.com/web/bbs/201605/30/162529682.jpg","threadsnum":"163","postsnum":327},{"id":"10872","title":"沙发","icon":"http://static-news.17house.com/web/bbs/201605/30/1625081084.jpg","threadsnum":"183","postsnum":395},{"id":"7109","title":"实木家具","icon":"http://static-news.17house.com/web/bbs/201605/30/1626407232.jpg","threadsnum":"225","postsnum":466},{"id":"10224","title":"板式家具","icon":"http://static-news.17house.com/web/bbs/201605/30/1625455585.jpg","threadsnum":"110","postsnum":250},{"id":"17060","title":"儿童家具","icon":"http://static-news.17house.com/web/bbs/201605/30/1626051935.jpg","threadsnum":"42","postsnum":89},{"id":"7030","title":"定制家具","icon":"http://static-news.17house.com/web/bbs/201605/30/1624307191.jpg","threadsnum":"178","postsnum":377},{"id":"22501","title":"其他家具","icon":"http://static-news.17house.com/web/bbs/201605/27/1057465912.jpg","threadsnum":"2","postsnum":32}]},{"title":"电器","icon":"http://apptest-picture.oss-cn-beijing.aliyuncs.com/icon/dianqi@3x.png","children":[{"id":"7235","title":"家用电器","icon":"http://static-news.17house.com/web/bbs/201605/27/1059544564.jpg","threadsnum":"10","postsnum":38}]},{"title":"整装套餐","icon":"http://apptest-picture.oss-cn-beijing.aliyuncs.com/icon/zhengzhuang@3x.png","children":[{"id":"22504","title":"新房整装套餐","icon":"http://static-news.17house.com/web/bbs/201605/27/1100242653.jpg","threadsnum":"55","postsnum":121},{"id":"22499","title":"老房整装套餐","icon":"http://static-news.17house.com/web/bbs/201605/27/1100426971.jpg","threadsnum":"73","postsnum":156}]}]
     * error : 0
     * message : 成功
     */

    private String error;
    private String message;
    private List<DataBean> data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 建材
         * icon : http://apptest-picture.oss-cn-beijing.aliyuncs.com/icon/jiancai@3x.png
         * children : [{"id":"12087","title":"瓷砖","icon":"http://static-news.17house.com/web/bbs/201604/20/1400025645.jpg","threadsnum":"375","postsnum":759},{"id":"5104","title":"卫浴","icon":"http://static-news.17house.com/web/bbs/201605/27/1041099278.jpg","threadsnum":"557","postsnum":1140},{"id":"10475","title":"橱柜","icon":"http://static-news.17house.com/web/bbs/201604/20/1358332470.jpg","threadsnum":"891","postsnum":1811},{"id":"5996","title":"地板","icon":"http://static-news.17house.com/web/bbs/201604/20/1357349797.jpg","threadsnum":"1175","postsnum":2367},{"id":"15965","title":"门窗","icon":"http://static-news.17house.com/web/bbs/201605/27/1041324340.jpg","threadsnum":"444","postsnum":892},{"id":"10027","title":"木门","icon":"http://static-news.17house.com/web/bbs/201604/20/1358187528.jpg","threadsnum":"348","postsnum":725},{"id":"5494","title":"吊顶","icon":"http://static-news.17house.com/web/bbs/201604/20/1356522038.jpg","threadsnum":"306","postsnum":642},{"id":"4364","title":"净水器","icon":"http://static-news.17house.com/web/bbs/201605/30/1715445493.jpg","threadsnum":"245","postsnum":518},{"id":"9347","title":"散热器","icon":"http://static-news.17house.com/web/bbs/201605/27/1039419177.jpg","threadsnum":"213","postsnum":451},{"id":"11650","title":"热水器","icon":"http://static-news.17house.com/web/bbs/201605/27/1059077899.jpg","threadsnum":"258","postsnum":545},{"id":"7032","title":"定制衣柜","icon":"http://static-news.17house.com/web/bbs/201605/27/1056052818.jpg","threadsnum":"13","postsnum":50},{"id":"21626","title":"烟机灶具","icon":"http://static-news.17house.com/web/bbs/201605/27/1417416643.jpg","threadsnum":"6","postsnum":18},{"id":"19602","title":"墙面材料","icon":"http://static-news.17house.com/web/bbs/201605/27/1054472824.jpg","threadsnum":"1","postsnum":6},{"id":"22497","title":"其他建材","icon":"http://static-news.17house.com/web/bbs/201605/27/1055268152.jpg","threadsnum":"14","postsnum":42}]
         */

        private String title;
        private String icon;
        private List<ChildrenBean> children;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * id : 12087
             * title : 瓷砖
             * icon : http://static-news.17house.com/web/bbs/201604/20/1400025645.jpg
             * threadsnum : 375
             * postsnum : 759
             */

            private String id;
            private String title;
            private String icon;
            private String threadsnum;
            private int postsnum;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getThreadsnum() {
                return threadsnum;
            }

            public void setThreadsnum(String threadsnum) {
                this.threadsnum = threadsnum;
            }

            public int getPostsnum() {
                return postsnum;
            }

            public void setPostsnum(int postsnum) {
                this.postsnum = postsnum;
            }
        }
    }
}
