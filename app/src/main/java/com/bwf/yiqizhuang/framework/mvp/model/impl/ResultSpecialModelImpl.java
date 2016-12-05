package com.bwf.yiqizhuang.framework.mvp.model.impl;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.databean.ResultSpeciaResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.ResultSpecialModel;
import com.bwf.yiqizhuang.framework.mvp.model.retrofit.ResultSpecialApi;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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


public class ResultSpecialModelImpl implements ResultSpecialModel {

    private String baseUrl = "http://appapi.17house.com/";

    @Override
    public void getSpecial(int page, final ModelBaseCallBack<ResultSpeciaResponse> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory( GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ResultSpecialApi api = retrofit.create(ResultSpecialApi.class);
        api.getSpecial(1,page,"albumList2",10,1,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResultSpeciaResponse>() {
                    @Override
                    public void onCompleted() {
                        callBack.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailed(e);
                    }

                    @Override
                    public void onNext(ResultSpeciaResponse resultSpeciaResponse) {
                        callBack.onNext(resultSpeciaResponse);
                    }
                });
    }
}
