package com.bwf.yiqizhuang.framework.mvp.model.retrofit;

import com.bwf.yiqizhuang.framework.mvp.databean.ResultBeautyResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 *   http://appapi.17house.com/xiaoguotuApi.php?version=1&page=1&action=imageList2&pageSize=10&tagid=0&model=android
 *   请求参数：
 *   version：版本，此处为固定值1
 *   page：页数
 *   pagesize：一页的数据条数
 *   action：imageList2（美图）
 *   tagid ： 0（全部），筛选的话更换tagid即可，多项筛选tagid格式为 1，1，1，1
 *   model：android（固定值）
 */

public interface ResultBeautyApi {
    @GET("xiaoguotuApi.php")
    Observable<ResultBeautyResponse> getBeauty(@Query("version") int version,
                                               @Query("page") int page,
                                               @Query("action") String action,
                                               @Query("pageSize") int pagesize,
                                               @Query("tagid") int tagid,
                                               @Query("model") String model);
}
