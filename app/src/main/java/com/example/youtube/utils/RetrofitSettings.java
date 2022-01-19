package com.example.youtube.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSettings {


    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(YouTubeSettings.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
