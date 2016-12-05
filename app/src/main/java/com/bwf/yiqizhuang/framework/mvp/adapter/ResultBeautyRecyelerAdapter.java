package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseRecyclerViewAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseViewHolder;
import com.bwf.yiqizhuang.framework.mvp.databean.ResultBeautyResponse;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class ResultBeautyRecyelerAdapter extends BaseRecyclerViewAdapter<ResultBeautyResponse.DataBean.ListBean> {

    public ResultBeautyRecyelerAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder myCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_result_beauty,null,false);
        BaseViewHolder viewHolder = new BaseViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void myBindViewHolder(BaseViewHolder holder, int position) {
        holder.setFrescoUrl(R.id.beauty_item_img,datas.get(position).getUrl());
        holder.setText(R.id.beauty_item_commentCount,datas.get(position).getLike_num());
        holder.setText(R.id.beauty_item_viewCount,"810");
    }

    @Override
    public int getMyItemViewType(int position) {
        return 0;
    }
}
