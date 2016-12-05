package com.bwf.yiqizhuang.framework.mvp.view;

import com.bwf.yiqizhuang.framework.mvp.databean.CityResponse;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public interface CityView {
    void beforeShow();
    void onShowView(CityResponse response);
    void onComplete();
    void onFailed(Throwable error);
}
