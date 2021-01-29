package com.gowtham.mvvmapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gowtham.mvvmapplication.adapters.NewsAdapter;
import com.gowtham.mvvmapplication.adapters.UserListAdapter;
import com.gowtham.mvvmapplication.pojo.NewsResponse;
import com.gowtham.mvvmapplication.pojo.UserListResponse;
import com.gowtham.mvvmapplication.view_model.NewsViewModel;
import com.gowtham.mvvmapplication.view_model.UserListViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity implements UserListAdapter.UserItemClickListener{

    private RecyclerView mRecyclerView;
    private UserListAdapter newsAdapter;
    private ArrayList<UserListResponse> articleArrayList = new ArrayList<>();
    private UserListViewModel userListViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        init();
    }

    private void init(){
        mRecyclerView = findViewById(R.id.rvNews);

        userListViewModel = ViewModelProviders.of(this).get(UserListViewModel.class);
        userListViewModel.init();
        userListViewModel.getUserListRepository().observe(this, newsResponse -> {
            List<UserListResponse> newsArticles = newsResponse;
            articleArrayList.addAll(newsArticles);
            newsAdapter.notifyDataSetChanged();
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = new UserListAdapter(UserActivity.this, articleArrayList, this);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(newsAdapter);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setNestedScrollingEnabled(true);
        } else {
            newsAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,articleArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}
