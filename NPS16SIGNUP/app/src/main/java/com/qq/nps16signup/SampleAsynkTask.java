package com.qq.nps16signup;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.qq.nps16signup.data.User;
import com.qq.nps16signup.data.Users;
import com.qq.nps16signup.network.ApiService;
import com.qq.nps16signup.network.NetworkManager;
import com.qq.nps16signup.network.request.Language;
import com.qq.nps16signup.network.response.Categories;
import com.qq.nps16signup.network.response.Data;
import com.qq.nps16signup.utils.Utility;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SampleAsynkTask extends AsyncTask<String,Integer, Users> {
    Context mContext;
    ResponseListner mResponseListner;

    public SampleAsynkTask(Context context, ResponseListner responseListner) {
        mContext = context;
        mResponseListner = responseListner;
    }

    @Override
    protected void onPostExecute(Users s) {//This is called in UI thread
        super.onPostExecute(s);

        mResponseListner.onComplete(s);
    }

    @Override
    protected Users doInBackground(String... voids) {//This is called in secondory thread
     onProgressUpdate(0);
        String input = voids[0];
        Log.d("Input", input);

       /* String users = Utility.getJsonFromAssets(mContext,"news.json");
        Users user = new Gson().fromJson(users, Users.class);*/

        return  fetchCategory();
    }

    private Users fetchCategory() {
        NetworkManager manage = new NetworkManager();
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
                    onPostExecute(users);
                } else {
                    return;
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {

            }
        });
        return users;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {//This is called in UI thread
        super.onProgressUpdate(values);

        mResponseListner.onProgress();
    }

    @Override
    protected void onPreExecute() {//This is called in UI thread
        super.onPreExecute();

    mResponseListner.onPreExecute();

    }

    public interface ResponseListner {
      void onComplete(Users user);
      void onProgress();
      void onPreExecute();
    }
}
