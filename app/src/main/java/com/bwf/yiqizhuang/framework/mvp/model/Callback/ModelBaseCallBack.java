package com.bwf.yiqizhuang.framework.mvp.model.Callback;

/**
 * Created by Administrator on 2016/11/28.
 */

public interface ModelBaseCallBack<T> {
    void onComplete();
    void onNext(T t);
    void onFailed(Throwable error);
}
