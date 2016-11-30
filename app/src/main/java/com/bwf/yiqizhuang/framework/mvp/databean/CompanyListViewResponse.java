package com.bwf.yiqizhuang.framework.mvp.databean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */

public class CompanyListViewResponse {

    /**
     * code : 0
     * message : success
     */

    private BaseOutputBean baseOutput;
    /**
     * buildingSite : {"buildingId":1551305743512118865,"statusId":0,"progressId":2,"acceptanceProgressId":0,"orderId":1551305743512118865,"createTime":1479440576000,"updateTime":1480410354000,"userId":1548265227095652874,"startDisclosure":1,"startDisclosureTime":1480494522262,"splitAlter":0,"splitAlterTime":1480494522262,"waterElectricity":0,"waterElectricityTime":1480494522262,"cementWood":0,"cementWoodTime":1480494522262,"paint":0,"paintTime":1480494522262,"installation":0,"installationTime":1480494522262,"finish":0,"finishTime":1480494522262,"buildingIdStr":"1551305743512118865","acceptanceStatus":0,"bespeakExpired":0,"messageNumber":7,"scheduleStatus":0,"isShow":1}
     * orderHouse : {"orderId":1551305743512118865,"layout":"2室1厅1厨1卫","area":"82.66","doorplate":"6-2303","community":"朝阳区","address":"北苑家园绣菊园","newHouse":0,"deliveryHouse":2,"lng":116.425772,"lat":40.044762}
     * userDetail : {"userId":1548265227095652874,"realName":"霍雨佳","gender":0,"emailVerified":0,"provinceId":0,"cityId":0,"districtId":0,"userPoint":0,"userLevel":0,"hasOrder":0,"updateTime":1476540782000,"userPointIncrement":0,"userPointDate":1476540782000,"mobile":"18501168939","mobileLocation":"北京","userType":0,"bgCardNum":"0"}
     * imageUrl : http://apptest-picture.oss-cn-beijing.aliyuncs.com/yiqizhuagnxiu-gongdizhibo/tu10.png
     * latestTrackProgressId : 0
     */

    private List<DataBean> data;

    public BaseOutputBean getBaseOutput() {
        return baseOutput;
    }

