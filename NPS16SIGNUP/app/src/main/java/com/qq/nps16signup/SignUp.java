package com.qq.nps16signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;


public class SignUp extends AppCompatActivity {
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
                    private User user;

                    @Override
                    public void onClick(View v) {
                        user = new User(Email.getText().toString(),Username.getText().toString(),Password.getText().toString());
                        Intent intent = new Intent(SignUp.this, activity_final.class);
                        intent.putExtra("User" , user);
                        startActivity(intent);
                    }
                }
        );
    }
}
