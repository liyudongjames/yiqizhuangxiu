package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.framework.mvp.base.BaseRecyclerViewAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseViewHolder;

/**
 * Created by liyudongjames on 2016/12/6.
 */

public class BeautyPopAdapter extends BaseRecyclerViewAdapter<String> {

    public BeautyPopAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder myCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.school_tag_item,null,false);
        BaseViewHolder viewHolder = new BaseViewHolder(view);
        return viewHolder;
    }

    @Override
    protected void myBindViewHolder(BaseViewHolder holder, int position) {
        TextView textView = (TextView) holder.itemView;
        textView.setText(datas.get(position));
    }

    @Override
    public int getMyItemViewType(int position) {
        return 0;
    }
}
