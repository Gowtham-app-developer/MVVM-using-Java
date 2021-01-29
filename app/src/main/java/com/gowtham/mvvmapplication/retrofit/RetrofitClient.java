package com.gowtham.mvvmapplication.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    //public static final String BASE_URL = "https://newsapi.org/v2/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
