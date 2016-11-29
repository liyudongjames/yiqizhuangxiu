package com.bwf.yiqizhuang.framework.mvp.base;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2016/11/28.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> viewArray;

    public BaseViewHolder(View itemView) {
        super(itemView);
        viewArray = new SparseArray<>();
    }

    public <T extends View>T getView(int viewId){
        View view = viewArray.get(viewId);
        if(view == null){
            view = itemView.findViewById(viewId);
            viewArray.put(viewId,view);
        }
        return (T) view;
    }

    public BaseViewHolder setText(int viewId,String text){
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    public BaseViewHolder setImage(int viewId, Bitmap bitmap){
        ImageView img = getView(viewId);
        img.setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setFrescoUrl(int viewId,String uri){
        SimpleDraweeView draweeView = getView(viewId);
        draweeView.setImageURI(uri);
        return this;
    }
}
