package com.bwf.yiqizhuang.framework.mvp.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.yiqizhuang.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/29.
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected Context context;
    protected LayoutInflater inflater;
    protected List<T> datas;
    protected final int HEADER = 1004;
    protected final int FOOTER = 1005;
    protected View headerView;
    protected View footerView;
    protected OnItemClickListner listner;

    public interface OnItemClickListner{
        void onItemClickListener(View view,int position);
        void onItemLongClickListener(View view,int position);
    }

    public void setOnItemClickListner(OnItemClickListner listner){
        this.listner = listner;
    }

    public BaseRecyclerViewAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
        datas = new ArrayList<>();
    }

    public void addData(List<T> t){
        Log.d("BaseRecyclerViewAdapter", "t.size():" + t.size());
        datas.addAll(t);
        notifyDataSetChanged();
    }

    public void deleteAllData(){
        datas = new ArrayList<>();
    }

    public void deleteData(int position){
        datas.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == HEADER){
            return new BaseViewHolder(headerView);
        }else if(viewType == FOOTER){
            return new BaseViewHolder(footerView);
        }
        return myCreateViewHolder(parent,viewType);
    }

    protected abstract BaseViewHolder myCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        myBindViewHolder(holder,position);
        setUpClickListener(holder,position);
    }

    protected abstract void myBindViewHolder(BaseViewHolder holder, int position);

    protected void setUpClickListener(BaseViewHolder holder,final int position){
        if(listner!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClickListener(v,position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listner.onItemLongClickListener(v,position);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(isHeaderView(position)){
            LogUtils.log("Base_Header_type"+HEADER);
            return HEADER;
        }else if(isFooterView(position)){
            LogUtils.log("Base_Footer_type"+FOOTER);
            return FOOTER;
        }else{
            LogUtils.log("Base_Normal_type"+FOOTER);
            return getMyItemViewType(position);
        }
    }

    /**
     * 实现自己的item_Type
     * @param position
     * @return 返回子类的item_Type类型
     */
    public abstract int getMyItemViewType(int position);

    @Override
    public int getItemCount() {
        int count = (datas == null ? 1 : datas.size());
        if (footerView != null) {
            count++;
        }
        if (headerView != null) {
            count++;
        }
        LogUtils.log("Base_Count"+count);
        return count;
    }

    public void addHeadView(View headView) {
        if(headView == null) {
            LogUtils.log("add_Header");
            this.headerView = headView;
            notifyItemInserted(0);
        }
    }

    public void addFooterView(View footerView){
        if(footerView == null) {
            LogUtils.log("add_Footer");
            this.footerView = footerView;
//            notifyItemInserted(getItemCount());
            notifyDataSetChanged();
        }
    }

    protected boolean haveHeaderView() {
        return headerView != null;
    }

    protected boolean haveFooterView(){
        return footerView != null;
    }

    protected boolean isHeaderView(int position) {
        return haveHeaderView() && position == 0;
    }

    protected boolean isFooterView(int position) {
        return haveFooterView() && position == getItemCount() - 1;
    }
}
