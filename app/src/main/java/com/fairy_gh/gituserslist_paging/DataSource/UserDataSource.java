package com.fairy_gh.gituserslist_paging.DataSource;

import android.util.Log;
import android.view.InputQueue;
import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import com.fairy_gh.gituserslist_paging.Api.ApiInterface;
import com.fairy_gh.gituserslist_paging.Api.RetrofitClient;
import com.fairy_gh.gituserslist_paging.model.User;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataSource extends PageKeyedDataSource<Integer, User> {

    private static String TAG  = UserDataSource.class.getSimpleName();
    public static Integer userId;
    public static Integer firstId = 0;
    public static Integer per_page = 20;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, User> callback) {

       RetrofitClient.getInstance().create(ApiInterface.class).getUsers(firstId, per_page).enqueue(new Callback<List<User>>() {
           @Override
           public void onResponse(Call<List<User>> call, Response<List<User>> response) {

               if(response.code() == 200 && response.body() != null){
                   List<User> data = response.body();
                   Log.e(TAG, "====>" + data.size());
                   callback.onResult(data,null, firstId + per_page);
               }
           }

           @Override
           public void onFailure(Call<List<User>> call, Throwable t) {
               Log.e(TAG + "INITIAL", t.toString());
           }
       });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, User> callback) {

        RetrofitClient.getInstance().create(ApiInterface.class).getUsers(params.key, per_page).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if(response.body() != null){
                    List<User> data = response.body();
                    Log.e(TAG, "====>" + data.size());
                    int key = (params.key > (firstId + per_page)) ? params.key - per_page : null;
                    callback.onResult(data, key);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG + "BEFORE", t.toString());
            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, User> callback) {

        RetrofitClient.getInstance().create(ApiInterface.class).getUsers(params.key, per_page).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.body() != null){
                    List<User> data = response.body();
                    Log.e(TAG, "====>" + data.size());
                    int key = (params.key < 120) ? params.key + per_page: null;
                    callback.onResult(data, key);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG + "AFTER", t.toString());
            }
        });

    }
}
