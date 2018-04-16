package com.example.hendawy.newsapp.Utils;

import com.example.hendawy.newsapp.Interface.NewsService;
import com.example.hendawy.newsapp.Rest.ApiClient;

public class Constants {
    public static final String URL = "https://newsapi.org/v2/";

    public static final String API_KEY = "374a05cab3f24e66b96b06913bd73198";

    public static NewsService getNewsService() {
        return ApiClient.getClient(URL).create(NewsService.class);
    }
}
