package com.fairy_gh.gituserslist_paging.DataSource;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.fairy_gh.gituserslist_paging.Model.User;

public class UserDataSourceFactory extends DataSource.Factory<Integer, User> {

    MutableLiveData<UserDataSource> userDataSourceMld = new MutableLiveData<>();

    public MutableLiveData<UserDataSource> getUserDataSourceMld() {
        return userDataSourceMld;
    }

    @NonNull
    @Override
    public DataSource<Integer, User> create() {
        UserDataSource userDataSource = new UserDataSource();
        userDataSourceMld.postValue(userDataSource);
        return userDataSource;
    }
}
