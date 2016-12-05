package com.bwf.yiqizhuang.framework.mvp.model.retrofit;

import com.bwf.yiqizhuang.framework.mvp.databean.ResultSpeciaResponse;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by liyudongjames on 2016/12/5.
 * http://appapi.17house.com/xiaoguotuApi.php?version=1&page=1&action=albumList2&pageSize=10&tagid=1&model=android
 * 请求参数：
 * version：版本，此处为固定值1
 * page：页数
 * pagesize：一页的数据条数
 * action：ablumList2（专题）
 * tagid ： 1
 * model：android（固定值）
 */

public interface ResultSpecialApi {
    @GET("xiaoguotuApi.php")
    Observable<ResultSpeciaResponse> getSpecial(@Query("version") int version,
                                                @Query("page") int page,
                                                @Query("action") String action,
                                                @Query("pageSize") int pagersize,
                                                @Query("tagid") int tagid,
                                                @Query("model") String model);
}
