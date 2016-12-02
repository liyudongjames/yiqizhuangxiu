package com.bwf.yiqizhuang.framework.mvp.view;

import com.bwf.yiqizhuang.framework.mvp.databean.SiteLiveStateResponse;

/**
 * Created by Administrator on 2016/12/2.
 */

public interface SchoolTagView {
    void beforeShow();
    void showTagView(String response);
    void showTagViewfailed(Throwable e);
    void showTagViewComplete();
}
