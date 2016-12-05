package com.bwf.yiqizhuang.framework.mvp.view;

import com.bwf.yiqizhuang.framework.mvp.databean.ResultBeautyResponse;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public interface ResultBeautyView {
    void beforeShow();
    void onShowView(ResultBeautyResponse response);
    void onComplete();
    void onFailed(Throwable throwable);
}
