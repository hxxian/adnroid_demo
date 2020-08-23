package com.wuling.android.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wuling.android.demo.activity.SlideConflictActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSlideConflict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btnSlideConflict = findViewById(R.id.btn_slide_conflict);
        btnSlideConflict.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_slide_conflict:
                jumpSlideConflictActivity();
                break;
        }
    }

    private void jumpSlideConflictActivity() {
        startActivity(new Intent(this, SlideConflictActivity.class));
    }
}