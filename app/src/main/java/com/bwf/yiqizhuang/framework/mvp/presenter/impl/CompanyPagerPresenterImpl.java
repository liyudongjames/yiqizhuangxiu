package com.bwf.yiqizhuang.framework.mvp.presenter.impl;

import android.util.Log;

import com.bwf.yiqizhuang.framework.mvp.databean.CompanyViewPagerResponse;
import com.bwf.yiqizhuang.framework.mvp.model.Callback.ModelBaseCallBack;
import com.bwf.yiqizhuang.framework.mvp.model.CompanyPagerModel;
import com.bwf.yiqizhuang.framework.mvp.model.impl.CompanyPagerModelImpl;
import com.bwf.yiqizhuang.framework.mvp.presenter.CompanyPagerPresnter;
import com.bwf.yiqizhuang.framework.mvp.view.CompanyViewPagerView;

/**
 * Created by Administrator on 2016/11/30.
 */

public class CompanyPagerPresenterImpl implements CompanyPagerPresnter{

    private CompanyPagerModel model;
    private CompanyViewPagerView view;

    public CompanyPagerPresenterImpl(){
        model = new CompanyPagerModelImpl();
    }

    @Override
    public void startViewPager() {
        if(this.view != null){
            view.beforePagerViewLoad();
            model.startGetPager(new ModelBaseCallBack<CompanyViewPagerResponse>() {
                @Override
                public void onComplete() {
                    view.loadPagerViewComplete();
                }

                @Override
                public void onNext(CompanyViewPagerResponse companyViewPagerResponse) {
                    Log.d("CompanyPagerPresenterIm", "companyViewPagerResponse.getData().size():" + companyViewPagerResponse.getData().size());
                    view.showPagerView(companyViewPagerResponse);
                }

                @Override
                public void onFailed(Throwable error) {
                    view.loadPagerViewFailed(error);
                }
            });
        }
    }

    public void attachView(CompanyViewPagerView view){
        this.view = view;
    }

    public void detachView(){
        this.view = null;
    }
}
