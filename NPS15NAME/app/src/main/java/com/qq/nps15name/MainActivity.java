package com.qq.nps15name;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static Button button_sbm;
    private static EditText sendmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnclickButtonListener();
    }
    public void OnclickButtonListener(){
        sendmessage = (EditText)findViewById(R.id.editText);
        button_sbm = (Button)findViewById(R.id.button);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str = sendmessage.getText().toString();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra(Appconstants.MESSAGEKEY,str);
                        // Why only putExtra not getStringExtra ?
                        startActivity(intent);
                    }
                }
        );

    }
}
