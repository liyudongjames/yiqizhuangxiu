package com.bwf.yiqizhuang.framework.mvp.model.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.ResultBeautyResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.ResultBeautyModel;
import com.bwf.yiqizhuang.framework.mvp.model.retrofit.ResultBeautyApi;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
public class ResultBeautyModelImpl implements ResultBeautyModel{
    private String baseUrl = "http://appapi.17house.com/";

    @Override
    public void getBeauty(final ModelBaseCallBack<ResultBeautyResponse> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ResultBeautyApi api = retrofit.create(ResultBeautyApi.class);
        api.getBeauty(1,1,"imageList2",10,0,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResultBeautyResponse>() {
                    @Override
                    public void onCompleted() {
                        callBack.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailed(e);
                    }

                    @Override
                    public void onNext(ResultBeautyResponse resultBeautyResponse) {
                        callBack.onNext(resultBeautyResponse);
                    }
                });
    }
}
