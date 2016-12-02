package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseRecyclerViewAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseViewHolder;
import com.bwf.yiqizhuang.framework.mvp.databean.YiqiTeamResponse;

/**
 * Created by Administrator on 2016/12/2.
 */

public class YiqiTeamRecyclerAdapter extends BaseRecyclerViewAdapter<YiqiTeamResponse.DataBean>{
    public YiqiTeamRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder myCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.yiqiteam_member_layout,null,false);
        BaseViewHolder holder = new BaseViewHolder(view);
        return holder;
    }

    @Override
    protected void myBindViewHolder(BaseViewHolder holder, int position) {
        holder.setText(R.id.yiqiteam_item_name_tv,datas.get(position).getRealName());
        holder.setText(R.id.yiqiteam_item_anli_tv,"装修案例： "+ datas.get(position).getCaseNumber());
        holder.setFrescoUrl(R.id.yiqiteam_item_img,datas.get(position).getAvatar());
    }

    @Override
    public int getMyItemViewType(int position) {
        return 0;
    }
}
