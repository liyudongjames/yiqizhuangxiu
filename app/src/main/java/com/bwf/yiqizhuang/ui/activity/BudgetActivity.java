package com.bwf.yiqizhuang.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.SchoolViewPagerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.ui.fragment.BudgetMyFragment;
import com.bwf.yiqizhuang.ui.fragment.BudgetOfferFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liyudongjames on 2016/12/6.
 */

public class BudgetActivity extends BaseActivity {


    @BindView(R.id.budget_activity_return_img)
    ImageView budgetActivityReturnImg;
    @BindView(R.id.budget_activity_main_tabLayout)
    TabLayout budgetActivityMainTabLayout;
    @BindView(R.id.budget_activity_viewPager)
    ViewPager budgetActivityViewPager;

    private List<Fragment> fragments;
    private List<String> titles;
    private SchoolViewPagerAdapter adapter;

    @Override
    protected void initDatas() {
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        BudgetMyFragment myFragment = new BudgetMyFragment();
        BudgetOfferFragment offerFragment = new BudgetOfferFragment();
        fragments.add(offerFragment);
        fragments.add(myFragment);

        titles.add("装修报价");
        titles.add("我的预算");
        adapter = new SchoolViewPagerAdapter(getSupportFragmentManager(),fragments,titles);
        budgetActivityViewPager.setAdapter(adapter);
        budgetActivityMainTabLayout.setupWithViewPager(budgetActivityViewPager);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_budget;
    }


}
