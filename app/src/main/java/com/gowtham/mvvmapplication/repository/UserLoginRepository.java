package com.gowtham.mvvmapplication.repository;

import androidx.lifecycle.MutableLiveData;

import com.gowtham.mvvmapplication.pojo.UserListResponse;
import com.gowtham.mvvmapplication.pojo.UserLoginResponse;
import com.gowtham.mvvmapplication.retrofit.ApiService;
import com.gowtham.mvvmapplication.retrofit.RetrofitClient;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginRepository {

    private static UserLoginRepository userLoginRepository;
    private ApiService userLoginApi;

    public static UserLoginRepository getInstance(){
        if (userLoginRepository == null){
            userLoginRepository = new UserLoginRepository();
        }
        return userLoginRepository;
    }

    public UserLoginRepository(){
        userLoginApi = RetrofitClient.createService(ApiService.class);
    }

    public MutableLiveData<UserLoginResponse> getUserList(HashMap keyValue){
        MutableLiveData<UserLoginResponse> userData = new MutableLiveData<>();

        userLoginApi.getLoginResult(keyValue).enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call,
                                   Response<UserLoginResponse> response) {
                if (response.isSuccessful()){
                    userData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                userData.setValue(null);
            }
        });
        return userData;
    }
}
