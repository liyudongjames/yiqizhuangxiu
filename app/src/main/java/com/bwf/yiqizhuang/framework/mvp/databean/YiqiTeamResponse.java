package com.bwf.yiqizhuang.framework.mvp.databean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */

public class YiqiTeamResponse {

    /**
     * code : 0
     * message : success
     */

    private BaseOutputBean baseOutput;
    /**
     * pageNo : 0
     * pageSize : 10
     * pageTotalNum : 101
     */

    private PageInfoBean pageInfo;
    /**
     * vendorId : 27
     * vendorName : 朱文君
     * realName : 朱文君
     * nickName : 朱文君
     * avatar : http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1476267743611661027
     * lifePhoto : http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1476267780017840660
     * signature : 坚持用设计服务生活
     * provinceId : 12
     * workYear : 2009
     * goodAt : 现代 北欧 现代简约 简欧
     * updateTime : 1455849695000
     * vendorAccount : 18610125383
     * bossId : 1701
     * storeId : 1717
     * storeName : 一起网服务
     * provinceName : 安徽省
     * workTimeSpan : 7
     * caseNumber : 18
     * messageNumber : 0
     * sponsorNumber : 0
     * rating : 5
     * registerTime : 1455849663000
     * commentCount : 0
     */

    private List<DataBean> data;

    public BaseOutputBean getBaseOutput() {
        return baseOutput;
    }

    public void setBaseOutput(BaseOutputBean baseOutput) {
        this.baseOutput = baseOutput;
    }

    public PageInfoBean getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoBean pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class BaseOutputBean {
        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class PageInfoBean {
        private int pageNo;
        private int pageSize;
        private int pageTotalNum;

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

        public int getPageTotalNum() {
            return pageTotalNum;
        }

        public void setPageTotalNum(int pageTotalNum) {
            this.pageTotalNum = pageTotalNum;
        }
    }

    public static class DataBean {
        private String vendorId;
        private String vendorName;
        private String realName;
        private String nickName;
        private String avatar;
        private String lifePhoto;
        private String signature;
        private String provinceId;
        private String workYear;
        private String goodAt;
        private String updateTime;
        private String vendorAccount;
        private String bossId;
        private String storeId;
        private String storeName;
        private String provinceName;
        private String workTimeSpan;
        private String caseNumber;
        private String messageNumber;
        private String sponsorNumber;
        private String rating;
        private String registerTime;
        private String commentCount;

        public String getVendorId() {
            return vendorId;
        }

        public void setVendorId(String vendorId) {
            this.vendorId = vendorId;
        }

        public String getVendorName() {
            return vendorName;
        }

        public void setVendorName(String vendorName) {
            this.vendorName = vendorName;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getLifePhoto() {
            return lifePhoto;
        }

        public void setLifePhoto(String lifePhoto) {
            this.lifePhoto = lifePhoto;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(String provinceId) {
            this.provinceId = provinceId;
        }

        public String getWorkYear() {
            return workYear;
        }

        public void setWorkYear(String workYear) {
            this.workYear = workYear;
        }

        public String getGoodAt() {
            return goodAt;
        }

        public void setGoodAt(String goodAt) {
            this.goodAt = goodAt;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getVendorAccount() {
            return vendorAccount;
        }

        public void setVendorAccount(String vendorAccount) {
            this.vendorAccount = vendorAccount;
        }

        public String getBossId() {
            return bossId;
        }

        public void setBossId(String bossId) {
            this.bossId = bossId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getWorkTimeSpan() {
            return workTimeSpan;
        }

        public void setWorkTimeSpan(String workTimeSpan) {
            this.workTimeSpan = workTimeSpan;
        }

        public String getCaseNumber() {
            return caseNumber;
        }

        public void setCaseNumber(String caseNumber) {
            this.caseNumber = caseNumber;
        }

        public String getMessageNumber() {
            return messageNumber;
        }

        public void setMessageNumber(String messageNumber) {
            this.messageNumber = messageNumber;
        }

        public String getSponsorNumber() {
            return sponsorNumber;
        }

        public void setSponsorNumber(String sponsorNumber) {
            this.sponsorNumber = sponsorNumber;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(String registerTime) {
            this.registerTime = registerTime;
        }

        public String getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(String commentCount) {
            this.commentCount = commentCount;
        }
    }
}
