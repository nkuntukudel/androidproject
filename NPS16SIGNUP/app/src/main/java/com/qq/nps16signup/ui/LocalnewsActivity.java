package com.qq.nps16signup.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.qq.nps16signup.R;
import com.qq.nps16signup.adaptors.LocalnewsAdpater;
import com.qq.nps16signup.adaptors.SportsAdapter;
import com.qq.nps16signup.data.Localnews;
import com.qq.nps16signup.data.Users;
import com.qq.nps16signup.utils.Utility;

public class LocalnewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_localnews);
        initViews();
    }

    private void initViews(){
        RecyclerView rv=findViewById(R.id.rc_localnews);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(linearLayoutManager);
        String userString = Utility.getJsonFromAssets(LocalnewsActivity.this, "localnews.json");
        Gson gson=new Gson();
        Localnews localnews=gson.fromJson(userString, Localnews.class);
        LocalnewsAdpater adapter = new LocalnewsAdpater(this,localnews.getUser());
        rv.setAdapter(adapter);
        rv.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
    }

}
