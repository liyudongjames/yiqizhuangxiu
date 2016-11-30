package com.bwf.yiqizhuang.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.CompanyViewPagerAdapter;
import com.bwf.yiqizhuang.framework.mvp.adapter.MyListViewAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.framework.mvp.databean.CompanyListViewResponse;
import com.bwf.yiqizhuang.framework.mvp.databean.CompanyViewPagerResponse;
import com.bwf.yiqizhuang.framework.mvp.presenter.CompanyListViewPresenter;
import com.bwf.yiqizhuang.framework.mvp.presenter.CompanyPagerPresnter;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.CompanyListViewPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.CompanyPagerPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.view.CompanyListView;
import com.bwf.yiqizhuang.framework.mvp.view.CompanyViewPagerView;
import com.bwf.yiqizhuang.framework.mvp.weidgt.PagerDotIndicator;
import com.bwf.yiqizhuang.ui.initview.AutoScrollFackViewPager;
import com.bwf.yiqizhuang.ui.initview.AutoScrollViewPager;
import com.bwf.yiqizhuang.ui.initview.MyPullToRefresh;
import com.bwf.yiqizhuang.ui.initview.MyScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/29.
 */

public class CompanyActivity extends BaseActivity implements CompanyViewPagerView ,CompanyListView {
    @BindView(R.id.company_activity_return_img)
    ImageView companyActivityReturnImg;
    @BindView(R.id.company_activity_scrollview)
    AutoScrollViewPager companyActivityScrollview;
    @BindView(R.id.company_activity_linearLayout_pager_indicator)
    LinearLayout companyActivityLinearLayoutPagerIndicator;
    @BindView(R.id.company_activity_newHouse_layout)
    LinearLayout companyActivityNewHouseLayout;
    @BindView(R.id.company_activity_oldHouse_layout)
    LinearLayout companyActivityOldHouseLayout;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.company_activity_look_site_layout)
    LinearLayout companyActivityLookSiteLayout;
    @BindView(R.id.company_activity_site_playing_layout)
    LinearLayout companyActivitySitePlayingLayout;
    @BindView(R.id.company_activity_yiqi_group_layout)
    LinearLayout companyActivityYiqiGroupLayout;
    @BindView(R.id.company_activity_listView)
    ListView companyActivityRecyclerView;
    @BindView(R.id.company_activity_myScrollView)
    MyScrollView companyActivityMyScrollView;
    @BindView(R.id.company_activity_myPullToRefresh)
    MyPullToRefresh companyActivityMyPullToRefresh;

    private PagerDotIndicator pagerDotIndicator;
    private CompanyViewPagerResponse response;
    private CompanyViewPagerAdapter viewPagerAdapter;
    private CompanyPagerPresnter pagerPresnter;
    private MyListViewAdapter listViewAdapter;
    private CompanyListViewPresenter listViewPresenter;

    @Override
    protected void initDatas() {
        pagerDotIndicator = new PagerDotIndicator(this,companyActivityLinearLayoutPagerIndicator,companyActivityScrollview);
        pagerPresnter = new CompanyPagerPresenterImpl();
        pagerPresnter.attachView(this);
        pagerPresnter.startViewPager();
        listViewPresenter = new CompanyListViewPresenterImpl();
        listViewPresenter.attachView(this);
        listViewPresenter.startData();
    }

    @Override
    protected void initViews() {
        companyActivityRecyclerView.setDividerHeight(0);
        companyActivityMyScrollView.setOnScrollListener(new MyScrollView.OnScrollListener() {
            @Override
            public void onScroll(int l, int t, int oldl, int oldt) {
                Log.d("scroll", "l:  " + l + "  t:  " + t + "  oldl:  " + oldl + "  oldt:  " + oldt);
                if(t > 0){
                    companyActivityMyPullToRefresh.setCanPull(false);
                }else if(t == 0){
                    companyActivityMyPullToRefresh.setCanPull(true);
                }
            }
        });
        onCLick();
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_company;
    }

    @Override
    public void beforePagerViewLoad() {

    }

    @Override
    public void showPagerView(CompanyViewPagerResponse response) {
        Log.d("CompanyActivity", "response.getData().size():" + response.getData().size());
        this.response = response;
    }

    @Override
    public void loadPagerViewComplete() {
        viewPagerAdapter = new CompanyViewPagerAdapter(this,response.getData());
        pagerDotIndicator.setDotNums(response.getData().size());
        companyActivityScrollview.setAdapter(viewPagerAdapter);
    }

    @Override
    public void loadPagerViewFailed(Throwable e) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pagerPresnter.detachView();
        listViewPresenter.detachView();
    }

    @Override
    public void onShowListView(CompanyListViewResponse response) {
        listViewAdapter = new MyListViewAdapter(this,response.getData());
    }

    @Override
    public void onCompleteListView() {
        companyActivityRecyclerView.setAdapter(listViewAdapter);
    }

    @Override
    public void onFailedListView(Throwable e) {

    }

    public void onCLick(){
        companyActivityNewHouseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompanyActivity.this,HtmlNewActivity.class);
                startActivity(intent);
            }
        });

        companyActivityOldHouseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompanyActivity.this,HtmlOldActivity.class);
                startActivity(intent);
            }
        });
    }
}
