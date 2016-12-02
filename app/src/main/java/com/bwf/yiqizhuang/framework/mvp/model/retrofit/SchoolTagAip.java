package com.bwf.yiqizhuang.framework.mvp.model.retrofit;

import com.bwf.yiqizhuang.framework.mvp.databean.SchoolTagResponseT_T;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * http://appapi.17house.com/StageApi.php?version=1&action=getTagsByStage&stage=1&model=android
 * 请求参数：
 * version：版本，此处为固定值1
 * action：用户行为，getTagsByStage（根据阶段获取tag列表）
 * stage：阶段，值从1到17取
 * model：android（固定值）
 */

public interface SchoolTagAip {
    @GET("StageApi.php?version=1&action=getTagsByStage&stage=1&model=android")
    Observable<SchoolTagResponseT_T> getTag(@Query("version") int version,
                                            @Query("action") String action,
                                            @Query("stage") int stage,
                                            @Query("model") String model);
}
