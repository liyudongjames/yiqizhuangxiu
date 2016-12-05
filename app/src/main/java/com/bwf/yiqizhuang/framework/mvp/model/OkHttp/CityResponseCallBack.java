package com.bwf.yiqizhuang.framework.mvp.model.OkHttp;

import com.alibaba.fastjson.JSONObject;
import com.bwf.yiqizhuang.framework.mvp.databean.BuildingResponse;
import com.bwf.yiqizhuang.framework.mvp.databean.CityResponse;
import com.bwf.yiqizhuang.utils.LogUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public abstract class CityResponseCallBack extends Callback<CityResponse>{

    @Override
    public CityResponse parseNetworkResponse(Response response, int id) throws Exception {
        LogUtils.log(response.body().toString());
        String json = response.body().string();
        CityResponse cityResponse = new JSONObject().parseObject(json,CityResponse.class);
        return cityResponse;
    }

}
