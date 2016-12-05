package com.bwf.yiqizhuang.framework.mvp.model.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.CityResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.CityModel;
import com.bwf.yiqizhuang.framework.mvp.model.OkHttp.CityResponseCallBack;
import com.zhy.http.okhttp.OkHttpUtils;

import okhttp3.Call;

/**
 * http://bbs.17house.com/motnt/index.php?
 * a=activityThreadlist&
 * c=forumThreadList&
 * uuid=a444d1b2af4f&
 * pageSize=10&uid=1633055&
 * cityName=%E6%88%90%E9%83%BD&
 * m=forum&
 * page=1&
 * model=android&
 * sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&
 * app_version=android_com.aiyiqi.galaxy_1.1
 （返回的数据页面的item点击跳转h5网页）
 请求参数：
 page：页数
 pageSize：一页显示的个数，默认是10
 */

public class CityModelImpl implements CityModel {
    @Override
    public void getCityDatas(final ModelBaseCallBack<CityResponse> callBack) {
        OkHttpUtils.get()
                .url("http://bbs.17house.com/motnt/index.php")
                .addParams("a","activityThreadlist")
                .addParams("c","forumThreadList")
                .addParams("uuid","a444d1b2af4f")
                .addParams("pageSize","10")
                .addParams("cityName","%E6%88%90%E9%83%BD")
                .addParams("m","forum")
                .addParams("page","1")
                .addParams("model","android")
                .addParams("sessionToken","6U49kCYKE260RqvPqEdFsBGskNQStKhm")
                .addParams("app_version","android_com.aiyiqi.galaxy_1.1")
                .build()
        .execute(new CityResponseCallBack() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callBack.onFailed(e);
            }

            @Override
            public void onResponse(CityResponse response, int id) {
                callBack.onNext(response);
                callBack.onComplete();
            }
        });

    }
}
