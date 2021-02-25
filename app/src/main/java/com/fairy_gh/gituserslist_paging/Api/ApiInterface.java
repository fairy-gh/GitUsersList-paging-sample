package com.fairy_gh.gituserslist_paging.Api;

import com.fairy_gh.gituserslist_paging.Model.User;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("users")
    Call<List<User>> getUsers(
            @Query("since") int userId,
            @Query("per_page") int per_page
    );
}
