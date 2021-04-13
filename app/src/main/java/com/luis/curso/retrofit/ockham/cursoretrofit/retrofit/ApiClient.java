package com.luis.curso.retrofit.ockham.cursoretrofit.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient instance = null;
    private final Retrofit retrofitClient;
    private final ApiService apiService;

    private ApiClient(){

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder
                .addInterceptor(new ApiInterceptor())
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .callTimeout(30, TimeUnit.SECONDS);

        OkHttpClient okHttpClient = okHttpBuilder.build();

        retrofitClient = new Retrofit.Builder()
                .baseUrl("https://kitsu.io/api/edge/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        apiService = retrofitClient.create(ApiService.class);
    }

    public static ApiClient getInstance(){
        if (instance == null){
            instance = new ApiClient();
        }
        return instance;
    }

    public ApiService getApiService(){
        return apiService;
    }

}
