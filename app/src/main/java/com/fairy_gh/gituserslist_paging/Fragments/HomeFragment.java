package com.fairy_gh.gituserslist_paging.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fairy_gh.gituserslist_paging.Adapter.UserAdapter;
import com.fairy_gh.gituserslist_paging.model.User;
import com.fairy_gh.gituserslist_paging.R;
import com.fairy_gh.gituserslist_paging.UserViewModel;
import com.fairy_gh.gituserslist_paging.databinding.FragmentHomeBinding;

import static androidx.recyclerview.widget.RecyclerView.*;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    FragmentHomeBinding binding;
    UserViewModel viewModel;
    UserAdapter adapter = new UserAdapter(getActivity());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getActivity(), "Hello", Toast.LENGTH_LONG).show();

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        viewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        viewModel.userPagedList.observe(getActivity(), new Observer<PagedList<User>>() {
            @Override
            public void onChanged(PagedList<User> users) {
                adapter.submitList(users);
            }
        });

    }
}