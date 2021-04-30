package com.luis.curso.retrofit.ockham.cursoretrofit;

import com.luis.curso.retrofit.ockham.cursoretrofit.response.Titles;

public class MethodUtils {

    public static String getTitle(Titles titles){
        String title = "No title found";

        if (titles.getEnUs() != null){
            title = titles.getEnUs();
        } else if (titles.getEn() != null){
            title = titles.getEn();
        } else if (titles != null){
            title = titles.getEnJp();
        }

        if (title.isEmpty()){
            title = "No title found";
        }

        return title;
    }
}
