package com.example.hendawy.newsapp.Utils;

import com.example.hendawy.newsapp.Interface.GrapFavIconService;
import com.example.hendawy.newsapp.Interface.NewsService;
import com.example.hendawy.newsapp.Rest.GrapFavIconClient;
import com.example.hendawy.newsapp.Rest.RetrofitClient;

public class Constants {

    public static final String NEWS_API_URL = "https://newsapi.org/";

    public static final String API_KEY = "374a05cab3f24e66b96b06913bd73198";

    public static NewsService getNewsService() {
        return RetrofitClient.getClient(NEWS_API_URL).create(NewsService.class);
    }

    public static GrapFavIconService getIconService() {
        return GrapFavIconClient.getClient().create(GrapFavIconService.class);
    }
}
