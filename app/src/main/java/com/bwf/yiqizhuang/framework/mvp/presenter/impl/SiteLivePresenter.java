package com.bwf.yiqizhuang.framework.mvp.presenter.impl;

import com.bwf.yiqizhuang.framework.mvp.base.BasePresenter;
import com.bwf.yiqizhuang.framework.mvp.databean.SiteLiveStateResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.SiteLiveStateModel;
import com.bwf.yiqizhuang.framework.mvp.model.impl.SiteLiveStateModelImpl;
import com.bwf.yiqizhuang.framework.mvp.view.SiteLiveStateView;

/**
 * Created by Administrator on 2016/12/1.
 */

public class SiteLivePresenter extends BasePresenter<SiteLiveStateView> implements ModelBaseCallBack<SiteLiveStateResponse>{

    private SiteLiveStateModel model;
    private int id;

    public SiteLivePresenter(int id){
        model = new SiteLiveStateModelImpl();
        this.id = id;
    }

    @Override
    public void startData() {
        if(t!=null) {
            t.beforeShow();
            model.getStateLiveStateResponse(this, id);
        }
    }

    @Override
    public void onComplete() {
        t.showStateViewComplete();
    }

    @Override
    public void onNext(SiteLiveStateResponse response) {
        t.showStateView(response);
    }

    @Override
    public void onFailed(Throwable error) {
        t.showStateViewfailed(error);
    }
}
