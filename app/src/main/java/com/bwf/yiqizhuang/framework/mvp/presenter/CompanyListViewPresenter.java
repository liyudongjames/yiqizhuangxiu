package com.bwf.yiqizhuang.framework.mvp.presenter;

import com.bwf.yiqizhuang.framework.mvp.view.CompanyListView;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface CompanyListViewPresenter {
    void startData();
    void attachView(CompanyListView view);
    void detachView();
}
