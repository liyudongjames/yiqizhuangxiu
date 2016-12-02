package com.bwf.yiqizhuang.ui.fragment;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.MainRecyclerViewAdapter;
import com.bwf.yiqizhuang.framework.mvp.adapter.MainViewPagerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseFragment;
import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;
import com.bwf.yiqizhuang.framework.mvp.databean.MainRecyclerViewResponse;
import com.bwf.yiqizhuang.framework.mvp.presenter.MainRecyclerViewPresenter;
import com.bwf.yiqizhuang.framework.mvp.presenter.MainViewPagerPresenter;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.MainRecyclerViewPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.MainViewPagerPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.view.MainRecyclerView;
import com.bwf.yiqizhuang.framework.mvp.view.MainViewPagerView;
import com.bwf.yiqizhuang.framework.mvp.weidgt.FullyLinearLayoutManager;
import com.bwf.yiqizhuang.framework.mvp.weidgt.PagerDotIndicator;
import com.bwf.yiqizhuang.ui.activity.CompanyActivity;
import com.bwf.yiqizhuang.ui.activity.SchoolActivity;
import com.bwf.yiqizhuang.ui.initview.MyPullToRefresh;
import com.bwf.yiqizhuang.ui.initview.MyScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainFragment extends BaseFragment implements MainViewPagerView<FontPagePagerResponse>, MainRecyclerView<MainRecyclerViewResponse> {

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
    @BindView(R.id.fragment_main_recyclerView)
    RecyclerView fragmentMainRecyclerView;
    @BindView(R.id.fragment_main_scrollView)
    MyScrollView fragmentMainScrollView;
    @BindView(R.id.fragment_main_title_linearLayout)
    LinearLayout fragmentMainTitleLinearLayout;

    private FontPagePagerResponse response;
    private PagerDotIndicator pagerDotIndicator;
    private MainViewPagerAdapter pagerAdapter;
    private MainRecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager layoutManager;
    private MainRecyclerViewResponse recyclerResponse;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        int color = Color.argb(0,17,128,10);
        fragmentMainTitleLinearLayout.setBackgroundColor(color);
        setClick();
    }

    private boolean isAlph;
    @Override
    protected void initData() {
        final MainViewPagerPresenter presenter = new MainViewPagerPresenterImpl(this);
        presenter.getData();
        final MainRecyclerViewPresenter presenter1 = new MainRecyclerViewPresenterImpl(this);
        presenter1.getMoreData(1218226, 3);
        recyclerViewAdapter = new MainRecyclerViewAdapter(getActivity());
        layoutManager = new FullyLinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        fragmentMainRecyclerView.setLayoutManager(layoutManager);
        fragmentMainRecyclerView.setHasFixedSize(true);
        fragmentMainRecyclerView.setNestedScrollingEnabled(false);
        fragmentMainPullRefresh.setOnRefreshListener(new MyPullToRefresh.PullToRefreshListener() {
            @Override
            public void onRefreshing() {

//                fragmentMainPullRefresh.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        fragmentMainPullRefresh.refreshingComplete();
//                    }
//                },2000);

                presenter.getData();
                presenter1.getMoreData(1218226, 3);
            }
        });
//
        fragmentMainScrollView.setOnScrollListener(new MyScrollView.OnScrollListener() {
            @Override
            public void onScroll(int l, int t, int oldl, int oldt) {
                Log.d("scroll", "l:  " + l + "  t:  " + t + "  oldl:  " + oldl + "  oldt:  " + oldt);
                if(t > 0){
                    fragmentMainPullRefresh.setCanPull(false);
                    if(!isAlph) {
                        smoothToAlph(0, 255);
                        isAlph = true;
                    }
                }else if(t == 0){
                    fragmentMainPullRefresh.setCanPull(true);
                    int color = Color.argb(0,17,128,10);
                    fragmentMainTitleLinearLayout.setBackgroundColor(color);
                    isAlph = false;
                }
            }
        });
    }

    private void smoothToAlph(int before,int after){
        ValueAnimator alphAnimator = ValueAnimator
                .ofInt(before,after)
                .setDuration(500);
        alphAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                int color = Color.argb(value,17,128,10);
                fragmentMainTitleLinearLayout.setBackgroundColor(color);
            }
        });
        alphAnimator.start();
    }

    @Override
    public void beforeLoad() {
        fragmentMainPullRefresh.setCanPull(false);
    }

    @Override
    public void showView(FontPagePagerResponse response) {
        this.response = response;

    }

    @Override
    public void loadComplete() {
        fragmentMainProgressbar.setVisibility(View.GONE);
        fragmentMainPullRefresh.setCanPull(true);
        fragmentMainViewpager.removeAllViews();
        pagerAdapter = new MainViewPagerAdapter(getActivity(), response.getData());
        fragmentMainViewpager.setAdapter(pagerAdapter);
        fragmentMainLinearLayoutPagerIndicator.removeAllViews();
        pagerDotIndicator = new PagerDotIndicator(getActivity(), fragmentMainLinearLayoutPagerIndicator, fragmentMainViewpager);
        pagerDotIndicator.setDotNums(response.getData().size());
    }

    @Override
    public void loadFailed(Throwable e) {
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
        recyclerResponse = response;
    }

    @Override
    public void loadRecyclerViewComplete() {
        recyclerViewAdapter.deleteAllData();
        recyclerViewAdapter.addData(recyclerResponse.getData());
        fragmentMainRecyclerView.setAdapter(recyclerViewAdapter);
        fragmentMainPullRefresh.refreshingComplete();
    }

    @Override
    public void loadRecyclerViewFailed(Throwable e) {
        fragmentMainPullRefresh.refreshingComplete();
    }

    private void setClick(){
        fragmentMainFeaturePackageNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(), CompanyActivity.class);
                getActivity().startActivity(intent);
            }
        });

        fragmentMainFeatureSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(), SchoolActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }
}
