package com.bwf.yiqizhuang.ui.initview;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bwf.yiqizhuang.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MyPullToRefresh extends LinearLayout{

    private LayoutInflater inflater;
    private View header;
    private Context context;
    private TextView stateText;
    private TextView timeText;
    private ImageView arrows;
    private PullToRefreshListener refreshListener;
    private ProgressBar progressBar;
    private int state = noPulling;
    private float downY;
    private float currentY;
    private int headerHeight;
    private boolean canPull = true;

    public void setOnRefreshListener(PullToRefreshListener refreshListener){
        this.refreshListener = refreshListener;
    }

    public MyPullToRefresh(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public MyPullToRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public MyPullToRefresh(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public void init(){
        inflater = LayoutInflater.from(context);
        header = inflater.inflate(R.layout.refresh_header,null,false);
        stateText = (TextView) header.findViewById(R.id.my_refresh_layout_state_text);
        timeText = (TextView) header.findViewById(R.id.my_refresh_layout_time_text);
        arrows = (ImageView) header.findViewById(R.id.my_refresh_layout_arrow);
        progressBar = (ProgressBar) header.findViewById(R.id.my_refresh_pb);
        addView(header);
        setOrientation(VERTICAL);
        headerHeight = header.getHeight();
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        header.measure(w, h);
        headerHeight = header.getMeasuredHeight();
        setPadding(0,-headerHeight,0,0);
//        hideHead();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
//        View view = getChildAt(0);
//        view.setTop(-headerHeight);
    }

    private static final int noPulling = 0;
    public void goToNoPulling(){
        state = noPulling;
        stateText.setText("一起装修网，省钱有保障");
        timeText.setVisibility(View.VISIBLE);
        arrows.setVisibility(View.VISIBLE);
    }
    private static final int isPulling = 1;
    public void goToIsPulling(){
        state = isPulling;
        stateText.setText("下拉");
    }
    private static final int canPulling = 2;
    public void goToCanPulling(){
        state = canPulling;
        smoothRotateArrow();
        stateText.setText("放开刷新");
    }
    private static final int isRefreshing = 3;
    public void goToIsRefreshing(){
        state = isRefreshing;
        stateText.setText("正在刷新");
        timeText.setVisibility(View.INVISIBLE);
        arrows.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    private static final int freshingComplete = 4;
    public void goToFreshingComplete(){
        state = freshingComplete;
        stateText.setText("刷新成功");
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    public void setCanPull(boolean flag){
        canPull = flag;
    }

    private float interDownY;
    private float interMoveY;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                interDownY = ev.getY();
                downY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                interMoveY = ev.getY();
                downY = ev.getY();
                float scaleY =  interDownY - interMoveY;
                Log.d("MyPullToRefresh", "interDownY:" + interDownY);
                Log.d("MyPullToRefresh", "interMoveY:" + interMoveY);
                Log.d("MyPullToRefresh", "scaleY:" + scaleY);
                if(scaleY < -5 && canPull){
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                interDownY = 0;
                interMoveY = 0;
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(hideAnimator!=null) {
                    if (hideAnimator.isRunning()) {
                        hideAnimator.cancel();
                    }
                }
                if(refreshAnimator!=null) {
                    if (refreshAnimator.isRunning()) {
                        refreshAnimator.cancel();
                    }
                }
                downY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                currentY = event.getY();
                float scaleY = currentY - downY;
                switch (state){
                    case noPulling:
                        if(scaleY <= 0){
                            return false;
                        }
                        scrollBy(0, (int) (-scaleY));
                        goToIsPulling();
                        break;
                    case isPulling:
                        if(getScrollY() < -headerHeight)
                            goToCanPulling();
                        if(getScrollY() >= headerHeight)
                            return false;
                        scrollBy(0, (int) (-scaleY));
                        break;
                    case canPulling:
                        if(getScrollY() > -headerHeight) {
                            goToIsPulling();
                            smoothRotateArrow();
                        }
                        scaleY = scaleY/3;
                        scrollBy(0, (int) (-scaleY));
                        break;
                    case isRefreshing:
                        scrollBy(0, (int) (-scaleY));
                        goToIsPulling();
                        break;
                    case freshingComplete:
                        if(scaleY < 0){
                            return false;
                        }
                        scrollBy(0, (int) (-scaleY));
                        break;
                }
                downY = currentY;
                break;
            case MotionEvent.ACTION_UP:
                downY = 0;
                currentY = 0;
                switch (state){
                    case noPulling:
                        break;
                    case isPulling:
                        smoothHideHead();
                        goToIsPulling();
                        break;
                    case canPulling:
                        goToIsRefreshing();
                        smoothRefreshing();
//                        isRefreshing();
                        break;
                }
                break;
        }

        return true;
    }

    public void isRefreshing(){
        if(refreshListener!= null){
            refreshListener.onRefreshing();
        }
    }

    public void refreshingComplete(){
        if(state == isRefreshing) {
            goToFreshingComplete();
            smoothHideHead();
        }
    }

    private ValueAnimator refreshAnimator;
    private void smoothRefreshing(){
        smoothRotateArrow();
        refreshAnimator = ValueAnimator
                .ofFloat((getScrollY()),-headerHeight)
                .setDuration(500);
        refreshAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float scale = (float) animation.getAnimatedValue();
                scrollTo(0, (int) scale);
            }
        });
        refreshAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isRefreshing();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        refreshAnimator.start();
    }

    ValueAnimator hideAnimator;
    private void smoothHideHead(){
        hideAnimator = ValueAnimator
                .ofFloat((getScrollY()), 0)
                .setDuration(1000);

        hideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float scale = (float) animation.getAnimatedValue();
                scrollTo(0, (int) scale);
            }
        });

        hideAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                goToNoPulling();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        hideAnimator.start();
    }

    private boolean arrowIsRotate;
    ValueAnimator arrowsAnimation;
    private void smoothRotateArrow(){
        if(arrowIsRotate == false) {
            arrowsAnimation = new ValueAnimator().ofFloat(0f,-180f)
                    .setDuration(200);
            arrowsAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float rotate = (float) animation.getAnimatedValue();
                    arrows.setRotation(rotate);
                }
            });
            arrowsAnimation.start();
            arrowIsRotate = true;
        }else{
            arrowsAnimation = new ValueAnimator().ofFloat(-180f,0)
                    .setDuration(200);
            arrowsAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float rotate = (float) animation.getAnimatedValue();
                    arrows.setRotation(rotate);
                }
            });
            arrowsAnimation.start();
            arrowIsRotate = false;
        }
    }

    public interface PullToRefreshListener{
        void onRefreshing();
    }

}
