package com.qq.nps16signup.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.qq.nps16signup.R;
import com.qq.nps16signup.adaptors.SportsAdapter;
import com.qq.nps16signup.data.User;
import com.qq.nps16signup.data.Users;
import com.qq.nps16signup.utils.Utility;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class SportsActivity extends AppCompatActivity {
    ArrayList<String> username = new ArrayList<>();
    ArrayList<String> emailid = new ArrayList<>();
    ArrayList<String> password = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sports);
        initViews();
    }

    private void initViews() {
        RecyclerView lv = findViewById(R.id.rc_sports);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        lv.setLayoutManager(linearLayoutManager);
        List<User> newscategory = new ArrayList<User>();
        //Create a dummy data set
        String userString = Utility.getJsonFromAssets(SportsActivity.this, "news.json");
        Gson gson=new Gson();
        Users users=gson.fromJson(userString, Users.class);

        //for (int i = 0; i < userString.length(); i++) {
           //User user = new User("Sports"+i,"Description" +i,"ggg");
            //newscategory.add(user);
        //}
        SportsAdapter adapter = new SportsAdapter(this,users.getUser());
        lv.setAdapter(adapter);
    }
}
