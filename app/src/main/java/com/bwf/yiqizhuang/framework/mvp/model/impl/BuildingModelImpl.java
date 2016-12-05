package com.bwf.yiqizhuang.framework.mvp.model.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.BuildingResponse;
import com.bwf.yiqizhuang.framework.mvp.model.BuildingModel;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.OkHttp.BuildingRespnseCallBack;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.request.OkHttpRequest;

import okhttp3.Call;

/**
 * http://bbs.17house.com/motnt/index.php?a=product&m=misc&model=android&uuid=a444d1b2af4f&app_version=android_com.aiyiqi.galaxy_1.1
 */

public class BuildingModelImpl implements BuildingModel {
    private String url = "http://bbs.17house.com/motnt/index.php";

    @Override
    public void getBuildingData(final ModelBaseCallBack<BuildingResponse> callBack) {
        OkHttpUtils.post()
                .url(url)
                .addParams("a","product")
                .addParams("m","misc")
                .addParams("model","android")
                .addParams("uuid","a444d1b2af4f")
                .addParams("app_version","android_com.aiyiqi.galaxy_1.1")
                .build()
            .execute(new BuildingRespnseCallBack() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    callBack.onFailed(e);
                }

                @Override
                public void onResponse(BuildingResponse response, int id) {
                    callBack.onNext(response);
                    callBack.onComplete();
                }
            });

    }
}
