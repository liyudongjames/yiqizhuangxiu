package com.bwf.yiqizhuang.framework.mvp.view;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface MainRecyclerView<T> {
    void beforeRecyclerViewLoad();
    void showRecyclerView(T t);
    void loadRecyclerViewComplete();
    void loadRecyclerViewFailed(Throwable e);
}
