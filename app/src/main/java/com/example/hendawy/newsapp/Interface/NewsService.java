package com.example.hendawy.newsapp.Interface;

import com.example.hendawy.newsapp.model.Website;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {
    @GET("sources")
    Call<Website> getSourcesList();
}
