package com.example.app;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import CustomTimePicker.*;

public class MyAppActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button DemoButton = (Button)findViewById(R.id.Demo_Button);
        DemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(MyAppActivity.this, TimePickerActivity.class);
                startActivity(intent);
            }
        });
    }
}