package com.fairy_gh.gituserslist_paging.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.fairy_gh.gituserslist_paging.Model.User;
import com.fairy_gh.gituserslist_paging.R;
import com.fairy_gh.gituserslist_paging.databinding.UserItemBinding;
import java.util.List;

public class UserAdapter extends PagedListAdapter<User, UserAdapter.ViewHolder> {

    Context context;
    public UserAdapter(Context context) {
        super(diffCallBack);
        this.context = context;
    }

    private static final DiffUtil.ItemCallback<User> diffCallBack = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return (oldItem.getId() == newItem.getId());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        UserItemBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.user_item, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User item = getItem(position);
        holder.itemBinding.setUser(item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        UserItemBinding itemBinding;
        public ViewHolder(UserItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

}
