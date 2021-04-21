package com.luis.curso.retrofit.ockham.cursoretrofit;

import android.content.Context;
import android.util.Log;

import com.luis.curso.retrofit.ockham.cursoretrofit.response.ArticleData;
import com.luis.curso.retrofit.ockham.cursoretrofit.retrofit.ApiClient;
import com.luis.curso.retrofit.ockham.cursoretrofit.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestHandler {

    private Context context;
    private ApiClient apiClient = ApiClient.getInstance();
    private ApiService apiService = apiClient.getApiService();

    private RequestListener requestListener;

    RequestHandler(Context context, RequestListener requestListener){
        this.context = context;
        this.requestListener = requestListener;
    }

    public void getArticles(StringUtils.ARTICLES articlesType){
        Call<ArticleData> call = apiService.getAnimeArticle();
        if (articlesType == StringUtils.ARTICLES.ANIME){
            call = apiService.getAnimeArticle();
        }else  if (articlesType == StringUtils.ARTICLES.MANGA){
            call = apiService.getMangaArticle();
        }
        call.enqueue(new Callback<ArticleData>() {
            @Override
            public void onResponse(Call<ArticleData> call, Response<ArticleData> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    requestListener.articlesResponse(response.body());
                } else {
                    Log.e("retrofitResponse", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArticleData> call, Throwable t) {
                Log.e("retrofitResponse", t.getMessage());
            }
        });
    }

    public interface RequestListener{
        void articlesResponse(ArticleData articleData);
    }
}
