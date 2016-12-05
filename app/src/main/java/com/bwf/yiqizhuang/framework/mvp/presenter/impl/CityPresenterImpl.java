package com.bwf.yiqizhuang.framework.mvp.presenter.impl;

import com.bwf.yiqizhuang.framework.mvp.base.BasePresenter;
import com.bwf.yiqizhuang.framework.mvp.databean.CityResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.CityModel;
import com.bwf.yiqizhuang.framework.mvp.model.impl.CityModelImpl;
import com.bwf.yiqizhuang.framework.mvp.view.CityView;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class CityPresenterImpl extends BasePresenter<CityView> {
    private CityModel model;

    public CityPresenterImpl(){
        model = new CityModelImpl();
    }

    @Override
    public void startData() {
        t.beforeShow();
        model.getCityDatas(new ModelBaseCallBack<CityResponse>() {
            @Override
            public void onComplete() {
                t.onComplete();
            }

            @Override
            public void onNext(CityResponse response) {
                t.onShowView(response);
            }

            @Override
            public void onFailed(Throwable error) {
                t.onFailed(error);
            }
        });
    }
}
