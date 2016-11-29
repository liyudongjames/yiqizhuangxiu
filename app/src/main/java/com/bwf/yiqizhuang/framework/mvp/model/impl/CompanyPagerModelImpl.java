package com.bwf.yiqizhuang.framework.mvp.model.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.CompanyViewPagerResponse;
import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.CompanyPagerModel;
import com.bwf.yiqizhuang.framework.mvp.model.retrofit.CompanyPagerApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
/**
 *  http://appapi.17house.com/AppManagerApi.php?
 *  version=1&
 *  action=integratedpackage&
 *  model=android&
 *  app_version=android_com.aiyiqi.galaxy_1.1
 */
public class CompanyPagerModelImpl implements CompanyPagerModel{
    private String baseUrl = "http://appapi.17house.com/";
    @Override
    public void startGetPager(final ModelBaseCallBack<CompanyViewPagerResponse> callBack) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CompanyPagerApi api = retrofit.create(CompanyPagerApi.class);
        api.getPager(1,"integratedpackage","android","android_com.aiyiqi.galaxy_1.1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CompanyViewPagerResponse>() {
                    @Override
                    public void onCompleted() {
                        callBack.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailed(e);
                    }

                    @Override
                    public void onNext(CompanyViewPagerResponse companyViewPagerResponse) {
                        callBack.onNext(companyViewPagerResponse);
                    }
                });

    }
}
