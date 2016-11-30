package com.bwf.yiqizhuang.framework.mvp.presenter;

import com.bwf.yiqizhuang.framework.mvp.view.CompanyViewPagerView;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface CompanyPagerPresnter {
    void startViewPager();
    void attachView(CompanyViewPagerView view);
    void detachView();
}
