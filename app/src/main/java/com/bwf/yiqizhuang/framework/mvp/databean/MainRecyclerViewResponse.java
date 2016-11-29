package com.bwf.yiqizhuang.framework.mvp.databean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class MainRecyclerViewResponse {


    /**
     * data : [{"type":3,"id":"1218347","title":"报道|一起装修网第八届装修日记大赛总决赛精彩落幕~","author":"怪兽","uid":"1482689","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1482689&size=big","dateline":"19小时前","sort":"1480323577","views":"167","replies":"9","like_num":4,"path":"http://static-news.17house.com/bbs/forum/201611/28/165711j105ck6k6gwqr0dq.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218337","title":"装修合同七大陷阱遭曝光，你不可不知！","author":"疯子的鞋","uid":"1487957","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1487957&size=big","dateline":"20小时前","sort":"1480319702","views":"125","replies":"0","like_num":1,"path":"http://static-news.17house.com/bbs/forum/201611/28/154941r85h8hynvujfoho5.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218286","title":"到底选择装修公司还是装修队？装修必看！","author":"burns","uid":"1513721","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1513721&size=big","dateline":"20小时前","sort":"1480319144","views":"144","replies":"2","like_num":1,"path":"http://static-news.17house.com/bbs/forum/201611/28/112659ikcidi2ggigv9g4q.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":1,"id":"259611","title":"没有独立书房，如何布置工作区？","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/28/201611281416519004.png","views":166,"like_num":0,"replies":"0","dateline":"22小时前","sort":"1480314240","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/259611.html"},{"type":1,"id":"259604","title":"又暖又萌又优雅，蓝色的家原来还可以这样燃！","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/28/201611281406251147.jpg","views":169,"like_num":0,"replies":"0","dateline":"22小时前","sort":"1480313280","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/259604.html"},{"type":1,"id":"259599","title":"阳台这么装，绝不再是冬日禁区","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/28/201611281353269308.jpg","views":225,"like_num":0,"replies":"0","dateline":"22小时前","sort":"1480312500","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/259599.html"},{"type":3,"id":"1218293","title":"虫哥和猫猫的书窝搭建小记之五十七\u2014\u2014日记大赛，情怀延续","author":"喝普洱的猫猫","uid":"1545248","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1545248&size=big","dateline":"24小时前","sort":"1480305790","views":"564","replies":"15","like_num":11,"path":"http://static-news.17house.com/web/bbs/201611/28/1156407946.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218276","title":"感谢飞美，感谢安装师傅，飞美家具真的很美","author":"ttxs","uid":"844311","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=844311&size=big","dateline":"2天前","sort":"1480297643","views":"53","replies":"1","like_num":3,"path":"http://static-news.17house.com/bbs/forum/201611/28/102344dee87pfeyaq7hfee.jpg!w720","forum":{"fid":"4253","name":"北京飞美家具论坛"},"followed":0},{"type":3,"id":"1218226","title":"程仪兵星级工长","author":"手机用户_1371560","uid":"1371560","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1371560&size=big","dateline":"3天前","sort":"1480209421","views":"213","replies":"2","like_num":1,"path":null,"forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218224","title":"明年装修建材都要涨价了，今年团购会参加一场少一场了，还不快来订下实惠？","author":"怪兽","uid":"1482689","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1482689&size=big","dateline":"3天前","sort":"1480208074","views":"366","replies":"11","like_num":0,"path":"http://static-news.17house.com/web/bbs/201611/27/0853085549.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0}]
     * newCount : 8
     * currentPage : 1
     * totalCount : 150
     * error : 0
     * message : 成功
     */

    private int newCount;
    private int currentPage;
    private int totalCount;
    private String error;
    private String message;
    /**
     * type : 3
     * id : 1218347
     * title : 报道|一起装修网第八届装修日记大赛总决赛精彩落幕~
     * author : 怪兽
     * uid : 1482689
     * avtUrl : http://bbs.17house.com/uc_server/avatar.php?uid=1482689&size=big
     * dateline : 19小时前
     * sort : 1480323577
     * views : 167
     * replies : 9
     * like_num : 4
     * path : http://static-news.17house.com/bbs/forum/201611/28/165711j105ck6k6gwqr0dq.jpg!w720
     * forum : {"fid":"2","name":"北京装修论坛"}
     * followed : 0
     */

    private List<DataBean> data;

    public int getNewCount() {
        return newCount;
    }

    public void setNewCount(int newCount) {
        this.newCount = newCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

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
        private int type;
        private String id;
        private String title;
        private String author;
        private String uid;
        private String avtUrl;
        private String dateline;
        private String sort;
        private String views;
        private String replies;
        private int like_num;
        private String path;
        /**
         * fid : 2
         * name : 北京装修论坛
         */

        private ForumBean forum;
        private int followed;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

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

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAvtUrl() {
            return avtUrl;
        }

        public void setAvtUrl(String avtUrl) {
            this.avtUrl = avtUrl;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getReplies() {
            return replies;
        }

        public void setReplies(String replies) {
            this.replies = replies;
        }

        public int getLike_num() {
            return like_num;
        }

        public void setLike_num(int like_num) {
            this.like_num = like_num;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public ForumBean getForum() {
            return forum;
        }

        public void setForum(ForumBean forum) {
            this.forum = forum;
        }

        public int getFollowed() {
            return followed;
        }

        public void setFollowed(int followed) {
            this.followed = followed;
        }

        public static class ForumBean {
            private String fid;
            private String name;

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
