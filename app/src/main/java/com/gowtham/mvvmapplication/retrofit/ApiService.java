package com.gowtham.mvvmapplication.retrofit;

import com.gowtham.mvvmapplication.pojo.NewsResponse;
import com.gowtham.mvvmapplication.pojo.UserListResponse;
import com.gowtham.mvvmapplication.pojo.UserLoginResponse;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {


    @GET("top-headlines")
    Call<NewsResponse> getNewsList(@Query("sources") String newsSource,
                                   @Query("apiKey") String apiKey);

    @GET("comments")
    Call<List<UserListResponse>> getUserList(@Query("postId") int postID);

    @Headers("Content-Type: application/json")
    @POST("posts")
    Call<UserLoginResponse> getLoginResult(@Body HashMap<String, Object> body);

}