    public void setBaseOutput(BaseOutputBean baseOutput) {
        this.baseOutput = baseOutput;
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

    public static class DataBean {
        /**
         * buildingId : 1551305743512118865
         * statusId : 0
         * progressId : 2
         * acceptanceProgressId : 0
         * orderId : 1551305743512118865
         * createTime : 1479440576000
         * updateTime : 1480410354000
         * userId : 1548265227095652874
         * startDisclosure : 1
         * startDisclosureTime : 1480494522262
         * splitAlter : 0
         * splitAlterTime : 1480494522262
         * waterElectricity : 0
         * waterElectricityTime : 1480494522262
         * cementWood : 0
         * cementWoodTime : 1480494522262
         * paint : 0
         * paintTime : 1480494522262
         * installation : 0
         * installationTime : 1480494522262
         * finish : 0
         * finishTime : 1480494522262
         * buildingIdStr : 1551305743512118865
         * acceptanceStatus : 0
         * bespeakExpired : 0
         * messageNumber : 7
         * scheduleStatus : 0
         * isShow : 1
         */

        private BuildingSiteBean buildingSite;
        /**
         * orderId : 1551305743512118865
         * layout : 2室1厅1厨1卫
         * area : 82.66
         * doorplate : 6-2303
         * community : 朝阳区
         * address : 北苑家园绣菊园
         * newHouse : 0
         * deliveryHouse : 2
         * lng : 116.425772
         * lat : 40.044762
         */

        private OrderHouseBean orderHouse;
        /**
         * userId : 1548265227095652874
         * realName : 霍雨佳
         * gender : 0
         * emailVerified : 0
         * provinceId : 0
         * cityId : 0
         * districtId : 0
         * userPoint : 0
         * userLevel : 0
         * hasOrder : 0
         * updateTime : 1476540782000
         * userPointIncrement : 0
         * userPointDate : 1476540782000
         * mobile : 18501168939
         * mobileLocation : 北京
         * userType : 0
         * bgCardNum : 0
         */

        private UserDetailBean userDetail;
        private String imageUrl;
        private int latestTrackProgressId;

        public BuildingSiteBean getBuildingSite() {
            return buildingSite;
        }

        public void setBuildingSite(BuildingSiteBean buildingSite) {
            this.buildingSite = buildingSite;
        }

        public OrderHouseBean getOrderHouse() {
            return orderHouse;
        }

        public void setOrderHouse(OrderHouseBean orderHouse) {
            this.orderHouse = orderHouse;
        }

        public UserDetailBean getUserDetail() {
            return userDetail;
        }

        public void setUserDetail(UserDetailBean userDetail) {
            this.userDetail = userDetail;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getLatestTrackProgressId() {
            return latestTrackProgressId;
        }

        public void setLatestTrackProgressId(int latestTrackProgressId) {
            this.latestTrackProgressId = latestTrackProgressId;
        }

        public static class BuildingSiteBean {
            private long buildingId;
            private int statusId;
            private int progressId;
            private int acceptanceProgressId;
            private long orderId;
            private long createTime;
            private long updateTime;
            private long userId;
            private int startDisclosure;
            private long startDisclosureTime;
            private int splitAlter;
            private long splitAlterTime;
            private int waterElectricity;
            private long waterElectricityTime;
            private int cementWood;
            private long cementWoodTime;
            private int paint;
            private long paintTime;
            private int installation;
            private long installationTime;
            private int finish;
            private long finishTime;
            private String buildingIdStr;
            private int acceptanceStatus;
            private int bespeakExpired;
            private int messageNumber;
            private int scheduleStatus;
            private int isShow;

            public long getBuildingId() {
                return buildingId;
            }

            public void setBuildingId(long buildingId) {
                this.buildingId = buildingId;
            }

            public int getStatusId() {
                return statusId;
            }

            public void setStatusId(int statusId) {
                this.statusId = statusId;
            }

            public int getProgressId() {
                return progressId;
            }

            public void setProgressId(int progressId) {
                this.progressId = progressId;
            }

            public int getAcceptanceProgressId() {
                return acceptanceProgressId;
            }

            public void setAcceptanceProgressId(int acceptanceProgressId) {
                this.acceptanceProgressId = acceptanceProgressId;
            }

            public long getOrderId() {
                return orderId;
            }

            public void setOrderId(long orderId) {
                this.orderId = orderId;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public int getStartDisclosure() {
                return startDisclosure;
            }

            public void setStartDisclosure(int startDisclosure) {
                this.startDisclosure = startDisclosure;
            }

            public long getStartDisclosureTime() {
                return startDisclosureTime;
            }

            public void setStartDisclosureTime(long startDisclosureTime) {
                this.startDisclosureTime = startDisclosureTime;
            }

            public int getSplitAlter() {
                return splitAlter;
            }

            public void setSplitAlter(int splitAlter) {
                this.splitAlter = splitAlter;
            }

            public long getSplitAlterTime() {
                return splitAlterTime;
            }

            public void setSplitAlterTime(long splitAlterTime) {
                this.splitAlterTime = splitAlterTime;
            }

            public int getWaterElectricity() {
                return waterElectricity;
            }

            public void setWaterElectricity(int waterElectricity) {
                this.waterElectricity = waterElectricity;
            }

            public long getWaterElectricityTime() {
                return waterElectricityTime;
            }

            public void setWaterElectricityTime(long waterElectricityTime) {
                this.waterElectricityTime = waterElectricityTime;
            }

            public int getCementWood() {
                return cementWood;
            }

            public void setCementWood(int cementWood) {
                this.cementWood = cementWood;
            }

            public long getCementWoodTime() {
                return cementWoodTime;
            }

            public void setCementWoodTime(long cementWoodTime) {
                this.cementWoodTime = cementWoodTime;
            }

            public int getPaint() {
                return paint;
            }

            public void setPaint(int paint) {
                this.paint = paint;
            }

            public long getPaintTime() {
                return paintTime;
            }

            public void setPaintTime(long paintTime) {
                this.paintTime = paintTime;
            }

            public int getInstallation() {
                return installation;
            }

            public void setInstallation(int installation) {
                this.installation = installation;
            }

            public long getInstallationTime() {
                return installationTime;
            }

            public void setInstallationTime(long installationTime) {
                this.installationTime = installationTime;
            }

            public int getFinish() {
                return finish;
            }

            public void setFinish(int finish) {
                this.finish = finish;
            }

            public long getFinishTime() {
                return finishTime;
            }

            public void setFinishTime(long finishTime) {
                this.finishTime = finishTime;
            }

            public String getBuildingIdStr() {
                return buildingIdStr;
            }

            public void setBuildingIdStr(String buildingIdStr) {
                this.buildingIdStr = buildingIdStr;
            }

            public int getAcceptanceStatus() {
                return acceptanceStatus;
            }

            public void setAcceptanceStatus(int acceptanceStatus) {
                this.acceptanceStatus = acceptanceStatus;
            }

            public int getBespeakExpired() {
                return bespeakExpired;
            }

            public void setBespeakExpired(int bespeakExpired) {
                this.bespeakExpired = bespeakExpired;
            }

            public int getMessageNumber() {
                return messageNumber;
            }

            public void setMessageNumber(int messageNumber) {
                this.messageNumber = messageNumber;
            }

            public int getScheduleStatus() {
                return scheduleStatus;
            }

            public void setScheduleStatus(int scheduleStatus) {
                this.scheduleStatus = scheduleStatus;
            }

            public int getIsShow() {
                return isShow;
            }

            public void setIsShow(int isShow) {
                this.isShow = isShow;
            }
        }

        public static class OrderHouseBean {
            private long orderId;
            private String layout;
            private String area;
            private String doorplate;
            private String community;
            private String address;
            private int newHouse;
            private int deliveryHouse;
            private double lng;
            private double lat;

            public long getOrderId() {
                return orderId;
            }

            public void setOrderId(long orderId) {
                this.orderId = orderId;
            }

            public String getLayout() {
                return layout;
            }

            public void setLayout(String layout) {
                this.layout = layout;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getDoorplate() {
                return doorplate;
            }

            public void setDoorplate(String doorplate) {
                this.doorplate = doorplate;
            }

            public String getCommunity() {
                return community;
            }

            public void setCommunity(String community) {
                this.community = community;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getNewHouse() {
                return newHouse;
            }

            public void setNewHouse(int newHouse) {
                this.newHouse = newHouse;
            }

            public int getDeliveryHouse() {
                return deliveryHouse;
            }

            public void setDeliveryHouse(int deliveryHouse) {
                this.deliveryHouse = deliveryHouse;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }

        public static class UserDetailBean {
            private long userId;
            private String realName;
            private int gender;
            private int emailVerified;
            private int provinceId;
            private int cityId;
            private int districtId;
            private int userPoint;
            private int userLevel;
            private int hasOrder;
            private long updateTime;
            private int userPointIncrement;
            private long userPointDate;
            private String mobile;
            private String mobileLocation;
            private int userType;
            private String bgCardNum;

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getEmailVerified() {
                return emailVerified;
            }

            public void setEmailVerified(int emailVerified) {
                this.emailVerified = emailVerified;
            }

            public int getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(int provinceId) {
                this.provinceId = provinceId;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public int getDistrictId() {
                return districtId;
            }

            public void setDistrictId(int districtId) {
                this.districtId = districtId;
            }

            public int getUserPoint() {
                return userPoint;
            }

            public void setUserPoint(int userPoint) {
                this.userPoint = userPoint;
            }

            public int getUserLevel() {
                return userLevel;
            }

            public void setUserLevel(int userLevel) {
                this.userLevel = userLevel;
            }

            public int getHasOrder() {
                return hasOrder;
            }

            public void setHasOrder(int hasOrder) {
                this.hasOrder = hasOrder;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getUserPointIncrement() {
                return userPointIncrement;
            }

            public void setUserPointIncrement(int userPointIncrement) {
                this.userPointIncrement = userPointIncrement;
            }

            public long getUserPointDate() {
                return userPointDate;
            }

            public void setUserPointDate(long userPointDate) {
                this.userPointDate = userPointDate;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getMobileLocation() {
                return mobileLocation;
            }

            public void setMobileLocation(String mobileLocation) {
                this.mobileLocation = mobileLocation;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public String getBgCardNum() {
                return bgCardNum;
            }

            public void setBgCardNum(String bgCardNum) {
                this.bgCardNum = bgCardNum;
            }
        }
    }
}
