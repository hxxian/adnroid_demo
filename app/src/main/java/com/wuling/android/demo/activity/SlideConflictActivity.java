package com.wuling.android.demo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.wuling.android.demo.R;
import com.wuling.android.demo.slideconflict.MyScrollView;

public class SlideConflictActivity extends AppCompatActivity {

    private static final String TAG = "SlideConflictActivity";

    private TextView tvMove;
    private MyScrollView myScrollView;

    private float totalOffsetX;
    private float totalOffsetY;
    private float lastX;
    private float lastY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_confict);

        initView();
    }


    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        tvMove = findViewById(R.id.view_moving);
        myScrollView = findViewById(R.id.myscrollview);

        tvMove.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getActionMasked();

                float x = event.getRawX();
                float y = event.getRawY();

                if (action != MotionEvent.ACTION_UP) {
//                    tvMove.getParent().requestDisallowInterceptTouchEvent(true);
                }

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = x;
                        lastY = y;

                        myScrollView.setTouchOnChildView(true);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float offsetX = x - lastX;
                        float offsetY = y - lastY;

                        totalOffsetX += offsetX;
                        totalOffsetY += offsetY;

                        tvMove.setTranslationX(totalOffsetX);
                        tvMove.setTranslationY(totalOffsetY);

                        lastX = x;
                        lastY = y;
                        break;
                    case MotionEvent.ACTION_UP:
                        myScrollView.setTouchOnChildView(false);
//                        tvMove.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Log.w(TAG, "事件被拦截。。。");
                        break;
                }

                return true;
            }
        });
    }
}