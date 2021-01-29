package com.gowtham.mvvmapplication.repository;

import androidx.lifecycle.MutableLiveData;

import com.gowtham.mvvmapplication.pojo.NewsResponse;
import com.gowtham.mvvmapplication.pojo.UserListResponse;
import com.gowtham.mvvmapplication.retrofit.ApiService;
import com.gowtham.mvvmapplication.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListRepository {

    private static UserListRepository userListRepository;
    private ApiService userListApi;

    public static UserListRepository getInstance(){
        if (userListRepository == null){
            userListRepository = new UserListRepository();
        }
        return userListRepository;
    }

    public UserListRepository(){
        userListApi = RetrofitClient.createService(ApiService.class);
    }

    public MutableLiveData<List<UserListResponse>> getUserList(int key){
        MutableLiveData<List<UserListResponse>> userData = new MutableLiveData<>();
        userListApi.getUserList(key).enqueue(new Callback<List<UserListResponse>>() {
            @Override
            public void onResponse(Call<List<UserListResponse>> call,
                                   Response<List<UserListResponse>> response) {
                if (response.isSuccessful()){
                    userData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<UserListResponse>> call, Throwable t) {
                userData.setValue(null);
            }
        });
        return userData;
    }
}
