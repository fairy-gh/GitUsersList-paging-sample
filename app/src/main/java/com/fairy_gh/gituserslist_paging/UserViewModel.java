package com.fairy_gh.gituserslist_paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.fairy_gh.gituserslist_paging.DataSource.UserDataSource;
import com.fairy_gh.gituserslist_paging.DataSource.UserDataSourceFactory;
import com.fairy_gh.gituserslist_paging.model.User;

public class UserViewModel extends ViewModel {

    public static LiveData<PagedList<User>> userPagedList;

    public UserViewModel(){
        UserDataSourceFactory dataSourceFactory = new UserDataSourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(UserDataSource.per_page)
                .setEnablePlaceholders(true)
                .build();

        userPagedList = new LivePagedListBuilder(dataSourceFactory, config).build();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
