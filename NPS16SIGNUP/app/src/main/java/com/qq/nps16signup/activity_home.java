package com.qq.nps16signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_home extends AppCompatActivity {
    private static Button button_sbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        OnclickButtonListener();
    }
    public void OnclickButtonListener(){
        button_sbm = (Button)findViewById(R.id.signup);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(activity_home.this, SignUp.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
