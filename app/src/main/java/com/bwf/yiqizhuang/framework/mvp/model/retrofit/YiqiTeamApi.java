package com.bwf.yiqizhuang.framework.mvp.model.retrofit;

import com.bwf.yiqizhuang.framework.mvp.databean.SiteLiveStateResponse;
import com.bwf.yiqizhuang.framework.mvp.databean.YiqiTeamResponse;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteVendors
 *
 * token: DAB088BA50C9405E84C789055D657614
 * app_version : android_com.aiyiqi.galaxy_1.1（固定参数）
 * type: 1701（设计师），1702（监理），1703（工长）
 * haspermission: yes
 * pageNo : 页数，默认0
 * pageSize： 一页的数据条数，默认10
 *
 *
 */

public interface YiqiTeamApi {
    @POST("svc/payment-facade/housekeep/listBuildingSiteVendors")
    Observable<YiqiTeamResponse> getYiqiTeam(@Query("token") String token,
                                             @Query("app_version") String app_version,
                                             @Query("type") int type,
                                             @Query("haspermission") String haspermission,
                                             @Query("pageNo") int pageNo,
                                             @Query("pageSize") int pageSize);
}
