package com.bwf.yiqizhuang.framework.mvp.view;

import com.bwf.yiqizhuang.framework.mvp.databean.CompanyViewPagerResponse;

/**
 * Created by Administrator on 2016/11/29.
 */

public interface CompanyViewPagerView {
    void beforePagerViewLoad();
    void showPagerView(CompanyViewPagerResponse response);
    void loadPagerViewComplete();
    void loadPagerViewFailed(Throwable e);
}
