package com.qq.nps16signup.network;

import com.qq.nps16signup.data.User;
import com.qq.nps16signup.network.request.Language;
import com.qq.nps16signup.network.response.Categories;
import com.qq.nps16signup.network.response.Data;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {
    @GET("/get/active")
    Call<User> getUser();

    @POST("category/get/active")
    Call <Categories> getCategories(@Body Language language);


}
