package com.bwf.yiqizhuang.framework.mvp.model.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.MainRecyclerViewResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.MainRecyclerViewModel;
import com.bwf.yiqizhuang.framework.mvp.model.retrofit.MainRecyclerViewApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/11/28.
 * http://bbs.17house.com
 * /motnt/index.php?
 * a=appindex&
 * c=index&
 * id=1218226&
 * uuid=86305803367590&
 * pageSize=10&
 * uid=1633055&
 * m=misc&
 * type=3&
 * page=1&
 * haspermission=yes&
 * model=android&
 * sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&
 * app_version=android_com.aiyiqi.galaxy_1.1
 */

public class MainRecyclerViewModelImpl implements MainRecyclerViewModel{
    private String baseUrl = "http://bbs.17house.com";
    private final int PAGE_SIZE = 10;

    @Override
    public void startMainRecyclerViewData(final ModelBaseCallBack<MainRecyclerViewResponse> callBack,int id,int type,int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MainRecyclerViewApi api = retrofit.create(MainRecyclerViewApi.class);
        api.getMainData("appindex","index",id,86305803367590L,PAGE_SIZE,1633055,"misc",type,page,
                "yes","android","6U49kCYKE260RqvPqEdFsBGskNQStKhm","android_com.aiyiqi.galaxy_1.1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MainRecyclerViewResponse>() {
                    @Override
                    public void onCompleted() {
                        callBack.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailed(e);
                    }

                    @Override
                    public void onNext(MainRecyclerViewResponse response) {
                        callBack.onNext(response);
                    }
                });
    }
}
