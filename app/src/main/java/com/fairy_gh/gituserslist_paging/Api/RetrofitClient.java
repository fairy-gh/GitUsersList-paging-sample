package com.fairy_gh.gituserslist_paging.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String base_url = "https://api.github.com/";
    private static Retrofit instance = null;

    public static Retrofit getInstance(){

        if(instance == null){
            instance = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

    /*public static ApiInterface getApiInterface(){
        return instance.create(ApiInterface.class);
    }*/
}
