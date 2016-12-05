package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseRecyclerViewAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseViewHolder;
import com.bwf.yiqizhuang.framework.mvp.databean.CityResponse;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class CityRecyclerViewAdapter extends BaseRecyclerViewAdapter<CityResponse.DataBean.ForumlistBean> {
    public CityRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder myCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_city_recycler,null,false);
        BaseViewHolder viewHolder = new BaseViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void myBindViewHolder(BaseViewHolder holder, int position) {
        holder.setFrescoUrl(R.id.item_city_img,datas.get(position).getGroupon_urls());
        holder.setText(R.id.item_city_tv,datas.get(position).getSubject());
    }

    @Override
    public int getMyItemViewType(int position) {
        return 0;
    }
}
