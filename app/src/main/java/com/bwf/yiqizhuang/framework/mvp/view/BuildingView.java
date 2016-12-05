package com.bwf.yiqizhuang.framework.mvp.view;

import com.bwf.yiqizhuang.framework.mvp.databean.BuildingResponse;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public interface BuildingView {
    void beforeShowView();
    void onShowView(BuildingResponse response);
    void onShowComplete();
    void onFailed(Throwable error);
}
