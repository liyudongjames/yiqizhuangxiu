package com.bwf.yiqizhuang.framework.mvp.model.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.SiteLiveStateResponse;
import com.bwf.yiqizhuang.framework.mvp.databean.YiqiTeamResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.YiqiTeamModel;
import com.bwf.yiqizhuang.framework.mvp.model.retrofit.YiqiTeamApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteVendors
 *
 * token: DAB088BA50C9405E84C789055D657614
 * app_version : android_com.aiyiqi.galaxy_1.1（固定参数）
 * type: 1701（设计师），1702（监理），1703（工长）
 * haspermission: yes
 * pageNo : 页数，默认0
 * pageSize： 一页的数据条数，默认10
 *
 *
 */

public class YiqiModelImpl implements YiqiTeamModel{

    private String baseUrl = "http://hui.17house.com/";

    @Override
    public void getYiqiTeam(final ModelBaseCallBack<YiqiTeamResponse> callBack, int type, int pageNo) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        YiqiTeamApi api = retrofit.create(YiqiTeamApi.class);
        api.getYiqiTeam("DAB088BA50C9405E84C789055D657614",
                "android_com.aiyiqi.galaxy_1.1",
                type,"yes",pageNo,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<YiqiTeamResponse>() {
                    @Override
                    public void onCompleted() {
                        callBack.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailed(e);
                    }

                    @Override
                    public void onNext(YiqiTeamResponse response) {
                        callBack.onNext(response);
                    }
                });

    }
}
