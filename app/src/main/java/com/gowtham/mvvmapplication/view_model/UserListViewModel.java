package com.gowtham.mvvmapplication.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gowtham.mvvmapplication.pojo.NewsResponse;
import com.gowtham.mvvmapplication.pojo.UserListResponse;
import com.gowtham.mvvmapplication.repository.NewsRepository;
import com.gowtham.mvvmapplication.repository.UserListRepository;

import java.util.List;

public class UserListViewModel extends ViewModel {

    private MutableLiveData<List<UserListResponse>> mutableLiveData;
    private UserListRepository userListRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        userListRepository = UserListRepository.getInstance();
        mutableLiveData = userListRepository.getUserList(1);
    }

    public LiveData<List<UserListResponse>> getUserListRepository(){
        return mutableLiveData;
    }
}
