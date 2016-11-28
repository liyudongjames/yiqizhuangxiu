package com.bwf.yiqizhuang.framework.mvp.presenter.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.MainViewPagerModel;
import com.bwf.yiqizhuang.framework.mvp.model.impl.MainViewPagerModelImpl;
import com.bwf.yiqizhuang.framework.mvp.presenter.MainViewPagerPresenter;
import com.bwf.yiqizhuang.framework.mvp.view.MainViewPagerView;

/**
 * Created by Administrator on 2016/11/28.
 */

public class MainViewPagerPresenterImpl implements MainViewPagerPresenter,ModelBaseCallBack<FontPagePagerResponse>{

    private MainViewPagerModel model;
    private MainViewPagerView<FontPagePagerResponse> view;

    public MainViewPagerPresenterImpl(MainViewPagerView view){
        this.view = view;
        model = new MainViewPagerModelImpl();
    }

    @Override
    public void getData() {
        view.beforeLoad();
        model.startViewPager(this);
    }

    @Override
    public void onComplete() {
        view.loadComplete();
    }

    @Override
    public void onNext(FontPagePagerResponse response) {
        view.showView(response);
    }

    @Override
    public void onFailed(Throwable error) {
        view.loadFailed(error);
    }
}
