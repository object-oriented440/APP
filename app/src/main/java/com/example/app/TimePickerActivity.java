package com.example.app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import CustomTimePicker.*;

public class TimePickerActivity extends AppCompatActivity implements View.OnClickListener{

    private CustomDatePicker mTimerPicker;
    private TextView mTvSelectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_picker_activity);

        /**隐藏System UI*/
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.hide();
        }

        findViewById(R.id.time_picker_LinearLayout2).setOnClickListener(this);
        mTvSelectedTime = findViewById(R.id.time_picker_selectTime);
        initTimerPicker();
    }

    @Override
    public void onClick(View v) {
/*        switch (v.getId())
        {
            case R.id.time_picker_selectTime:
                Toast.makeText(TimePickerActivity.this, "发生点击事件", Toast.LENGTH_SHORT).show();
                mTimerPicker.show(mTvSelectedTime.getText().toString());
                break;
            default:
                break;
        }*/
        Toast.makeText(TimePickerActivity.this, "发生点击事件", Toast.LENGTH_SHORT).show();
        mTimerPicker.show(mTvSelectedTime.getText().toString());
    }

    private void initTimerPicker() {
        String beginTime = "2018-10-17 18:00";
        String endTime = DateFormatUtils.long2Str(System.currentTimeMillis(), true);

        mTvSelectedTime.setText(endTime);

        // 通过日期字符串初始化日期，格式请用：yyyy-MM-dd HH:mm
        mTimerPicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                mTvSelectedTime.setText(DateFormatUtils.long2Str(timestamp, true));
            }
        }, beginTime, endTime);
        // 允许点击屏幕或物理返回键关闭
        mTimerPicker.setCancelable(true);
        // 显示时和分
        mTimerPicker.setCanShowPreciseTime(true);
        // 允许循环滚动
        mTimerPicker.setScrollLoop(true);
        // 允许滚动动画
        mTimerPicker.setCanShowAnim(true);
    }
}