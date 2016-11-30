package com.bwf.yiqizhuang.ui.initview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/11/30.
 */

public class AutoScrollFackViewPager extends ViewPager implements OnPageChangeListener{
    private int DURATION = 1200;
    public AutoScrollFackViewPager(Context context) {
        super(context);
        init();
    }

    public AutoScrollFackViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        //用反射修改ViewPager切换时的默认滚动时间
        try {
            Field scrollerField = ViewPager.class.getDeclaredField("mScroller");
            scrollerField.setAccessible(true);
            Scroller scroller = new Scroller(getContext()){
                @Override
                public void startScroll(int startX, int startY, int dx, int dy, int duration) {
                    super.startScroll(startX, startY, dx, dy, DURATION);
                }
            };
            scrollerField.set(this, scroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAdapter(final PagerAdapter adapter) {
        super.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return adapter.getCount();
            }
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return adapter.isViewFromObject(view,object);
            }
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                return adapter.instantiateItem(container,position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                adapter.destroyItem(container, position, object);
            }
        });
        setCurrentItem(0);
        startAutoScroll();
    }

    private Timer timer = new Timer();
    private TimerTask task; //同一个TimeTask只能被启动一次
    /**
     * 开始自动滚动
     */
    public void startAutoScroll(){
        if(task == null){
            //创建任务
            task = new TimerTask() {
                @Override
                public void run() {
                    //在子线程执行
                    nextPage();
                }
            };
            //启动任务
            timer.schedule(task,2000,2000);
        }
    }


    /**
     * 切换到下一页
     */
    private void nextPage() {
        post(new Runnable() {
            @Override
            public void run() {
                if(getCurrentItem() + 1 == getChildCount()){
                    setCurrentItem(0);
                }else {
                    setCurrentItem(getCurrentItem() + 1);
                }

            }
        });
    }

    /**
     * 停止自动滚动
     */
    public void stopAutoScroll(){
        if(task != null){
            task.cancel(); //取消任务
            task = null;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_MOVE:
                stopAutoScroll();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                startAutoScroll();
                break;
        }
        return super.onTouchEvent(ev);
    }


    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

        if (state == ViewPager.SCROLL_STATE_DRAGGING){//用户拖拉
            //停止轮播
        }

        if (state == ViewPager.SCROLL_STATE_IDLE){//滑动停止
            //开启轮播
        }
    }

    @Override
    public void onPageScrolled(int position, float offset, int offsetPixels) {
        super.onPageScrolled(position, offset, offsetPixels);
    }
}
