package com.qq.nps15name;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView receiver_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        receiver_msg = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
        String str = intent.getStringExtra(Appconstants.MESSAGEKEY);
        receiver_msg.setText(str);
    }
}
