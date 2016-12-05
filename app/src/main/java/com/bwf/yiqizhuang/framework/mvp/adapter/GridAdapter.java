package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.databean.BuildingResponse;
import com.bwf.yiqizhuang.utils.LogUtils;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by liyudongjames on 2016/12/5.
 */

public class GridAdapter extends BaseAdapter {
    private BuildingResponse.DataBean dataBean;
    private LayoutInflater inflater;
    private int blankPage;
    private int count;

    public GridAdapter(BuildingResponse.DataBean dataBean, Context context){
        this.dataBean = dataBean;
        inflater = LayoutInflater.from(context);
        count  = dataBean.getChildren().size() + 3 + (3-(dataBean.getChildren().size()%3));
        blankPage = count - dataBean.getChildren().size() - 3;
        LogUtils.log(""+count);
        LogUtils.log(""+blankPage);
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int i) {
        return getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(i == 0){
            view = inflater.inflate(R.layout.building_grid_head_item,viewGroup,false);
            SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.building_grid_header_img);
            TextView tv = (TextView) view.findViewById(R.id.building_grid_header_tx);
            draweeView.setImageURI(dataBean.getIcon());
            tv.setText(dataBean.getTitle());
        }else if(i > count - blankPage - 1||i == 1|| i == 2){
            view = inflater.inflate(R.layout.blank_view,viewGroup,false);
        }else{
            view = inflater.inflate(R.layout.building_grid_item,viewGroup,false);
            TextView tv = (TextView) view.findViewById(R.id.building_item_tv);
            tv.setText(dataBean.getChildren().get(i-3).getTitle());
        }
        return view;
    }
}
