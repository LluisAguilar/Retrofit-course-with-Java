package com.luis.curso.retrofit.ockham.cursoretrofit.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luis.curso.retrofit.ockham.cursoretrofit.MainActivity;
import com.luis.curso.retrofit.ockham.cursoretrofit.R;
import com.luis.curso.retrofit.ockham.cursoretrofit.StringUtils;
import com.luis.curso.retrofit.ockham.cursoretrofit.adapter.ArticleRecyclerViewAdapter;
import com.luis.curso.retrofit.ockham.cursoretrofit.response.ArticleData;


public class AnimeFragment extends Fragment implements SearchView.OnQueryTextListener {

    private static AnimeFragment instance;
    private View view;
    private ArticleRecyclerViewAdapter articleAdapter;
    private RecyclerView animeRecyclerView;
    private SearchView animeSearchView;

    private AnimeFragment() {}

    public static AnimeFragment getInstance(){
        if (instance == null){
            instance = new AnimeFragment();
        }
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_anime, container, false);

        animeRecyclerView = view.findViewById(R.id.anime_recycler_view);
        animeSearchView = view.findViewById(R.id.anime_search_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        animeRecyclerView.setLayoutManager(gridLayoutManager);

        animeSearchView.setOnQueryTextListener(this);

        return view;
    }

    public void initializeAnimeData(ArticleData articleData){
        articleAdapter = new ArticleRecyclerViewAdapter(getActivity(), articleData);
        animeRecyclerView.setAdapter(articleAdapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        if (newText != null){
            if (!newText.isEmpty()){
                ((MainActivity) getActivity()).animeFilterSearch(StringUtils.ARTICLES.ANIME,newText);
            }else {
                ((MainActivity) getActivity()).getAnimeArticles();
            }
        }
        return true;
    }
}