package com.example.app.SetTime;

import com.example.app.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/***/
import static java.lang.Thread.sleep;

public class TimePickerActivity extends AppCompatActivity {

/*    private Context mContext;*/
    private Dialog mPickerDialog;
/*    private TextView mTvHourUnit, mTvMinuteUnit;
    private PickerView mDpvHour, mDpvMinute;*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 1:
                finish();
                break;
            default:
                break;
        }
        //finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_time_picker);
        //setContentView(R.layout.my_dialog_time_picker);

        /**隐藏System UI*/
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.hide();
        }


        /**进入当前活动后直接跳出dialog*/
        /*initView();
        mPickerDialog.show();*/
        /**退而求其次：进入当前活动后直接跳出dialog相关活动*/
        Intent intent = new Intent(TimePickerActivity.this, DialogActivity.class);
        //startActivity(intent);
        startActivityForResult(intent,1);


//        Button button = (Button)findViewById(R.id.my_time_picker_button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(TimePickerActivity.this, DialogActivity.class);
//                startActivity(intent);
//            }
//        });


    }
   /* private void initView()
    {
        mPickerDialog = new Dialog(mContext, R.style.my_time_picker_dialog);
        mPickerDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mPickerDialog.setContentView(R.layout.my_dialog_time_picker);

        Window window = mPickerDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.gravity = Gravity.BOTTOM;
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(lp);
        }

*//*        //mPickerDialog.findViewById(R.id.my_dialog_cancel).setOnClickListener(new);
        //mPickerDialog.findViewById(R.id.my_dialog_confirm).setOnClickListener(new);
        mTvHourUnit = mPickerDialog.findViewById(R.id.my_dialog_hour_unit);
        mTvMinuteUnit = mPickerDialog.findViewById(R.id.my_dialog_minute_unit);
        mDpvHour = mPickerDialog.findViewById(R.id.dpv_hour);
        //mDpvHour.setOnSelectListener(this);
        mDpvMinute = mPickerDialog.findViewById(R.id.dpv_minute);
        //mDpvMinute.setOnSelectListener(this);*//*
    }*/
}