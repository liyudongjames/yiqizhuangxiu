package com.bwf.yiqizhuang.framework.mvp.view;

import com.bwf.yiqizhuang.framework.mvp.databean.SiteLiveStateResponse;

/**
 * Created by Administrator on 2016/12/1.
 */

public interface SiteLiveStateView {
    void beforeShow();
    void showStateView(SiteLiveStateResponse response);
    void showStateViewfailed(Throwable e);
    void showStateViewComplete();
}
