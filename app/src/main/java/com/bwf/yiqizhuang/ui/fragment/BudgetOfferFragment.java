package com.bwf.yiqizhuang.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liyudongjames on 2016/12/6.
 */

public class BudgetOfferFragment extends BaseFragment {

    @BindView(R.id.fragment_offer_webView)
    WebView fragmentOfferWebView;

    private String url = "http://m.beijing.17house.com/baojia/?sem=android&model=android";

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_offer;
    }

    @Override
    protected void initView() {
        fragmentOfferWebView.loadUrl(url);
    }

    @Override
    protected void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
