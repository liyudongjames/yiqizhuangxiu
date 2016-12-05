package com.bwf.yiqizhuang.framework.mvp.presenter.impl;

import com.bwf.yiqizhuang.framework.mvp.base.BasePresenter;
import com.bwf.yiqizhuang.framework.mvp.databean.ResultBeautyResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.ResultBeautyModel;
import com.bwf.yiqizhuang.framework.mvp.model.impl.ResultBeautyModelImpl;
import com.bwf.yiqizhuang.framework.mvp.view.ResultBeautyView;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class ResultBeautyPresenterImpl extends BasePresenter<ResultBeautyView>{
    private ResultBeautyModel model;

    public ResultBeautyPresenterImpl(){
        model = new ResultBeautyModelImpl();
    }

    @Override
    public void startData() {
        t.beforeShow();
        model.getBeauty(new ModelBaseCallBack<ResultBeautyResponse>() {
            @Override
            public void onComplete() {
                t.onComplete();
            }

            @Override
            public void onNext(ResultBeautyResponse resultBeautyResponse) {
                t.onShowView(resultBeautyResponse);
            }

            @Override
            public void onFailed(Throwable error) {
                t.onFailed(error);
            }
        });
    }
}
