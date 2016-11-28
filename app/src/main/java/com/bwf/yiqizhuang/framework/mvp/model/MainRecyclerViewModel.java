package com.bwf.yiqizhuang.framework.mvp.model;

import com.bwf.yiqizhuang.framework.mvp.databean.MainRecyclerViewResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface MainRecyclerViewModel {
    void startMainRecyclerViewData(ModelBaseCallBack<MainRecyclerViewResponse> callBack,int id,int type,int page);


}
