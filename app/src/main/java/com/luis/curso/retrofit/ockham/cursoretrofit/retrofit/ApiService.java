package com.luis.curso.retrofit.ockham.cursoretrofit.retrofit;

import com.luis.curso.retrofit.ockham.cursoretrofit.response.ArticleData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("anime?page[limit]=20&page[offset]=0")
    Call<ArticleData> getAnimeArticle();

    @GET("manga?page[limit]=20&page[offset]=0")
    Call<ArticleData> getMangaArticle();
}
