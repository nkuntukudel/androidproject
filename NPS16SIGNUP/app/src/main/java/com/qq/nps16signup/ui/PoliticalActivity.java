package com.qq.nps16signup.ui;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.qq.nps16signup.R;
import com.qq.nps16signup.adaptors.PoliticalAdapter;
import com.qq.nps16signup.data.User;

import java.util.ArrayList;
import java.util.List;


public class PoliticalActivity extends AppCompatActivity implements PoliticalAdapter.ItemClickListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_political);

        initViews();
    }

    private void initViews() {
        ListView lv = findViewById(R.id.list_view);
        //FInd the list view ref
        List<User> newscategory = new ArrayList<User>();
        //Create a dummy data set
        for (int i = 0; i < 100 ; i++) {
            User user = new User("HEADLINE"+i,"Description" +i,"ggg", "");
            newscategory.add(user);
        }
        //Create adapter,
        ListAdapter adapter = new PoliticalAdapter(this, newscategory, this);
        //setting the adapter
        lv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(User user) {
        Toast.makeText(this,"News " + user.getmEmail(),Toast.LENGTH_LONG).show();
    }
}
