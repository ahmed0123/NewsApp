package com.example.hendawy.newsapp.Activity;

import android.app.AlertDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hendawy.newsapp.Adapter.ListSourceAdapter;
import com.example.hendawy.newsapp.Interface.NewsService;
import com.example.hendawy.newsapp.R;
import com.example.hendawy.newsapp.Utils.Constants;
import com.example.hendawy.newsapp.model.Website;
import com.google.gson.Gson;

import dmax.dialog.SpotsDialog;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView listWebsite;
    RecyclerView.LayoutManager layoutManager;
    NewsService newsService;
    ListSourceAdapter listSourceAdapter;
    AlertDialog alertDialog;
    SwipeRefreshLayout  swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paper.init(this);

        newsService = Constants.getNewsService();

        //inti views
        swipeLayout = findViewById(R.id.swipe);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadWebsiteSource(true);
            }
        });
        listWebsite = findViewById(R.id.list_source);
        listWebsite.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(this);
        listWebsite.setLayoutManager(layoutManager);

        alertDialog = new SpotsDialog(this);

        loadWebsiteSource(false);
    }

    private void loadWebsiteSource(boolean isRefreshed) {
        if (!isRefreshed){

            String cache = Paper.book().read("cache");
            if (cache !=null && !cache.isEmpty()){
                Website website = new Gson().fromJson(cache,Website.class);
                listSourceAdapter = new ListSourceAdapter(getBaseContext(),website);
                listSourceAdapter.notifyDataSetChanged();
                listWebsite.setAdapter(listSourceAdapter);
            }
            else
            {
                alertDialog.show();

                newsService.getSourcesList().enqueue(new Callback<Website>() {
                    @Override
                    public void onResponse(Call<Website> call, Response<Website> response) {
                        listSourceAdapter = new ListSourceAdapter(getBaseContext(),response.body());
                        listSourceAdapter.notifyDataSetChanged();
                        listWebsite.setAdapter(listSourceAdapter);

                        Paper.book().write("cache",new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<Website> call, Throwable t) {

                    }
                });
            }
        }
        else //if from swipe to refresh
            {
                alertDialog.show();

                newsService.getSourcesList().enqueue(new Callback<Website>() {
                    @Override
                    public void onResponse(Call<Website> call, Response<Website> response) {
                        listSourceAdapter = new ListSourceAdapter(getBaseContext(),response.body());
                        listSourceAdapter.notifyDataSetChanged();
                        listWebsite.setAdapter(listSourceAdapter);

                        Paper.book().write("cache",new Gson().toJson(response.body()));

                        swipeLayout.setRefreshing(false);
                    }

                    @Override
                    public void onFailure(Call<Website> call, Throwable t) {

                    }
                });
        }
    }
}
