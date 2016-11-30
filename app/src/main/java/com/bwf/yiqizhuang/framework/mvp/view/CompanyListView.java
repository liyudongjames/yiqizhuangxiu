package com.bwf.yiqizhuang.framework.mvp.view;

import com.bwf.yiqizhuang.framework.mvp.databean.CompanyListViewResponse;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface CompanyListView {
    void onShowListView(CompanyListViewResponse response);
    void onCompleteListView();
    void onFailedListView(Throwable e);
}
