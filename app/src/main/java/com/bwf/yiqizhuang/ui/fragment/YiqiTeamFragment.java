package com.bwf.yiqizhuang.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.YiqiTeamRecyclerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseFragment;
import com.bwf.yiqizhuang.framework.mvp.databean.YiqiTeamResponse;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.YiqiTeamPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.view.YiqiTeamView;
import com.bwf.yiqizhuang.ui.initview.MyPullToRefresh;
import com.bwf.yiqizhuang.ui.initview.MyScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/2.
 */

public class YiqiTeamFragment extends BaseFragment implements YiqiTeamView{
    @BindView(R.id.yiqiteam_fragment_recyclerView)
    RecyclerView yiqiteamFragmentRecyclerView;
    @BindView(R.id.yiqiteam_fragment_scrollView)
    MyScrollView yiqiteamFragmentScrollView;
    @BindView(R.id.yiqiteam_fragment_refresh)
    MyPullToRefresh yiqiteamFragmentRefresh;

    private String title;
    private YiqiTeamPresenterImpl presenter;
    private YiqiTeamResponse response;
    private YiqiTeamRecyclerAdapter adapter;
    private GridLayoutManager layoutManager;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_yiqiteam;
    }

    @Override
    protected void initView() {
        title = (String) getArguments().get("title");
        yiqiteamFragmentScrollView.setOnScrollListener(new MyScrollView.OnScrollListener() {
            @Override
            public void onScroll(int l, int t, int oldl, int oldt) {
                Log.d("scroll", "l:  " + l + "  t:  " + t + "  oldl:  " + oldl + "  oldt:  " + oldt);
                if(t > 0){
                    yiqiteamFragmentRefresh.setCanPull(false);
                }else if(t == 0){
                    yiqiteamFragmentRefresh.setCanPull(true);
                }
            }
        });
        switch (title){
            case "设计师":
                break;
            case "监理":
                break;
            case "工长":
                break;
        }
    }

    @Override
    protected void initData() {
        layoutManager = new GridLayoutManager(getActivity(),2, LinearLayoutManager.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        switch (title){
            case "设计师":
                Log.d("YiqiTeamFragment", "设计师");
                presenter = new YiqiTeamPresenterImpl(1701,0);
                presenter.attachView(this);
                presenter.startData();
                break;
            case "监理":
                Log.d("YiqiTeamFragment", "监理");
                presenter = new YiqiTeamPresenterImpl(1702,0);
                presenter.attachView(this);
                presenter.startData();
                break;
            case "工长":
                Log.d("YiqiTeamFragment", "工长");
                presenter = new YiqiTeamPresenterImpl(1703,0);
                presenter.attachView(this);
                presenter.startData();
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void beforeShow() {
        Log.d("YiqiTeamFragment", "before");
    }

    @Override
    public void showYiqiTeamView(YiqiTeamResponse response) {
        this.response = response;
        Log.d("YiqiTeamFragment", "response.getBaseOutput().getCode():" + response.getBaseOutput().getCode());
    }

    @Override
    public void showYiqiTeamViewfailed(Throwable e) {
        Log.d("YiqiTeamFragment", e.toString());
    }

    @Override
    public void showYiqiTeamViewComplete() {
        Log.d("YiqiTeamFragment", "complete");
        adapter = new YiqiTeamRecyclerAdapter(getActivity());
        adapter.addData(response.getData());
        yiqiteamFragmentRecyclerView.setLayoutManager(layoutManager);
        yiqiteamFragmentRecyclerView.setAdapter(adapter);
        yiqiteamFragmentRefresh.refreshingComplete();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
