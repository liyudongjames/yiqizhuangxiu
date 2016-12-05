package com.bwf.yiqizhuang.framework.mvp.presenter.impl;

import com.bwf.yiqizhuang.framework.mvp.base.BasePresenter;
import com.bwf.yiqizhuang.framework.mvp.databean.BuildingResponse;
import com.bwf.yiqizhuang.framework.mvp.model.BuildingModel;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.impl.BuildingModelImpl;
import com.bwf.yiqizhuang.framework.mvp.view.BuildingView;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class BuildingPresetnerImpl extends BasePresenter<BuildingView> implements ModelBaseCallBack<BuildingResponse>{

    private BuildingModel model;

    public BuildingPresetnerImpl(){
        model = new BuildingModelImpl();
    }

    @Override
    public void startData() {
        t.beforeShowView();
        model.getBuildingData(this);
    }

    @Override
    public void onComplete() {
        t.onShowComplete();
    }

    @Override
    public void onNext(BuildingResponse response) {
        t.onShowView(response);
    }

    @Override
    public void onFailed(Throwable error) {
        t.onFailed(error);
    }
}
