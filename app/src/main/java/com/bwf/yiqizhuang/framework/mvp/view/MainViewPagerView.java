package com.bwf.yiqizhuang.framework.mvp.view;

import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface MainViewPagerView<T> {
    void beforeLoad();
    void showView(T t);
    void loadComplete();
    void loadFailed(Throwable e);
}
