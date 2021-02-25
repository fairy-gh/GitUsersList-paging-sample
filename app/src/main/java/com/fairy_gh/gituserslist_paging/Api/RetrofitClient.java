package com.fairy_gh.gituserslist_paging.Api;

import com.fairy_gh.gituserslist_paging.Model.User;
import java.util.List;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.Observable;
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
