package com.wuling.android.demo.slideconflict;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * @Author: huang xiao xian
 * @Date: 2020/8/21
 * @Des:
 */
public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private boolean touchOnChildView;


    public void setTouchOnChildView(boolean touchOnChildView) {
        this.touchOnChildView = touchOnChildView;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);

    }
}