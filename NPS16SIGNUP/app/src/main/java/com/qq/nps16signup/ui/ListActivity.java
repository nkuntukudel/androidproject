package com.qq.nps16signup.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.qq.nps16signup.R;

import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_political);

        initViews();
    }

    private void initViews() {
        ListView lv = findViewById(R.id.list_view);
        List<String> food= Arrays.asList(getResources().getStringArray(R.array.newscategory));
        ListAdapter adapter = new ArrayAdapter<String>(this,R.layout.item_view_home,food);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent political=new Intent(ListActivity.this, PoliticalActivity.class);
                        startActivity(political);
                }
                switch(position){
                    case 1:
                        Intent sports=new Intent(ListActivity.this, SportsActivity.class);
                        startActivity(sports);
                }
                switch(position){
                    case 2:
                        Intent tech=new Intent(ListActivity.this, TechActivity.class);
                        startActivity(tech);
                }
                switch(position){
                    case 3:
                        openDialog();
                }
                switch(position){
                    case 4:
                        Intent localnews=new Intent(ListActivity.this, LocalnewsActivity.class);
                        startActivity(localnews);
                }
            }
        });
    }
    public void openDialog(){
        DialogFragment dialogFragment=new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"dialogfragment");
    }
}