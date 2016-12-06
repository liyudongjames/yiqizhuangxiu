package com.bwf.yiqizhuang.ui.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.BeautyPopAdapter;
import com.bwf.yiqizhuang.framework.mvp.adapter.ResultBeautyRecyelerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseFragment;
import com.bwf.yiqizhuang.framework.mvp.databean.ResultBeautyResponse;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.ResultBeautyPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.view.ResultBeautyView;
import com.bwf.yiqizhuang.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.fragment_beauty_linearLayout)
    LinearLayout fragmentBeautyLinearLayout;

    private ResultBeautyPresenterImpl presenter;
    private ResultBeautyResponse response;
    private ResultBeautyRecyelerAdapter adapter;
    private GridLayoutManager layoutManager;
    private PopupWindow popupWindow;
    private BeautyPopAdapter popAdapter;
    private List<String> datas;
    private LayoutInflater inflater;
    private RecyclerView popRecycler;
    private View popView;
    private GridLayoutManager popLayoutManager;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_result_beauty;
    }

    @Override
    protected void initView() {
        inflater = LayoutInflater.from(getActivity());
        popView = inflater.inflate(R.layout.popupwindow_beauty_layout,null,false);
        popupWindow = new PopupWindow(getActivity());
        popupWindow.setContentView(popView);
        popupWindow.setFocusable(true);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//        ColorDrawable dw = new ColorDrawable(00000000);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.lucency));
        popAdapter = new BeautyPopAdapter(getActivity());
    }

    @Override
    protected void initData() {
        presenter = new ResultBeautyPresenterImpl();
        presenter.attachView(this);
        presenter.startData();
        datas = new ArrayList<>();
        datas.add("全部");
        datas.add("客厅");
        datas.add("玄关");
        datas.add("起居室");
        datas.add("厨房");
        datas.add("餐厅");
        datas.add("衣帽间");
        datas.add("庭院");
        datas.add("卫生间");
        datas.add("阳台");
        datas.add("儿童房");
        datas.add("露台");
        datas.add("卧室");
        datas.add("书房");
        datas.add("娱乐室");
        popAdapter.addData(datas);
        popLayoutManager = new GridLayoutManager(getActivity(),4,LinearLayoutManager.VERTICAL,false);
        popRecycler = (RecyclerView) popupWindow.getContentView().findViewById(R.id.popupwindow_recyclerview);
        popRecycler.setAdapter(popAdapter);
        popRecycler.setLayoutManager(popLayoutManager);
        View view = popupWindow.getContentView().findViewById(R.id.popupwindow_view);
        onClick();
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

    private void onClick(){
        fragmentBeautySpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAsDropDown(fragmentBeautyLinearLayout);
            }
        });
    }

    @Override
    public void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
