package com.bwf.yiqizhuang.framework.mvp.presenter.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.MainRecyclerViewResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.MainRecyclerViewModel;
import com.bwf.yiqizhuang.framework.mvp.model.impl.MainRecyclerViewModelImpl;
import com.bwf.yiqizhuang.framework.mvp.presenter.MainRecyclerViewPresenter;
import com.bwf.yiqizhuang.framework.mvp.presenter.MainViewPagerPresenter;
import com.bwf.yiqizhuang.framework.mvp.view.MainRecyclerView;
import com.bwf.yiqizhuang.framework.mvp.view.MainViewPagerView;

/**
 * Created by Administrator on 2016/11/28.
 */

public class MainRecyclerViewPresenterImpl implements MainRecyclerViewPresenter,ModelBaseCallBack<MainRecyclerViewResponse>{
    private MainRecyclerViewModel model;
    private MainRecyclerView<MainRecyclerViewResponse> view;
    private int id;
    private int type;
    private int page;

    public MainRecyclerViewPresenterImpl(MainRecyclerView view){
        this.view = view;
        model = new MainRecyclerViewModelImpl();
    }

    @Override
    public void getMoreData(int id,int type) {
        this.id = id;
        this.type = type;
        view.beforeRecyclerViewLoad();
        model.startMainRecyclerViewData(this,id,type,page);
        page++;
    }

    @Override
    public void onComplete() {
        view.loadRecyclerViewComplete();
    }

    @Override
    public void onNext(MainRecyclerViewResponse response) {
        view.showRecyclerView(response);
    }

    @Override
    public void onFailed(Throwable error) {
        view.loadRecyclerViewFailed(error);
        page--;
    }
}
