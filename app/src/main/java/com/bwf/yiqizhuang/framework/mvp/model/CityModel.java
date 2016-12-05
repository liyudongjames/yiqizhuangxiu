package com.bwf.yiqizhuang.framework.mvp.model;


import com.bwf.yiqizhuang.framework.mvp.databean.CityResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public interface CityModel {
    void getCityDatas(ModelBaseCallBack<CityResponse> callBack);
}
