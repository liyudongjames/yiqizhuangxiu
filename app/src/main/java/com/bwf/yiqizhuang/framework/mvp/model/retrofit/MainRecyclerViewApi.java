package com.bwf.yiqizhuang.framework.mvp.model.retrofit;

import com.bwf.yiqizhuang.framework.mvp.databean.MainRecyclerViewResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/28.
 * http://bbs.17house.com
 * /motnt/index.php?
 * a=appindex&
 * c=index&
 * id=1218226&
 * uuid=86305803367590&
 * pageSize=10&
 * uid=1633055&
 * m=misc&
 * type=3&
 * page=1&
 * haspermission=yes&
 * model=android&
 * sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&
 * app_version=android_com.aiyiqi.galaxy_1.1
 */

public interface MainRecyclerViewApi {
    @GET("/motnt/index.php")
    Observable<MainRecyclerViewResponse> getMainData(@Query("a") String a,
                                                     @Query("c")String c,
                                                     @Query("id")int id,
                                                     @Query("uuid")long uuid,
                                                     @Query("pageSize")int pageSize,
                                                     @Query("uid")long uid,
                                                     @Query("m")String m,
                                                     @Query("type")int type,
                                                     @Query("page")int page,
                                                     @Query("haspermission")String haspermission,
                                                     @Query("model")String model,
                                                     @Query("sessionToken")String sessionToken,
                                                     @Query("app_version")String app_version
                                                     );
}
