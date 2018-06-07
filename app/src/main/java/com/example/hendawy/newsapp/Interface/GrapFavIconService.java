package com.example.hendawy.newsapp.Interface;

import com.example.hendawy.newsapp.model.GrapFavIcon;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface GrapFavIconService {

    @GET("{domain}")
    Call<GrapFavIcon> getIconUrl(@Path("domain") String domain);
}
