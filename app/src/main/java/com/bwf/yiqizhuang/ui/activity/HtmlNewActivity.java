package com.bwf.yiqizhuang.ui.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/30.
 */

public class HtmlNewActivity extends BaseActivity {

    @BindView(R.id.company_activity_return_img)
    ImageView companyActivityReturnImg;
    @BindView(R.id.html_activity_title)
    TextView htmlActivityTitle;
    @BindView(R.id.html_activity_webView)
    WebView htmlActivityWebView;
    @BindView(R.id.html_activity_yuyue)
    LinearLayout htmlActivityYuyue;
    @BindView(R.id.html_activity_dayi)
    LinearLayout htmlActivityDayi;
    private String html = "http://hui.17house.com/svc/payment-facade/h5/activity677/index.html?model=android";

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initViews() {
        htmlActivityWebView.loadUrl(html);
        htmlActivityWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.html_layout;
    }

}
