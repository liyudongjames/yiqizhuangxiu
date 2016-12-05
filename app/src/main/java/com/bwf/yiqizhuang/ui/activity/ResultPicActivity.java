package com.bwf.yiqizhuang.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.SchoolViewPagerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.ui.fragment.ResultBeautyFragment;
import com.bwf.yiqizhuang.ui.fragment.ResultSpecialFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class ResultPicActivity extends BaseActivity {

    @BindView(R.id.result_activity_return_img)
    ImageView resultActivityReturnImg;
    @BindView(R.id.result_activity_main_tabLayout)
    TabLayout resultActivityMainTabLayout;
    @BindView(R.id.activity_result_viewPager)
    ViewPager activityResultViewPager;

    private List<Fragment> fragments;
    private List<String> titles;
    private SchoolViewPagerAdapter viewPagerAdapter;

    @Override
    protected void initDatas() {
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        ResultBeautyFragment beautyFragment = new ResultBeautyFragment();
        ResultSpecialFragment specialFragment = new ResultSpecialFragment();
        fragments.add(specialFragment);
        fragments.add(beautyFragment);

        titles.add("专题");
        titles.add("美图");
        viewPagerAdapter = new SchoolViewPagerAdapter(getSupportFragmentManager(), fragments, titles);
        activityResultViewPager.setAdapter(viewPagerAdapter);
        resultActivityMainTabLayout.setupWithViewPager(activityResultViewPager);
    }

    @Override
    protected void initViews() {
        resultActivityReturnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_result_pic;
    }

}
