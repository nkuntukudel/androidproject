package com.qq.nps16signup.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.qq.nps16signup.R;
import com.qq.nps16signup.data.User;


public class SignUpActivity extends AppCompatActivity {
    private static Button button_sbm;
    public static EditText Email;
    public static EditText Username;
    public static EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        OnclickButtonListener();
    }
    public void OnclickButtonListener(){
        Email = (EditText)findViewById(R.id.emailid);
        Username = (EditText)findViewById(R.id.userid);
        Password = (EditText)findViewById(R.id.password);
        button_sbm = (Button)findViewById(R.id.signup);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    //private User user;

                    @Override
                    public void onClick(View v) {
                        //user = new User(Email.getText().toString(),Username.getText().toString(),Password.getText().toString());
                        SharedPreferences sharedPreferences = getSharedPreferences("SIGNUP", MODE_PRIVATE);
                        //sharedPreferences.edit().putString("username", user.getmUsername()).commit();
                        //sharedPreferences.edit().putString("email", user.getmEmail()).commit();
                        String username = Username.getText().toString();
                        String email1 = Email.getText().toString();
                        String pass1 = Password.getText().toString();
                        User user=new User(email1,username,pass1,"");
                        //sharedPreferences.edit().putString("username", username).apply();
                        //sharedPreferences.edit().putString("emailkey", email1).apply();
                        //sharedPreferences.edit().putString("passkey", pass1).apply();
                        Gson gson = new Gson();
                        String userString = gson.toJson(user);
                        Log.d("GSON", userString);
                        sharedPreferences.edit().putString("ustring",userString).apply();
                        sharedPreferences.edit().commit();
                        Intent intent = new Intent(SignUpActivity.this, SignupConfirmationActivity.class);
                        //intent.putExtra("User" , user);
                        startActivity(intent);
                    }
                }
        );
    }
}

