package com.bwf.yiqizhuang.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.ResultSpecialRecyclerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseFragment;
import com.bwf.yiqizhuang.framework.mvp.databean.ResultSpeciaResponse;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.ResultSpecialPresenterIMpl;
import com.bwf.yiqizhuang.framework.mvp.view.ResultSpecialView;
import com.bwf.yiqizhuang.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class ResultSpecialFragment extends BaseFragment implements ResultSpecialView{
    @BindView(R.id.fragment_result_special_recyclerView)
    RecyclerView fragmentResultSpecialRecyclerView;

    private ResultSpecialPresenterIMpl presenter;
    private ResultSpecialRecyclerAdapter adapter;
    private ResultSpeciaResponse response;
    private LinearLayoutManager layoutManager;
    private LayoutInflater inflater;
    private View footerView;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_result_special;
    }

    @Override
    protected void initView() {
        inflater = LayoutInflater.from(getActivity());
        footerView = inflater.inflate(R.layout.recycler_item_footer,null,false);
    }

    @Override
    protected void initData() {
        presenter = new ResultSpecialPresenterIMpl(1);
        presenter.attachView(this);
        presenter.startData();
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

    }

    @Override
    public void onShowing(ResultSpeciaResponse response) {
        LogUtils.log(response.getMessage().toString());
        this.response = response;
    }

    @Override
    public void onComplete() {
        adapter =  new ResultSpecialRecyclerAdapter(getActivity());
        adapter.addData(response.getData().getList());
        adapter.addFooterView(footerView);
        adapter.addHeadView(footerView);
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        fragmentResultSpecialRecyclerView.setLayoutManager(layoutManager);
        fragmentResultSpecialRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailed(Throwable throwable) {
        LogUtils.log(throwable.toString());
    }

    @Override
    public void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
