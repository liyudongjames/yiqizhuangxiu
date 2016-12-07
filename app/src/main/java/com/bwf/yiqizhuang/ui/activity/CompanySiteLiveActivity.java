package com.bwf.yiqizhuang.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.adapter.SiteLiveStateRecyclerAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.framework.mvp.databean.SiteLiveStateResponse;
import com.bwf.yiqizhuang.framework.mvp.presenter.impl.SiteLivePresenter;
import com.bwf.yiqizhuang.framework.mvp.view.SiteLiveStateView;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/1.
 */

public class CompanySiteLiveActivity extends BaseActivity implements SiteLiveStateView {
    @BindView(R.id.company_activity_return_img)
    ImageView companyActivityReturnImg;
    @BindView(R.id.company_site_live_activity_img)
    SimpleDraweeView companySiteLiveActivityImg;
    @BindView(R.id.company_site_live_activity_area)
    TextView companySiteLiveActivityArea;
    @BindView(R.id.company_site_live_activity_house_style)
    TextView companySiteLiveActivityHouseStyle;
    @BindView(R.id.company_site_live_activity_member_layout)
    LinearLayout companySiteLiveActivityMemberLayout;
    @BindView(R.id.company_site_live_activity_detail_layout)
    LinearLayout companySiteLiveActivityDetailLayout;
    @BindView(R.id.html_activity_yuyue)
    LinearLayout htmlActivityYuyue;
    @BindView(R.id.html_activity_dayi)
    LinearLayout htmlActivityDayi;
    @BindView(R.id.company_activity_look_site_recyclerView)
    RecyclerView companyActivityLookSiteRecyclerView;

    private SiteLiveStateResponse response;
    private SiteLivePresenter presenter;
    private SiteLiveStateRecyclerAdapter adapter;
    private LayoutInflater inflater;
    private String[] jobs = {"设计师", "监理", "工长", "材料顾问"};
    private LinearLayoutManager layoutManager;

    @Override
    protected void initDatas() {
        presenter = new SiteLivePresenter(0);
        presenter.attachView(this);
        presenter.startData();
        inflater = LayoutInflater.from(this);
        adapter = new SiteLiveStateRecyclerAdapter(this);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_company_site_live;
    }

    @Override
    public void beforeShow() {

    }

    @Override
    public void showStateView(SiteLiveStateResponse response) {
        this.response = response;
    }

    @Override
    public void showStateViewfailed(Throwable e) {

    }

    @Override
    public void showStateViewComplete() {
        companySiteLiveActivityArea.setText(response.getData().getOrderHouse().getCommunity());
        companySiteLiveActivityHouseStyle.setText(response.getData().getOrderHouse().getLayout());
        companySiteLiveActivityImg.setImageURI(response.getData().getImageUrl());
        for (int i = 0; i < jobs.length; i++) {
            View view = inflater.inflate(R.layout.site_live_activity_member_item, null);
            TextView name = (TextView) view.findViewById(R.id.site_live_member_item_name_tx);
            name.setText(response.getData().getMembers().get(i).getRealName());
            TextView job = (TextView) view.findViewById(R.id.site_live_member_item_job_tx);
            job.setText(jobs[i]+"");
            SimpleDraweeView img = (SimpleDraweeView) view.findViewById(R.id.site_live_member_item_header_img);
            if (response.getData().getMembers().get(i).getAvatar() != null) {
                img.setImageURI(response.getData().getMembers().get(i).getAvatar());
            } else {
            }
            view.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            companySiteLiveActivityMemberLayout.addView(view);
        }
        adapter.addData(response.getData().getProgress());
        companyActivityLookSiteRecyclerView.setLayoutManager(layoutManager);
        companyActivityLookSiteRecyclerView.setAdapter(adapter);
    }

}
