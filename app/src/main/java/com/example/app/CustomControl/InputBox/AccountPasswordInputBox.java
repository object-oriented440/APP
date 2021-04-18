package com.example.app.CustomControl.InputBox;

import com.example.app.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class AccountPasswordInputBox extends LinearLayout {
    public AccountPasswordInputBox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.input_box,this);
    }
}
