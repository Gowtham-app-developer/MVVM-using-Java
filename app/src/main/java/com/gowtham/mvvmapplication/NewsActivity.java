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
import com.gowtham.mvvmapplication.pojo.NewsResponse;
import com.gowtham.mvvmapplication.view_model.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements NewsAdapter.UserItemClickListener{

    private RecyclerView mRecyclerView;
    private NewsAdapter newsAdapter;
    private ArrayList<NewsResponse.NewsArticle> articleArrayList = new ArrayList<>();
    private NewsViewModel newsViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        init();
    }

    private void init(){
        mRecyclerView = findViewById(R.id.rvNews);

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.init();
        newsViewModel.getNewsRepository().observe(this, newsResponse -> {
            List<NewsResponse.NewsArticle> newsArticles = newsResponse.getArticles();
            articleArrayList.addAll(newsArticles);
            newsAdapter.notifyDataSetChanged();
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = new NewsAdapter(NewsActivity.this, articleArrayList, this);
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
        Toast.makeText(this,articleArrayList.get(position).getAuthor(), Toast.LENGTH_SHORT).show();
    }
}
