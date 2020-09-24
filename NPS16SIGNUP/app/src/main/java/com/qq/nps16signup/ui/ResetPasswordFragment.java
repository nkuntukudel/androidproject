package com.qq.nps16signup.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.qq.nps16signup.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResetPasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResetPasswordFragment extends Fragment implements  View.OnClickListener{

    public static EditText Email;
    public static EditText oldpassword;
    public static EditText newpassword;
    public static Button submit;
    private FragmentClickListner mClickListner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_reset_password, container, false);
        Button submit = v.findViewById(R.id.submit);
        submit.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        mClickListner.oresetFragmentClick();
    }


    public interface FragmentClickListner {
        void oresetFragmentClick();
    }

    public void setFragmentClickListner(FragmentClickListner clickListner) {
        mClickListner = clickListner;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}