package com.bwf.yiqizhuang.framework.mvp.model.OkHttp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bwf.yiqizhuang.framework.mvp.databean.BuildingResponse;
import com.bwf.yiqizhuang.utils.LogUtils;
import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public abstract class BuildingRespnseCallBack extends Callback<BuildingResponse>{
    @Override
    public BuildingResponse parseNetworkResponse(Response response, int id) throws Exception {
        LogUtils.log(response.body().toString());
        String json = response.body().string();
        BuildingResponse buildingResponse = new JSONObject().parseObject(json,BuildingResponse.class);
        return buildingResponse;
    }
}