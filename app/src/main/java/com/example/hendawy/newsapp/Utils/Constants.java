package com.example.hendawy.newsapp.Utils;

import com.example.hendawy.newsapp.Interface.IconBetterIdeaService;
import com.example.hendawy.newsapp.Interface.NewsService;
import com.example.hendawy.newsapp.Rest.IconBetterIdeaClient;
import com.example.hendawy.newsapp.Rest.NewsApiClient;

public class Constants {

    public static final String NEWS_API_URL = "https://newsapi.org/v2/";
    public static final String ICON_BETTER_IDEA_URL = "https://icons.better-idea.org/";

    public static final String API_KEY = "374a05cab3f24e66b96b06913bd73198";

    public static NewsService getNewsService() {
        return NewsApiClient.getClient(NEWS_API_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService() {
        return IconBetterIdeaClient.getClient(NEWS_API_URL).create(IconBetterIdeaService.class);
    }
}
