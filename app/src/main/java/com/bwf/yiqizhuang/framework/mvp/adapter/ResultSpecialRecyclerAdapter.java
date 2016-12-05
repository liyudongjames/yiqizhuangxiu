package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseRecyclerViewAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseViewHolder;
import com.bwf.yiqizhuang.framework.mvp.databean.ResultSpeciaResponse;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class ResultSpecialRecyclerAdapter extends BaseRecyclerViewAdapter<ResultSpeciaResponse.DataBean.ListBean> {

    public ResultSpecialRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder myCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler_result_special,null,false);
        BaseViewHolder viewHolder = new BaseViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void myBindViewHolder(BaseViewHolder holder, int position){
        holder.setText(R.id.special_item_title,datas.get(position).getTitle());
        holder.setText(R.id.special_item_viewCount,datas.get(position).getLike_num());
        holder.setText(R.id.special_item_commentCount,datas.get(position).getComment_count());
        holder.setFrescoUrl(R.id.special_item_img,datas.get(position).getUrl());
        holder.setText(R.id.special_item_content_tv,datas.get(position).getDesc());
    }

    @Override
    public int getMyItemViewType(int position) {
        return 0;
    }
}
