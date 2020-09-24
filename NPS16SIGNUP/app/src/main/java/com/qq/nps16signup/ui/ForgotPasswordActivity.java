package com.qq.nps16signup.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qq.nps16signup.R;

public class ForgotPasswordActivity extends AppCompatActivity implements ForgotPasswordFragment.FragmentClickListner,ResetPasswordFragment.FragmentClickListner {
private static Button resend;
private static Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpw);
        OnClickButtonListner();
    }

    public void OnClickButtonListner(){
        resend = (Button)findViewById(R.id.resend);
        reset = (Button)findViewById(R.id.reset);

        resend.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        ForgotPasswordFragment fragment = new ForgotPasswordFragment();
                        fragment.setFragmentClickListner(ForgotPasswordActivity.this);
                        transaction.add(R.id.frameLayout,fragment,"ForgotPass");
                        transaction.addToBackStack("ForgotPass");
                        transaction.commit();
                    }
                }
        );

        reset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        ResetPasswordFragment fragment = new ResetPasswordFragment();
                        fragment.setFragmentClickListner(ForgotPasswordActivity.this);
                        transaction.add(R.id.frameLayout,fragment,"resetPass");
                        transaction.addToBackStack("resetPass");
                        transaction.commit();
                    }
                }
        );

    }

    @Override
    public void onFragmentClick() {
        onBackPressed();
        Toast.makeText(ForgotPasswordActivity.this,"Please check your email",Toast.LENGTH_LONG).show();
        }

    @Override
    public void oresetFragmentClick() {
        onBackPressed();
        Toast.makeText(ForgotPasswordActivity.this,"Please login with new password",Toast.LENGTH_LONG).show();
    }
}