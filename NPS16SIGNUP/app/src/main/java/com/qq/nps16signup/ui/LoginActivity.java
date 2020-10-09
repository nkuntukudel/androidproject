package com.qq.nps16signup.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.qq.nps16signup.R;
import com.qq.nps16signup.data.Userss;
import com.qq.nps16signup.utils.Utility;
import com.qq.nps16signup.data.User;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private static Button button_sbm,button_sbmit;
    public static EditText Username;
    public static EditText Password;
    public static TextView HyperLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        OnclickButtonListener();
    }
    public void OnclickButtonListener(){
        button_sbm = (Button)findViewById(R.id.signin);
        button_sbmit = (Button)findViewById(R.id.signup);
        Username = (EditText)findViewById(R.id.userid);
        Password = (EditText)findViewById(R.id.password);
        HyperLink = (TextView)findViewById(R.id.activity_main_link);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String username = Username.getText().toString();
                        String pass1 = Password.getText().toString();
                        //SharedPreferences sharedPreferences = getSharedPreferences("SIGNUP", MODE_PRIVATE);
                        //String name = sharedPreferences.getString("username", "no name set");
                        //String pass = sharedPreferences.getString("passkey", "no name set");
                     //   String userString=sharedPreferences.getString("ustring","no name set");
                        List<User> newscategory = new ArrayList<User>();
                        String userString = Utility.getJsonFromAssets(LoginActivity.this, "user.json");
                        Gson gson=new Gson();

                        User user=gson.fromJson(userString,User.class);


                        if (user.getmUsername().equals(username) && user.getmPassword().equals(pass1)) {
                            Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast toast=Toast.makeText(LoginActivity.this, "The credentials are not valid", Toast.LENGTH_SHORT);
                            //Toast.makeText(activity_home.this, "The credentials are not valid", Toast.LENGTH_SHORT).show();
                            View view =toast.getView();
                            view.setBackgroundColor(Color.RED);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                        }
                    }
                }
        );
        HyperLink.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                        startActivity(intent);

                    }
                }
        );
        button_sbmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
