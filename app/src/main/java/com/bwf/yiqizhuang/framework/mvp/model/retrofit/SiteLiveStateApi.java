package com.bwf.yiqizhuang.framework.mvp.model.retrofit;

/**
 * Created by Administrator on 2016/12/1.
 */

import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;
import com.bwf.yiqizhuang.framework.mvp.databean.SiteLiveStateResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * http://hui.17house.com/svc/payment-facade/housekeep/getLiveBuildingSite
 * token: DAB088BA50C9405E84C789055D657614
 * app_version: android_com.aiyiqi.galaxy_1.1
 * buildingId： 建筑id，此处取0的接口信息
 */

public interface SiteLiveStateApi {
    @GET("svc/payment-facade/housekeep/getLiveBuildingSite")
    Observable<SiteLiveStateResponse> getSiteLiveState(@Query("token") String token,
                                                       @Query("app_version") String app_version,
                                                       @Query("buildingId") int buildingId);
}
