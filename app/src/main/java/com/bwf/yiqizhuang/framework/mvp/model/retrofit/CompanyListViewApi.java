package com.bwf.yiqizhuang.framework.mvp.model.retrofit;

/**
 * Created by Administrator on 2016/11/30.
 */

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * http://hui.17house.com/svc/payment-facade/housekeep/listLatestLiveBuildingSites
 *
 * token: DAB088BA50C9405E84C789055D657614
    city_id: 2
    cityName: 成都
    app_version: android_com.aiyiqi.galaxy_1.1
 *
 */
public interface CompanyListViewApi {
    @POST("svc/payment-facade/housekeep/listLatestLiveBuildingSites")
    Observable<com.bwf.yiqizhuang.framework.mvp.databean.CompanyListViewResponse>
    getListViewResponse(@Query("token") String token,
                        @Query("city_id") int city_id,
                        @Query("cityName") String cityName,
                        @Query("app_version") String app_version);
}
