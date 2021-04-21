package com.luis.curso.retrofit.ockham.cursoretrofit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luis.curso.retrofit.ockham.cursoretrofit.R;


public class MangaFragment extends Fragment {

    private static MangaFragment instance;

    private MangaFragment() {
    }

    public static MangaFragment getInstance(){
        if (instance == null){
            instance = new MangaFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manga, container, false);
    }
}