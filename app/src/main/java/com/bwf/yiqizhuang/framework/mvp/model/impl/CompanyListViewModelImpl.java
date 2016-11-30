package com.bwf.yiqizhuang.framework.mvp.model.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.CompanyListViewResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.CompanyListViewModel;
import com.bwf.yiqizhuang.framework.mvp.model.retrofit.CompanyListViewApi;
import com.bwf.yiqizhuang.framework.mvp.model.retrofit.CompanyPagerApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * http://hui.17house.com/svc/payment-facade/housekeep/listLatestLiveBuildingSites
 *
 * token: DAB088BA50C9405E84C789055D657614
 * city_id: 2
 * cityName: 成都
 * app_version: android_com.aiyiqi.galaxy_1.1
 *
 */
public class CompanyListViewModelImpl implements CompanyListViewModel{
    private String baseUrl = "http://hui.17house.com/";

    @Override
    public void startGetCompanyListViewData(final ModelBaseCallBack<CompanyListViewResponse> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        CompanyListViewApi api = retrofit.create(CompanyListViewApi.class);
        api.getListViewResponse("DAB088BA50C9405E84C789055D657614",2,"成都","android_com.aiyiqi.galaxy_1.1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CompanyListViewResponse>() {
                    @Override
                    public void onCompleted() {
                        callBack.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailed(e);
                    }

                    @Override
                    public void onNext(CompanyListViewResponse companyListViewResponse) {
                        callBack.onNext(companyListViewResponse);
                    }
                });
    }
}
