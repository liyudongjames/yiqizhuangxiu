package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.databean.CompanyListViewResponse;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/30.
 */

public class MyListViewAdapter extends BaseAdapter {

    private List<CompanyListViewResponse.DataBean> datas;
    private LayoutInflater inflater;

    public MyListViewAdapter(Context context, List<CompanyListViewResponse.DataBean> datas) {
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.company_listview_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.companyListViewItemArea.setText(datas.get(position).getOrderHouse().getCommunity());
        holder.companyListViewItemHouseStyle.setText(datas.get(position).getOrderHouse().getLayout());
        Log.d("MyListViewAdapter", datas.get(position).getImageUrl());
        holder.companyListViewItemImg.setImageURI(datas.get(position).getImageUrl());
        return convertView;
    }


    class ViewHolder {
        @BindView(R.id.company_listView_item_img)
        SimpleDraweeView companyListViewItemImg;
        @BindView(R.id.company_listView_item_area)
        TextView companyListViewItemArea;
        @BindView(R.id.company_listView_item_house_style)
        TextView companyListViewItemHouseStyle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
