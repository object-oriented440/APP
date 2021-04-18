//package com.example.app.SetTime;
package com.example.app.SetTime;

import com.example.app.R;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

public class DialogActivity extends AppCompatActivity {

    private TextView mCancel,mConfirm;
    private int mHour,mMinute;
    private TimePicker mTimePicker;
    private ArrayList<Integer> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog_time_picker);

        mCancel = (TextView)findViewById(R.id.my_dialog_cancel);
        mConfirm = (TextView)findViewById(R.id.my_dialog_confirm);
        mTimePicker = (TimePicker)findViewById(R.id.my_time_picker_TimePicker);
        arrayList = new ArrayList<Integer>();

        /**隐藏System UI*/
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.hide();
        }

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetTheSetTime();

                /**
                 * 此处错了，因为未给arrayList new一个存储空间
                 * */
                saveArrayList();

/*                Toast.makeText(DialogActivity.this,
                        "您设定的时间为今天的 "+mHour+" 时 "+mMinute+" 分，注意：还没保存",
                        Toast.LENGTH_SHORT).show();*/
                ReturnData();
                finish();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    void GetTheSetTime()/**获得设置的时间*/
    {
        mHour = mTimePicker.getHour();
        mMinute = mTimePicker.getMinute();
    }
    void saveArrayList()/**将mHour和mMinute存入容器*/
    {
        //arrayList.add(mHour);
        //arrayList.add(mMinute);
        arrayList.add(new Integer(mHour));
        arrayList.add(new Integer(mMinute));
    }
    void ReturnData()/**返回数据：hour和minute*/
    {
        Intent intent = new Intent();
        intent.putExtra("data_return",arrayList);
        setResult(RESULT_OK,intent);
    }
}