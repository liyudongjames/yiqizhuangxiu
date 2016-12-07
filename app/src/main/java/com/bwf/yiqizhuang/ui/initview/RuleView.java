package com.bwf.yiqizhuang.ui.initview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by liyudongjames on 2016/12/6.
 */

public class RuleView extends View{
    private Paint paint;

    public RuleView(Context context) {
        super(context);
        initPaint();
    }

    public RuleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public RuleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint(){
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(25);
        setBackgroundColor(Color.BLACK);
    }



}
