package com.bwf.yiqizhuang.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bwf.yiqizhuang.BuildConfig;
import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.MainViewPagerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseFragment;
import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;
import com.bwf.yiqizhuang.framework.mvp.databean.MainRecyclerViewResponse;
import com.bwf.yiqizhuang.framework.mvp.presenter.MainViewPagerPresenter;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.MainViewPagerPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.view.MainRecyclerView;
import com.bwf.yiqizhuang.framework.mvp.view.MainViewPagerView;
import com.bwf.yiqizhuang.framework.mvp.weidgt.PagerDotIndicator;
import com.bwf.yiqizhuang.ui.initview.AutoScrollViewPager;
import com.bwf.yiqizhuang.ui.initview.MyPullToRefresh;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainFragment extends BaseFragment implements MainViewPagerView<FontPagePagerResponse>,MainRecyclerView<MainRecyclerViewResponse> {

    @BindView(R.id.fragment_main_progressbar)
    ProgressBar fragmentMainProgressbar;
    @BindView(R.id.fragment_main_title_scan)
    ImageView fragmentMainTitleScan;
    @BindView(R.id.fragment_main_title_search)
    LinearLayout fragmentMainTitleSearch;
    @BindView(R.id.fragment_main_title_location)
    LinearLayout fragmentMainTitleLocation;
    @BindView(R.id.fragment_main_viewpager)
    ViewPager fragmentMainViewpager;
    @BindView(R.id.fragment_main_LinearLayout_pager_indicator)
    LinearLayout fragmentMainLinearLayoutPagerIndicator;
    @BindView(R.id.fragment_main_feature_package_new)
    LinearLayout fragmentMainFeaturePackageNew;
    @BindView(R.id.fragment_main_feature_activity)
    LinearLayout fragmentMainFeatureActivity;
    @BindView(R.id.fragment_main_feature_school)
    LinearLayout fragmentMainFeatureSchool;
    @BindView(R.id.fragment_main_feature_my_budget)
    LinearLayout fragmentMainFeatureMyBudget;
    @BindView(R.id.fragment_main_feature_category)
    LinearLayout fragmentMainFeatureCategory;
    @BindView(R.id.fragment_main_feature_renderings_new)
    LinearLayout fragmentMainFeatureRenderingsNew;
    @BindView(R.id.fragment_main_feature_self_order)
    LinearLayout fragmentMainFeatureSelfOrder;
    @BindView(R.id.fragment_main_feature_design_measure)
    LinearLayout fragmentMainFeatureDesignMeasure;
    @BindView(R.id.fragment_main_pullrefresh)
    MyPullToRefresh fragmentMainPullRefresh;

    private FontPagePagerResponse response;
    private PagerDotIndicator pagerDotIndicator;
    private MainViewPagerAdapter pagerAdapter;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        MainViewPagerPresenter presenter = new MainViewPagerPresenterImpl(this);
        presenter.getData();
    }

    @Override
    public void beforeLoad() {
        fragmentMainPullRefresh.setCanPull(false);
        Toast.makeText(getActivity(), "开始加载数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showView(FontPagePagerResponse response) {
        this.response = response;
        Log.d("MainFragment", response.toString());
    }

    @Override
    public void loadComplete() {
        fragmentMainProgressbar.setVisibility(View.GONE);
        fragmentMainPullRefresh.setCanPull(true);
        Log.d("MainFragment", "加载完成");
        pagerAdapter = new MainViewPagerAdapter(getActivity(),response.getData());
        Log.d("MainFragment", "response.getData():" + response.getData().size());
        fragmentMainViewpager.setAdapter(pagerAdapter);
        pagerDotIndicator = new PagerDotIndicator(getActivity(),fragmentMainLinearLayoutPagerIndicator,fragmentMainViewpager);
        pagerDotIndicator.setDotNums(response.getData().size());
    }

    @Override
    public void loadFailed(Throwable e) {
        Log.d("MainFragment", e.toString());
        fragmentMainProgressbar.setVisibility(View.GONE);
        fragmentMainPullRefresh.setCanPull(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void beforeRecyclerViewLoad() {

    }

    @Override
    public void showRecyclerView(MainRecyclerViewResponse response) {

    }

    @Override
    public void loadRecyclerViewComplete() {

    }

    @Override
    public void loadRecyclerViewFailed(Throwable e) {

    }
}
