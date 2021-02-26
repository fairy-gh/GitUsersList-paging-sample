package com.fairy_gh.gituserslist_paging.Api;

import com.fairy_gh.gituserslist_paging.model.User;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {
    @Headers({"Accept: application/vnd.github.v3+json"})
    @GET("users")
    Call<List<User>> getUsers(
            @Query("since") int userId,
            @Query("per_page") int per_page
    );
}
