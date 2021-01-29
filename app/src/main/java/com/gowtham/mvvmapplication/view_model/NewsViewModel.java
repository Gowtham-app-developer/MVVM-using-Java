package com.gowtham.mvvmapplication.view_model;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gowtham.mvvmapplication.pojo.NewsResponse;
import com.gowtham.mvvmapplication.repository.NewsRepository;

import java.util.List;


public class NewsViewModel extends ViewModel {

    private MutableLiveData<NewsResponse> mutableLiveData;
    private NewsRepository newsRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNews("google-news", "4fa7ba164afd425392caeece79eefeb1");

    }

    public LiveData<NewsResponse> getNewsRepository() {
        return mutableLiveData;
    }


}
