package com.bwf.yiqizhuang.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.CityRecyclerViewAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.framework.mvp.databean.CityResponse;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.CityPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.view.CityView;
import com.bwf.yiqizhuang.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/2.
 */

public class CityActivity extends BaseActivity implements CityView {
    @BindView(R.id.city_activity_return)
    ImageView cityActivityReturn;
    @BindView(R.id.city_activity_recyclerView)
    RecyclerView cityActivityRecyclerView;
    private CityPresenterImpl presenter;
    private CityRecyclerViewAdapter adapter;
    private CityResponse response;
    private LinearLayoutManager layoutManager;

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
        this.response = response;
    }

    @Override
    public void onComplete() {
        adapter = new CityRecyclerViewAdapter(this);
        adapter.addData(response.getData().getForumlist());
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        cityActivityRecyclerView.setAdapter(adapter);
        cityActivityRecyclerView.setLayoutManager(layoutManager);
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
