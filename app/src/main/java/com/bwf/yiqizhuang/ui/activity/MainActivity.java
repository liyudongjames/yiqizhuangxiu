package com.bwf.yiqizhuang.ui.activity;

import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.bwf.yiqizhuang.R;
import com.bwf.yiqizhuang.framework.mvp.base.BaseActivity;
import com.bwf.yiqizhuang.ui.fragment.MainFragment;
import com.bwf.yiqizhuang.ui.fragment.MessageFragment;
import com.bwf.yiqizhuang.ui.fragment.MineFragment;
import com.bwf.yiqizhuang.ui.fragment.SayFragment;



public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener{

    FragmentTabHost mainFragmentTabhost;
    TabWidget tabWidget;

    private String texts[] = {"首页", "业主说", "消息", "我的"};
    private Integer nImages[] = {R.mipmap.main_tab_home_normal, R.mipmap.main_tab_community_normal
            , R.mipmap.main_tab_msg_normal, R.mipmap.main_tab_my_normal};
    private Integer sImages[] = {R.mipmap.main_tab_home_selected, R.mipmap.main_tab_community_selected
            , R.mipmap.main_tab_msg_selected, R.mipmap.main_tab_my_selected};
    private Class fragments[] = {MainFragment.class, SayFragment.class, MessageFragment.class,
            MineFragment.class};

    @Override
    protected void initDatas() {
        mainFragmentTabhost.setup(this, getSupportFragmentManager(), R.id.layout_frame);
        tabWidget = mainFragmentTabhost.getTabWidget();
        tabWidget.setDividerDrawable(null);

        for (int i = 0; i < texts.length; i++) {
            TabHost.TabSpec spec = mainFragmentTabhost.newTabSpec(texts[i]).setIndicator(getView(i));
            mainFragmentTabhost.addTab(spec, fragments[i], null);
        }

        mainFragmentTabhost.setOnTabChangedListener(this);
        setImageView(0);
    }

    @Override
    protected void initViews() {
        mainFragmentTabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
    }

    private View view;
    private ImageView[] imageViews = new ImageView[4];
    private TextView textView;
    public View getView(int i) {
        view = View.inflate(this, R.layout.main_tab_content, null);
        imageViews[i] = (ImageView) view.findViewById(R.id.tab_content_img);
        textView = (TextView) view.findViewById(R.id.tab_content_text);
        imageViews[i].setImageResource(nImages[i]);
        textView.setText(texts[i]);
        return view;
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_main;
    }

    public void setImageView(int i){
        for (int j =0 ;j < imageViews.length;j++){
            if(j == i) {
                imageViews[i].setImageResource(sImages[i]);
            }else{
                imageViews[j].setImageResource(nImages[j]);
            }

        }
    }

    @Override
    public void onTabChanged(String tabId) {
        switch (tabId){
            case "首页":
                setImageView(0);
                break;
            case "业主说":
                setImageView(1);
                break;
            case "消息":
                setImageView(2);
                break;
            case "我的":
                setImageView(3);
                break;


        }
    }
}
