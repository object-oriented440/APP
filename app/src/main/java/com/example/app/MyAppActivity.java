package com.example.app;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.SetTime.DialogActivity;

import java.util.ArrayList;


public class MyAppActivity extends AppCompatActivity {

    private int SetHour,SetMinute;
    private ArrayList<Integer> arrayList_Time;

    /**
     * 这里出的问题，不该在这里初始化！
     * */
/*    private EditText editText1 = (EditText)findViewById(R.id.main_layout_editText_Account),
    editText2 = (EditText)findViewById(R.id.main_layout_editText_PassWord);*/
    private EditText editText1,editText2;

/*    private  com.example.app.SaveAccountPassword.Save save_AP =
            new com.example.app.SaveAccountPassword.Save(editText1,editText2);
    private com.example.app.SaveTheOther.Save save_TO =
            new com.example.app.SaveTheOther.Save();*/

    private String account;
    private String password;
    //private ArrayList<String> arrayList_AP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button SaveButton_1 = (Button)findViewById(R.id.main_layout_SaveButton1);
        Button SaveButton_2 = (Button)findViewById(R.id.main_layout_SaveButton2);
        Button DemoButton = (Button)findViewById(R.id.Demo_Button);

        editText1 = (EditText)findViewById(R.id.main_layout_editText_Account);
        editText2 = (EditText)findViewById(R.id.main_layout_editText_PassWord);


        //SaveButton_1.setOnClickListener(save_AP);
        SaveButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account = editText1.getText().toString();
                password = editText2.getText().toString();
                    Toast.makeText(MyAppActivity.this,
                            "账号："+account+"，密码："+password,
                            Toast.LENGTH_SHORT).show();
            }
        });
        //SaveButton_2.setOnClickListener(save_TO);
        SaveButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

/*        if(save_AP.remind == 1)
        {
            SaveAccountPassword();
        }*/
        /**这里出的问题，未点击保存按钮时，不能调用这个方法*/
        //SaveAccountPassword();/**存储account和password信息*/

        DemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(MyAppActivity.this,
                                com.example.app.SetTime.DialogActivity.class);
                //startActivity(intent);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 1:
                if(resultCode == RESULT_OK)
                {
                    arrayList_Time = data.getIntegerArrayListExtra("data_return");
                    SetHour = arrayList_Time.get(0);
                    SetMinute = arrayList_Time.get(1);
                    //Log.d("MyAppActivity","您设定的时间为今天的 "+SetHour+" 时 "+SetMinute+" 分");
                    Toast.makeText(this,
                            "您设定的时间为今天的 "+SetHour+" 时 "+SetMinute+" 分",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
    /*void GetAccountPassword()
    {
        arrayList_AP = save_AP.GetArrayAP();
    }
    void SaveAccountPassword()
    {
        GetAccountPassword();
        //account = arrayList_AP.get(0);
        //password = arrayList_AP.get(1);
        Toast.makeText(MyAppActivity.this, "已获得账号密码！", Toast.LENGTH_SHORT).show();
    }*/
}