package com.bwf.yiqizhuang.framework.mvp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseRecyclerViewAdapter;
import com.bwf.yiqizhuang.framework.mvp.base.BaseViewHolder;
import com.bwf.yiqizhuang.framework.mvp.databean.MainRecyclerViewResponse;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class MainRecyclerViewAdapter extends BaseRecyclerViewAdapter<MainRecyclerViewResponse.DataBean>{

    private final int ARTICLE = 1006;
    private final int POST = 1007;

    public MainRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder myCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = null;
        if(viewType == ARTICLE){
            View view = inflater.inflate(R.layout.main_recyclerview_article,parent,false);
            viewHolder = new BaseViewHolder(view);
        }else if(viewType == POST){
            View view = inflater.inflate(R.layout.main_recyclerview_post,parent,false);
            viewHolder = new BaseViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    protected void myBindViewHolder(BaseViewHolder holder, int position) {
            int type = getMyItemViewType(position);
            int dataPostition = (haveHeaderView() ? position - 1 : position);
            switch (type) {
                case HEADER:

                    break;
                case FOOTER:

                    break;
                case ARTICLE:
                    holder.setFrescoUrl
                            (R.id.fragment_main_recycler_article_item_img_imageview,
                                    datas.get(dataPostition).getPath());
                    holder.setText
                            (R.id.fragment_main_recycler_article_item_textview,
                                    datas.get(dataPostition).getTitle());
                    holder.setText
                            (R.id.fragment_main_recycler_article_item_day_textview,
                                    datas.get(dataPostition).getDateline());
                    holder.setText
                            (R.id.fragment_main_recycler_article_item_viewed_textview,
                                    datas.get(dataPostition).getViews());
                    holder.setText
                            (R.id.fragment_main_recycler_article_item_content_textview,
                                    datas.get(dataPostition).getReplies());
                    break;
                case POST:
                    holder.setFrescoUrl
                            (R.id.fragment_main_recycler_post_item_img_imageView,
                                    datas.get(dataPostition).getPath());
                    holder.setText
                            (R.id.fragment_main_recycler_post_item_title_textView,
                                    datas.get(dataPostition).getTitle());
                    holder.setText
                            (R.id.fragment_main_recycler_post_item_viewed_textView,
                                    datas.get(dataPostition).getViews());
                    holder.setText
                            (R.id.fragment_main_recycler_post_item_content_textView,
                                    datas.get(dataPostition).getReplies());
                    holder.setFrescoUrl
                            (R.id.fragment_main_recycler_post_item_head_imageView,
                                    datas.get(dataPostition).getAvtUrl());
                    holder.setText
                            (R.id.fragment_main_recycler_post_item_nickname_textView,
                                    datas.get(dataPostition).getAuthor());
                    holder.setText
                            (R.id.fragment_main_recycler_post_item_day_textView,
                                    datas.get(dataPostition).getDateline());
                    break;
            }
    }

    @Override
    public int getMyItemViewType(int position) {
        if(datas.size() != 0) {
            int type = datas.get(position).getType();
            if (type == 1) {
                return ARTICLE;
            } else if (type == 3) {
                return POST;
            }
        }
        return 1;
    }
}
