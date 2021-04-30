package com.luis.curso.retrofit.ockham.cursoretrofit.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luis.curso.retrofit.ockham.cursoretrofit.MainActivity;
import com.luis.curso.retrofit.ockham.cursoretrofit.R;
import com.luis.curso.retrofit.ockham.cursoretrofit.StringUtils;
import com.luis.curso.retrofit.ockham.cursoretrofit.adapter.ArticleRecyclerViewAdapter;
import com.luis.curso.retrofit.ockham.cursoretrofit.response.ArticleData;


public class MangaFragment extends Fragment implements SearchView.OnQueryTextListener {

    private static MangaFragment instance;

    private ArticleRecyclerViewAdapter articleAdapter;
    private RecyclerView mangaRecyclerView;
    private View view;
    private SearchView mangaSearchView;

    private MangaFragment() {
    }

    public static MangaFragment getInstance(){
        if (instance == null){
            instance = new MangaFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainActivity)getActivity()).callMangaData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_manga, container, false);

        mangaRecyclerView = view.findViewById(R.id.manga_recycler_view);
        mangaSearchView = view.findViewById(R.id.manga_search_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        mangaRecyclerView.setLayoutManager(gridLayoutManager);

        mangaSearchView.setOnQueryTextListener(this);

        return view;
    }

    public void initializeMangaData(ArticleData articleData) {
        articleAdapter = new ArticleRecyclerViewAdapter(getActivity(), articleData);
        mangaRecyclerView.setAdapter(articleAdapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText != null){
            if (!newText.isEmpty()){
                ((MainActivity) getActivity()).animeFilterSearch(StringUtils.ARTICLES.MANGA,newText);
            }else {
                ((MainActivity) getActivity()).getMangaArticles();
            }
        }
        return true;
    }
}