package com.luis.curso.retrofit.ockham.cursoretrofit.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luis.curso.retrofit.ockham.cursoretrofit.MainActivity;
import com.luis.curso.retrofit.ockham.cursoretrofit.R;
import com.luis.curso.retrofit.ockham.cursoretrofit.adapter.ArticleRecyclerViewAdapter;
import com.luis.curso.retrofit.ockham.cursoretrofit.response.ArticleData;


public class MangaFragment extends Fragment {

    private static MangaFragment instance;

    private ArticleRecyclerViewAdapter articleAdapter;
    private RecyclerView mangaRecyclerView;
    private View view;

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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        mangaRecyclerView.setLayoutManager(gridLayoutManager);

        return view;
    }

    public void initializeMangaData(ArticleData articleData) {
        articleAdapter = new ArticleRecyclerViewAdapter(getActivity(), articleData);
        mangaRecyclerView.setAdapter(articleAdapter);
    }
}