package com.example.hendawy.newsapp.Interface;

import com.example.hendawy.newsapp.model.Website;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {
    @GET("v1/sources?language=en")
    Call<Website> getSourcesList();
}
