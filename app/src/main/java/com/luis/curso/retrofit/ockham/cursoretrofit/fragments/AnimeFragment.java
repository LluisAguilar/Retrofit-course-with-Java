package com.luis.curso.retrofit.ockham.cursoretrofit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luis.curso.retrofit.ockham.cursoretrofit.R;
import com.luis.curso.retrofit.ockham.cursoretrofit.adapter.ArticleRecyclerViewAdapter;
import com.luis.curso.retrofit.ockham.cursoretrofit.response.ArticleData;


public class AnimeFragment extends Fragment {

    private static AnimeFragment instance;
    private View view;
    private ArticleRecyclerViewAdapter articleAdapter;
    private RecyclerView animeRecyclerView;

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        animeRecyclerView.setLayoutManager(gridLayoutManager);

        return view;
    }

    public void initializeAnimeData(ArticleData articleData){
        articleAdapter = new ArticleRecyclerViewAdapter(getActivity(), articleData);
        animeRecyclerView.setAdapter(articleAdapter);
    }
}