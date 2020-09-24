package com.qq.nps16signup.network;

import com.bumptech.glide.RequestBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    public Retrofit getRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder().
                addInterceptor(new LogInterceptor()).
        addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                builder.header("Content-Type", "application/json")
                        .removeHeader("Pragma")
                        .header("Cache-Control", String.format("max-age=%d", 30)).build();
                Response response = chain.proceed(request);
                response.cacheResponse();
                return response;
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://ec2-13-233-163-28.ap-south-1.compute.amazonaws.com:3006/api/").
                client(client).
                addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }
}