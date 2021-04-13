package com.luis.curso.retrofit.ockham.cursoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.luis.curso.retrofit.ockham.cursoretrofit.response.ArticleData;
import com.luis.curso.retrofit.ockham.cursoretrofit.retrofit.ApiClient;
import com.luis.curso.retrofit.ockham.cursoretrofit.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private ApiClient apiClient = ApiClient.getInstance();
    private ApiService apiService = apiClient.getApiService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<ArticleData> call = apiService.getAnimeArticle();
        call.enqueue(new Callback<ArticleData>() {
            @Override
            public void onResponse(Call<ArticleData> call, Response<ArticleData> response) {
                if (response.isSuccessful() && response.code()==200){
                    for (int x = 0; x<response.body().getData().size();x++) {
                        Log.e("retrofitResponse", response.body().getData().get(x).getId());
                    }
                }else {
                    Log.e("retrofitResponse", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArticleData> call, Throwable t) {
                Log.e("retrofitResponse", t.getMessage());
            }
        });

    }
}