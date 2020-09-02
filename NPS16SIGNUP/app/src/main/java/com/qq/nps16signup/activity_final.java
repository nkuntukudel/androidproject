package com.qq.nps16signup;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class activity_final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final2);
        if (getIntent().getExtras() != null) {
            User user = (User) getIntent().getParcelableExtra("User");
            SharedPreferences sharedPreferences = getSharedPreferences("SIGNUP", MODE_PRIVATE);
            String name = sharedPreferences.getString("email", "no name set");
            if (name != null) {
                TextView tv = findViewById(R.id.username);

                tv.setText(name);
            }
        }
    }
}
