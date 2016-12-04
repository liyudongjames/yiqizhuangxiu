package com.bwf.yiqizhuang.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.SchoolViewPagerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.SchoolTagPresenterImpl;
import com.bwf.yiqizhuang.framework.mvp.view.SchoolTagView;
import com.bwf.yiqizhuang.ui.fragment.SchoolFragment;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/2.
 */

public class SchoolActivity extends BaseActivity {
    @BindView(R.id.company_activity_return_img)
    ImageView companyActivityReturnImg;
    @BindView(R.id.school_activity_main_tabLayout)
    TabLayout schoolActivityMainTabLayout;
    @BindView(R.id.school_activity_tab_nor)
    ImageView schoolActivityTabNor;
    @BindView(R.id.school_activity_viewpager)
    ViewPager schoolActivityViewpager;

    private List<Fragment> fragments;
    private SchoolViewPagerAdapter adapter;
    private String[] tags = {"验房收房","装修公司","量房设计","辅材选购","主材选购","家具选购","装修合同","主题拆迁","水电改造","防水处理","木工工程","瓦工工程","油工工程","主材安装","竣工验收","软装配饰","居家生活"};
    private List<String> titles;
    @Override
    protected void initDatas() {
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        for (int i = 0; i < tags.length; i++) {
            titles.add(tags[i]);
        }

        int i = 1;
        for(int j = 0 ; j < titles.size();j++){
            SchoolFragment fragment = new SchoolFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("tag",i++);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }

        adapter = new SchoolViewPagerAdapter(getSupportFragmentManager(),fragments,titles);
        schoolActivityViewpager.setAdapter(adapter);
        schoolActivityMainTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE );
        schoolActivityMainTabLayout.setupWithViewPager(schoolActivityViewpager);


    }

    @Override
    protected void initViews() {
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_school;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
