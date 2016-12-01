package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseRecyclerViewAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseViewHolder;
import com.bwf.yiqizhuang.framework.mvp.databean.SiteLiveStateResponse;

/**
 * Created by Administrator on 2016/12/1.
 */

public class SiteLiveStateRecyclerAdapter extends BaseRecyclerViewAdapter<SiteLiveStateResponse.DataBean.ProgressBean>{

    public SiteLiveStateRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder myCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_site_live_state_item,null,false);
        BaseViewHolder viewHolder = new BaseViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void myBindViewHolder(BaseViewHolder holder, int position) {
        if(position == 0){
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(45,0,0,0);
//            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) holder.getView(R.id.rl_item_live_state).getLayoutParams();
//            layoutParams.setMargins(15,0,0,0);
            holder.itemView.setLayoutParams(lp);
        }
        if(position == getItemCount()-1){
//            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//            lp.setMargins(0,0,0,45);
//            holder.itemView.setLayoutParams(lp);
            holder.getView(R.id.site_live_item_divide).setVisibility(View.INVISIBLE);
        }
        switch (datas.get(position).getProgressStatus()){
            case 2:
                holder.setText(R.id.site_live_item_state_textView,"已完成")
                    .setBackGroundColor(R.id.site_live_item_state_textView,context.getResources().getColor(R.color.darker_green))
                    .setText(R.id.site_live_item_statement_textView,datas.get(position).getProgressName())
                    .setImageResource(R.id.site_live_item_state_img,R.mipmap.finish_icon);
                break;
            case 1:
                holder.setText(R.id.site_live_item_state_textView,"进行中")
                        .setBackGroundColor(R.id.site_live_item_state_textView,context.getResources().getColor(R.color.light_green))
                        .setText(R.id.site_live_item_statement_textView,datas.get(position).getProgressName())
                        .setImageResource(R.id.site_live_item_state_img,R.mipmap.working_icon);
                break;
            case 0:
                holder.setText(R.id.site_live_item_state_textView,"未完成")
                        .setBackGroundColor(R.id.site_live_item_state_textView,context.getResources().getColor(R.color.light_gray))
                        .setText(R.id.site_live_item_statement_textView,datas.get(position).getProgressName())
                        .setImageResource(R.id.site_live_item_state_img,R.mipmap.not_finish_icon);
                break;
        }
    }

    @Override
    public int getMyItemViewType(int position) {
        return 0;
    }
}
