package com.qq.nps16signup.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qq.nps16signup.R;
import com.qq.nps16signup.SampleAsynkTask;
import com.qq.nps16signup.adaptors.TechAdapter;
import com.qq.nps16signup.data.User;
import com.qq.nps16signup.data.Users;
import com.qq.nps16signup.network.ApiService;
import com.qq.nps16signup.network.NetworkManager;
import com.qq.nps16signup.network.request.Language;
import com.qq.nps16signup.network.response.Categories;
import com.qq.nps16signup.network.response.Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class TechActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tech);
        initViews();
    }

    private void initViews() {
        final RecyclerView rv=findViewById(R.id.rc_tech);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(linearLayoutManager);

    /*    NetworkManager manage = new NetworkManager();
        final Users users = new Users();
        final ArrayList<User> list = new ArrayList<>();

        Retrofit retrofit = manage.getRetrofit();
        final ApiService apiService = retrofit.create(ApiService.class);
        Language language = new Language("HI");
        final Call<Categories> user = apiService.getCategories(language);
        user.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                if (response != null && response.body() != null) {
                    Categories categories = response.body();

                    for (int i = 0; i < categories.getData().size(); i++) {
                        Data data = categories.getData().get(i);
                        User userObj = new User(data.getName(), data.getGuid(), data.getCreatedAt(), data.getImage());
                        list.add(userObj);
                    }
                    users.setUser(list);
                    setAdapter(users, rv);
                } else {
                    return;
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {

            }
        });*/

        SampleAsynkTask task = new SampleAsynkTask(this, new SampleAsynkTask.ResponseListner() {
            @Override
            public void onComplete(Users user) {
                setAdapter(user, rv);
            }

            @Override
            public void onProgress() {

            }

            @Override
            public void onPreExecute() {
                // showLoader
            }
        });
        AsyncTask<String, Integer, Users> value = task.execute("sports");

        List<User> newscategory=new ArrayList<User>();
        for(int i = 0; i < 100 ; i++){
            User user=new User("Tech "+i,"Descreption "+i,"ggg","");
            newscategory.add(user);
        }

    }

    private void setAdapter(Users user, RecyclerView rv) {
        if (user != null && user.getUser() != null) {
            TechAdapter adapter = new TechAdapter(TechActivity.this, user.getUser());
            rv.setAdapter(adapter);
            rv.setVisibility(View.VISIBLE);
            TextView tv = findViewById(R.id.empty);
            tv.setVisibility(View.GONE);
        } else {
            rv.setVisibility(View.GONE);
            TextView tv = findViewById(R.id.empty);
            tv.setVisibility(View.VISIBLE);
            //show error screen
        }
    }
}
