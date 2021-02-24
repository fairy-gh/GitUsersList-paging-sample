package com.fairy_gh.gituserslist_paging.Api;

import com.fairy_gh.gituserslist_paging.Model.User;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("users")
    Observable<List<User>> getUsers(
            //@Query("accept") String accept,
            @Query("since") int since,
            @Query("per_page") int per_page
    );
}
