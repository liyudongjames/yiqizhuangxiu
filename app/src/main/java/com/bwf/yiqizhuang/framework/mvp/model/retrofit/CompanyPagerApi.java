package com.bwf.yiqizhuang.framework.mvp.model.retrofit;

/**
 * Created by Administrator on 2016/11/29.
 */


import com.bwf.yiqizhuang.framework.mvp.databean.CompanyViewPagerResponse;
import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 *  http://appapi.17house.com/AppManagerApi.php?
 *  version=1&
 *  action=integratedpackag&
 *  model=android&
 *  app_version=android_com.aiyiqi.galaxy_1.1
 */
public interface CompanyPagerApi {
    @GET("AppManagerApi.php")
    Observable<CompanyViewPagerResponse> getPager(@Query("version") int version,
                                                  @Query("action") String action,
                                                  @Query("model") String model,
                                                  @Query("app_version") String app_version);
}
