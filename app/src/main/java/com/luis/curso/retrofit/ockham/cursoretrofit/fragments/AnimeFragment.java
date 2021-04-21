package com.luis.curso.retrofit.ockham.cursoretrofit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luis.curso.retrofit.ockham.cursoretrofit.R;


public class AnimeFragment extends Fragment {

    private static AnimeFragment instance;

    private AnimeFragment() {

    }

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
        return inflater.inflate(R.layout.fragment_anime, container, false);
    }
}