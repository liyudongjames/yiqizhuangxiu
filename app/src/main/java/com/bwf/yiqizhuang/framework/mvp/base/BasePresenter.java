package com.bwf.yiqizhuang.framework.mvp.base;

/**
 * Created by Administrator on 2016/12/1.
 */

public abstract class BasePresenter<T> {
    protected T t;

    public abstract void startData();

    public void attachView(T t){
        this.t = t;
    }

    public void detachView(){
        t = null;
    }
}
