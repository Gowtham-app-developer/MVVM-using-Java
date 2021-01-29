package com.gowtham.mvvmapplication.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gowtham.mvvmapplication.pojo.NewsResponse;
import com.gowtham.mvvmapplication.pojo.UserLoginResponse;
import com.gowtham.mvvmapplication.repository.NewsRepository;
import com.gowtham.mvvmapplication.repository.UserListRepository;
import com.gowtham.mvvmapplication.repository.UserLoginRepository;

import java.util.HashMap;


public class UserLoginViewModel extends ViewModel {

    private MutableLiveData<UserLoginResponse> mutableLiveData;
    private UserLoginRepository newsRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = UserLoginRepository.getInstance();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("title", "foo");
        hashMap.put("body", "bar");
        hashMap.put("userId", 1);
        mutableLiveData = newsRepository.getUserList(hashMap);

    }

    public LiveData<UserLoginResponse> getNewsRepository() {
        return mutableLiveData;
    }


}
