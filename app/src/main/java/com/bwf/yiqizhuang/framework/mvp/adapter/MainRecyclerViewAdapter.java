package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.yiqizhuang.framework.mvp.databean.MainRecyclerViewResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<MainRecyclerViewResponse.DataBean> dataBeens;
    private LayoutInflater inflater;
    private Context context;

    public MainRecyclerViewAdapter(Context context){
        dataBeens = new ArrayList<>();
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setDataBeens(List<MainRecyclerViewResponse.DataBean> dataBeen){
        dataBeens.addAll(dataBeen);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
