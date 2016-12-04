package com.bwf.yiqizhuang.framework.mvp.model.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.SchoolTagResponseT_T;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.SchoolTagModel;
import com.bwf.yiqizhuang.framework.mvp.model.retrofit.SchoolTagAip;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * http://appapi.17house.com/StageApi.php?version=1&action=getTagsByStage&stage=1&model=android
 * 请求参数：
 * version：版本，此处为固定值1
 * action：用户行为，getTagsByStage（根据阶段获取tag列表）
 * stage：阶段，值从1到17取
 * model：android（固定值）
 */
public class SchoolTagModelImpl implements SchoolTagModel{
    private String baseUrl = "http://appapi.17house.com/StageApi.php";

    @Override
    public void getTag(final ModelBaseCallBack<String> callBack,int tag) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        SchoolTagAip aip = retrofit.create(SchoolTagAip.class);
//        aip.getTag(1, "getTagsByStage", tag, "android")
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribeOn(Schedulers.io())
//        .subscribe(new Subscriber<SchoolTagResponseT_T>() {
//            @Override
//            public void onCompleted() {
//                callBack.onComplete();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                callBack.onFailed(e);
//            }
//
//            @Override
//            public void onNext(SchoolTagResponseT_T schoolTagResponseT_t) {
//                callBack.onNext(schoolTagResponseT_t.getData().toString());
//            }
//        });

        OkHttpUtils.get()
                .url(baseUrl)
                .addParams("version",1+"")
                .addParams("action","getTagsByStage")
                .addParams("stage",tag+"")
                .addParams("model","android")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {
                        callBack.onFailed(e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        callBack.onNext(response);
                        callBack.onComplete();
                    }
                });
    }
}
