package com.bwf.yiqizhuang.framework.mvp.presenter.impl;

import com.bwf.yiqizhuang.framework.mvp.base.BasePresenter;
import com.bwf.yiqizhuang.framework.mvp.databean.ResultSpeciaResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.ResultSpecialModel;
import com.bwf.yiqizhuang.framework.mvp.model.impl.ResultSpecialModelImpl;
import com.bwf.yiqizhuang.framework.mvp.view.ResultSpecialView;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class ResultSpecialPresenterIMpl extends BasePresenter<ResultSpecialView> implements ModelBaseCallBack<ResultSpeciaResponse>{

    private ResultSpecialModel model;
    private int page;

    public ResultSpecialPresenterIMpl(int page){
        model = new ResultSpecialModelImpl();
        this.page = page;
    }

    @Override
    public void startData() {
        t.beforeShow();
        model.getSpecial(page,this);
    }

    @Override
    public void onComplete() {
        t.onComplete();
    }

    @Override
    public void onNext(ResultSpeciaResponse resultSpeciaResponse) {
        t.onShowing(resultSpeciaResponse);
    }

    @Override
    public void onFailed(Throwable error) {
        t.onFailed(error);
    }
}
