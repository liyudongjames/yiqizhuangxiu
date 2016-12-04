package com.bwf.yiqizhuang.framework.mvp.presenter.impl;

import com.bwf.yiqizhuang.framework.mvp.base.BasePresenter;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.SchoolTagModel;
import com.bwf.yiqizhuang.framework.mvp.model.impl.SchoolTagModelImpl;
import com.bwf.yiqizhuang.framework.mvp.view.SchoolTagView;

/**
 * Created by Administrator on 2016/12/2.
 */

public class SchoolTagPresenterImpl extends BasePresenter<SchoolTagView> implements ModelBaseCallBack<String>{

    private SchoolTagModel model;
    private int tag;

    public SchoolTagPresenterImpl(){
        model = new SchoolTagModelImpl();
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    @Override
    public void startData() {
        t.beforeShow();
        model.getTag(this,tag);
    }

    @Override
    public void onComplete() {
        t.showTagViewComplete();
    }

    @Override
    public void onNext(String s) {
        t.showTagView(s);
    }

    @Override
    public void onFailed(Throwable error) {
        t.showTagViewfailed(error);
    }
}
