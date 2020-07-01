package com.qq.nps16signup;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;

public class activity_final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final2);
        if (getIntent().getExtras() != null) {
            Bundle bundle = intent.getExtras();
            bundle.getExtra("user");
            User user = (User) getIntent().getParcelableExtra("user");
            Log.i("activity_final", user.getmEmail());

        }
    }
}
