package com.qq.nps16signup.ui;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qq.nps16signup.R;
import com.qq.nps16signup.data.User;


public class SignupConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regconfirmation);
        //if (getIntent().getExtras() != null) {
            //User user = (User) getIntent().getParcelableExtra("User");
            SharedPreferences sharedPreferences = getSharedPreferences("SIGNUP", MODE_PRIVATE);
            String userString = sharedPreferences.getString("ustring", "no name set");
        Gson gson=new Gson();
        User user=gson.fromJson(userString,User.class);
            if (user.getmUsername() != null) {
                TextView tv = findViewById(R.id.username);

                tv.setText("The username enrolled is: "+user.getmUsername());
            }
            //String namee = sharedPreferences.getString("emailkey", "no name set");
            if (user.getmEmail() != null) {
                TextView tv1 = findViewById(R.id.emailid);

                tv1.setText("The email id enrolled is: "+user.getmEmail());
             }
        }
    }
