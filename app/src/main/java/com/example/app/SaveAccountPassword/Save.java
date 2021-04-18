package com.example.app.SaveAccountPassword;

import com.example.app.MyAppActivity;
import com.example.app.SetTime.DialogActivity;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * 这个是多余的......
 * */
public class Save implements View.OnClickListener{

    private EditText editText_account,editText_password;
    private String account;
    private String password;
    private ArrayList<String> array_AP;

    public ArrayList<String> GetArrayAP()
    {
        return array_AP;
    }
    void DepositedArray()
    {
        array_AP.add(account);
        array_AP.add(password);
    }

    public Save() {
        /**
         * 出现不是一个封闭的类错误
         * */
        /*Toast.makeText(MyAppActivity.this,
                "账号："+account+"，密码："+password,
                Toast.LENGTH_SHORT).show();*/
    }
    public Save(EditText editText1,EditText editText2)
    {
        editText_account = editText1;
        editText_password = editText2;
    }
    void GetData()/**得到账号密码*/
    {
        account = editText_account.getText().toString();
        password = editText_password.getText().toString();
    }

    public int remind = 0;
    @Override
    public void onClick(View v) {
        /**这里的问题*/
        //GetData();

        //DepositedArray();
        remind = 1;
    }
}
