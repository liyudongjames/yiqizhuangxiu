package com.bwf.yiqizhuang.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.YiqiTeamViewPagerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.ui.fragment.YiqiTeamFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/2.
 */

public class YiqiTeamActivity extends BaseActivity {

    @BindView(R.id.company_activity_return_img)
    ImageView companyActivityReturnImg;
    @BindView(R.id.yiqiteam_tablayout)
    TabLayout yiqiteamTablayout;
    @BindView(R.id.yiqiteam_viewPager)
    ViewPager yiqiteamViewPager;
    @BindView(R.id.html_activity_yuyue)
    LinearLayout htmlActivityYuyue;
    @BindView(R.id.html_activity_dayi)
    LinearLayout htmlActivityDayi;

    private List<Fragment> fragments;
    private List<String> titles;
    private String[] title = {"设计师", "工长", "监理"};
    private YiqiTeamViewPagerAdapter adapter;

    @Override
    protected void initDatas() {
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            YiqiTeamFragment fragment = new YiqiTeamFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title",title[i]);
            fragment.setArguments(bundle);
            fragments.add(fragment);
            titles.add(title[i]);
        }
        adapter = new YiqiTeamViewPagerAdapter(this.getSupportFragmentManager(),fragments,titles);
        yiqiteamViewPager.setAdapter(adapter);
        yiqiteamTablayout.setupWithViewPager(yiqiteamViewPager);
    }

    @Override
    protected void initViews() {
        yiqiteamTablayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_yiqiteam;
    }

    public void setTabLayout(){

    }

}
