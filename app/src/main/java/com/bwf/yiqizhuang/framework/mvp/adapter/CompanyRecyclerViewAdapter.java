package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseRecyclerViewAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseViewHolder;
import com.bwf.yiqizhuang.framework.mvp.databean.CompanyListViewResponse;

/**
 * Created by Administrator on 2016/12/1.
 */

public class CompanyRecyclerViewAdapter extends BaseRecyclerViewAdapter<CompanyListViewResponse.DataBean>{
    public CompanyRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder myCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.company_listview_item,null,false);
        BaseViewHolder holder = new BaseViewHolder(view);
        return holder;
    }

    @Override
    protected void myBindViewHolder(BaseViewHolder holder, int position) {
        holder.setText(R.id.company_listView_item_area,datas.get(position).getOrderHouse().getCommunity());
        holder.setText(R.id.company_listView_item_house_style,datas.get(position).getOrderHouse().getLayout());
        holder.setFrescoUrl(R.id.company_listView_item_img,datas.get(position).getImageUrl());
    }

    @Override
    public int getMyItemViewType(int position) {
        return 0;
    }
}
