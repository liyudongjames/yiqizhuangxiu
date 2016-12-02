package com.bwf.yiqizhuang.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.SchoolTagPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.view.SchoolTagView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/2.
 */

public class SchoolActivity extends BaseActivity implements SchoolTagView{
    @BindView(R.id.company_activity_return_img)
    ImageView companyActivityReturnImg;
    @BindView(R.id.school_activity_main_tabLayout)
    TabLayout schoolActivityMainTabLayout;
    @BindView(R.id.school_activity_tab_nor)
    ImageView schoolActivityTabNor;
    @BindView(R.id.school_activity_viewpager)
    ViewPager schoolActivityViewpager;
    private SchoolTagPresenterImpl presenter;

    @Override
    protected void initDatas() {
        presenter = new SchoolTagPresenterImpl();
        presenter.attachView(this);
        presenter.startData();
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_school;
    }


    @Override
    public void beforeShow() {

    }

    @Override
    public void showTagView(String response) {
        Log.d("SchoolActivity","------------------------" + response);
    }

    @Override
    public void showTagViewfailed(Throwable e) {
        Log.d("SchoolActivity","------------------------" + e.toString());
    }

    @Override
    public void showTagViewComplete() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

}
