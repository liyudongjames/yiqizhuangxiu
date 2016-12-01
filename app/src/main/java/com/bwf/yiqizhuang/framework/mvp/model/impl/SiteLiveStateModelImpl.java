package com.bwf.yiqizhuang.framework.mvp.model.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;
import com.bwf.yiqizhuang.framework.mvp.databean.SiteLiveStateResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.SiteLiveStateModel;
import com.bwf.yiqizhuang.framework.mvp.model.retrofit.SiteLiveStateApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * http://hui.17house.com/svc/payment-facade/housekeep/getLiveBuildingSite
 * token: DAB088BA50C9405E84C789055D657614
 * app_version: android_com.aiyiqi.galaxy_1.1
 * buildingId： 建筑id，此处取0的接口信息
 */

public class SiteLiveStateModelImpl implements SiteLiveStateModel{
    String baseUrl = "http://hui.17house.com/";

    @Override
    public void getStateLiveStateResponse(final ModelBaseCallBack<SiteLiveStateResponse> callBack, int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SiteLiveStateApi api = retrofit.create(SiteLiveStateApi.class);
        api.getSiteLiveState("DAB088BA50C9405E84C789055D657614","android_com.aiyiqi.galaxy_1.1",id)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Subscriber<SiteLiveStateResponse>() {
            @Override
            public void onCompleted() {
                callBack.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onFailed(e);
            }

            @Override
            public void onNext(SiteLiveStateResponse response) {
                callBack.onNext(response);
            }
        });
    }
}
