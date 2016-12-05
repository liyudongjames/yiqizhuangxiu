package com.bwf.yiqizhuang.ui.activity;

import android.content.Intent;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.framework.mvp.databean.CityResponse;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.CityPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.view.CityView;
import com.bwf.yiqizhuang.utils.LogUtils;

/**
 * Created by Administrator on 2016/12/2.
 */

public class CityActivity extends BaseActivity implements CityView{
    private CityPresenterImpl presenter;

    @Override
    protected void initDatas() {
        presenter = new CityPresenterImpl();
        presenter.attachView(this);
        presenter.startData();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_city;
    }


    @Override
    public void beforeShow() {

    }

    @Override
    public void onShowView(CityResponse response) {
        LogUtils.log(response.getMessage());
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onFailed(Throwable error) {
        LogUtils.log(error.toString());
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
