package com.bwf.yiqizhuang.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bwf.yiqizhuang.BuildConfig;
import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.SchoolViewPagerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseFragment;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.SchoolTagPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.view.SchoolTagView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liyudongjames on 2016/12/4.
 */

public class SchoolFragment extends BaseFragment implements SchoolTagView {


    @BindView(R.id.fragment_school_tabLayout)
    TabLayout fragmentSchoolTabLayout;
    @BindView(R.id.fragment_school_viewPager)
    ViewPager fragmentSchoolViewPager;
    private int tag;
    private SchoolTagPresenterImpl presenter;
    private String response;
    private List<String> fragmentTags;
    private SchoolViewPagerAdapter adapter;
    private List<Fragment> fragments;
    private LayoutInflater inflater;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_school;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        tag = bundle.getInt("tag");
        Log.d("SchoolFragment", "tag:" + tag);
        fragmentTags = new ArrayList<>();
        fragments = new ArrayList<>();
    }

    @Override
    protected void initData() {
        presenter = new SchoolTagPresenterImpl();
        presenter.attachView(this);
        presenter.setTag(tag);
        presenter.startData();
        inflater = LayoutInflater.from(getActivity());
    }

    @Override
    public void beforeShow() {

    }

    @Override
    public void showTagView(String response) {
        this.response = response;
    }

    @Override
    public void showTagViewfailed(Throwable e) {
        if (BuildConfig.DEBUG) Log.d("SchoolFragment", "e:" + e.toString());
    }

    @Override
    public void showTagViewComplete() {
        JSONObject obj = JSON.parseObject(response).getJSONObject("data");
        Iterator iterator = obj.keySet().iterator();

        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Log.d("SchoolFragment", key);
            fragmentTags.add(obj.get(key).toString());
        }

        Log.d("SchoolFragment", fragmentTags.toString());
        for (int i = 0; i < fragmentTags.size(); i++) {
            SchoolDetailFragment fragment = new SchoolDetailFragment();
            fragments.add(fragment);
        }
        adapter = new SchoolViewPagerAdapter(getChildFragmentManager(), fragments, fragmentTags);
        fragmentSchoolViewPager.setAdapter(adapter);
        fragmentSchoolTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE );
        for (int i = 0; i < fragmentTags.size(); i++) {
            TextView view = (TextView) inflater.inflate(R.layout.school_tag_item,null);
            view.setText(fragmentTags.get(i));
            TabLayout.Tab tab = fragmentSchoolTabLayout.newTab().setCustomView(view);
            fragmentSchoolTabLayout.addTab(tab);
        }

//        fragmentSchoolTabLayout.setupWithViewPager(fragmentSchoolViewPager);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
