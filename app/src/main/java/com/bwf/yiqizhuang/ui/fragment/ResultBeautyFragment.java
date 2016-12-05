package com.bwf.yiqizhuang.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.ResultBeautyRecyelerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseFragment;
import com.bwf.yiqizhuang.framework.mvp.databean.ResultBeautyResponse;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.ResultBeautyPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.view.ResultBeautyView;
import com.bwf.yiqizhuang.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class ResultBeautyFragment extends BaseFragment implements ResultBeautyView {
    @BindView(R.id.fragment_beauty_space)
    LinearLayout fragmentBeautySpace;
    @BindView(R.id.fragment_beauty_style)
    LinearLayout fragmentBeautyStyle;
    @BindView(R.id.fragment_beauty_part)
    LinearLayout fragmentBeautyPart;
    @BindView(R.id.fragment_beauty_color)
    LinearLayout fragmentBeautyColor;
    @BindView(R.id.fragment_beauty_recyclerView)
    RecyclerView fragmentBeautyRecyclerView;

    private ResultBeautyPresenterImpl presenter;
    private ResultBeautyResponse response;
    private ResultBeautyRecyelerAdapter adapter;
    private GridLayoutManager layoutManager;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_result_beauty;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter = new ResultBeautyPresenterImpl();
        presenter.attachView(this);
        presenter.startData();
    }

    @Override
    public void beforeShow() {

    }

    @Override
    public void onShowView(ResultBeautyResponse response) {
        LogUtils.log(response.getMessage());
        this.response = response;
    }

    @Override
    public void onComplete() {
        adapter = new ResultBeautyRecyelerAdapter(getActivity());
        adapter.addData(response.getData().getList());
        layoutManager = new GridLayoutManager(getActivity(),2, LinearLayoutManager.VERTICAL,false);
        fragmentBeautyRecyclerView.setAdapter(adapter);
        fragmentBeautyRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onFailed(Throwable throwable) {
        LogUtils.log(throwable.getMessage());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
