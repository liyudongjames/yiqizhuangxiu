package com.bwf.yiqizhuang.framework.mvp.view;

import com.bwf.yiqizhuang.framework.mvp.databean.ResultSpeciaResponse;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public interface ResultSpecialView {
    void beforeShow();
    void onShowing(ResultSpeciaResponse response);
    void onComplete();
    void onFailed(Throwable throwable);
}
