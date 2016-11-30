package com.bwf.yiqizhuang.framework.mvp.presenter.impl;

import com.bwf.yiqizhuang.framework.mvp.databean.CompanyListViewResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.CompanyListViewModel;
import com.bwf.yiqizhuang.framework.mvp.model.impl.CompanyListViewModelImpl;
import com.bwf.yiqizhuang.framework.mvp.presenter.CompanyListViewPresenter;
import com.bwf.yiqizhuang.framework.mvp.view.CompanyListView;

/**
 * Created by Administrator on 2016/11/30.
 */

public class CompanyListViewPresenterImpl implements CompanyListViewPresenter {
    private CompanyListView view;
    private CompanyListViewModel model;

    public CompanyListViewPresenterImpl(){
        model = new CompanyListViewModelImpl();
    }

    @Override
    public void startData() {
        if(view != null){
            model.startGetCompanyListViewData(new ModelBaseCallBack<CompanyListViewResponse>() {
                @Override
                public void onComplete() {
                    view.onCompleteListView();
                }

                @Override
                public void onNext(CompanyListViewResponse response) {
                    view.onShowListView(response);
                }

                @Override
                public void onFailed(Throwable error) {
                    view.onFailedListView(error);
                }
            });
        }
    }

    @Override
    public void attachView(CompanyListView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
