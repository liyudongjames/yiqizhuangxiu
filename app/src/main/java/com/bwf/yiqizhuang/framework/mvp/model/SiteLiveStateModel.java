package com.bwf.yiqizhuang.framework.mvp.model;

import com.bwf.yiqizhuang.framework.mvp.databean.SiteLiveStateResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;

/**
 * Created by Administrator on 2016/12/1.
 */

public interface SiteLiveStateModel {
    void getStateLiveStateResponse(ModelBaseCallBack<SiteLiveStateResponse> callBack,int id);
}
