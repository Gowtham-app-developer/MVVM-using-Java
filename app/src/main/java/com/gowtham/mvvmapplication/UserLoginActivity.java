package com.gowtham.mvvmapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gowtham.mvvmapplication.adapters.UserListAdapter;
import com.gowtham.mvvmapplication.pojo.UserListResponse;
import com.gowtham.mvvmapplication.view_model.UserListViewModel;
import com.gowtham.mvvmapplication.view_model.UserLoginViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserLoginActivity extends AppCompatActivity {

    private UserLoginViewModel userListViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        init();
    }

    private void init(){

        userListViewModel = ViewModelProviders.of(this).get(UserLoginViewModel.class);
        userListViewModel.init();
        userListViewModel.getNewsRepository().observe(this, newsResponse -> {
            Toast.makeText(this, newsResponse.getTitle(), Toast.LENGTH_SHORT).show();
        });

    }

}
