package com.bwf.yiqizhuang.framework.mvp.model.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.MainViewPagerModel;
import com.bwf.yiqizhuang.framework.mvp.model.retrofit.FontApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/11/25.
 */

public class MainViewPagerModelImpl implements MainViewPagerModel{
    public String baseUrl = "http://appapi.17house.com/";
    @Override
    public void startViewPager(final ModelBaseCallBack<FontPagePagerResponse> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        FontApi api = retrofit.create(FontApi.class);
        api.getFront(1,"getownerinfo",2,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FontPagePagerResponse>() {
                    @Override
                    public void onCompleted() {
                        callBack.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailed(e);
                    }

                    @Override
                    public void onNext(FontPagePagerResponse fontPagePagerResponse) {
                        callBack.onNext(fontPagePagerResponse);
                    }
                });
    }
}
