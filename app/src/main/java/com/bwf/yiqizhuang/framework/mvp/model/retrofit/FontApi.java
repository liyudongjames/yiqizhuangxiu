package com.bwf.yiqizhuang.framework.mvp.model.retrofit;


import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/25.
 */
//http://118.178.142.34/YiQiHouse/HomeAD
public interface FontApi {
    @GET("AppManagerApi.php")
    Observable<FontPagePagerResponse> getFront(@Query("version") int version
            ,@Query("action") String action,@Query("cityId") int cityId,@Query("model")String model);
}