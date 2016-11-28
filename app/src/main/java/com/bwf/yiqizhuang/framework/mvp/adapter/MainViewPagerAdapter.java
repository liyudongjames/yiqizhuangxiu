package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.databean.FontPagePagerResponse;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class MainViewPagerAdapter extends PagerAdapter {
    private List<FontPagePagerResponse.DataBean> responses;
    private Context context;
    private List<View> views;

    public MainViewPagerAdapter(Context context, List<FontPagePagerResponse.DataBean> responses) {
        this.context = context;
        this.responses = responses;
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(context);//获取布局加载器
        for (int i = 0; i < responses.size(); i++) {
            View view = inflater.inflate(R.layout.subview_main_slide_page,null);
            views.add(view);
        }
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d("MainViewPagerAdapter", "position:" + position);
        View view = views.get(position % views.size());
        SimpleDraweeView imageView = (SimpleDraweeView) view.findViewById(R.id.iamgeView_subview_main_slide_page);
        //使用fresco加载网络图片
        imageView.setImageURI(responses.get(position% views.size()).getImagesrc());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = views.get(position% views.size());
        container.removeView(view);
    }
}
