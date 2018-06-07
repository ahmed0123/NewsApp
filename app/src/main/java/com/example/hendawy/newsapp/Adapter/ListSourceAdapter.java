package com.example.hendawy.newsapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hendawy.newsapp.Interface.GrapFavIconService;
import com.example.hendawy.newsapp.Interface.ItemClickListener;
import com.example.hendawy.newsapp.R;
import com.example.hendawy.newsapp.Utils.Constants;
import com.example.hendawy.newsapp.ViewHolder.ListSourceViewHolder;
import com.example.hendawy.newsapp.model.GrapFavIcon;
import com.example.hendawy.newsapp.model.Icons;
import com.example.hendawy.newsapp.model.Website;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSourceAdapter extends RecyclerView.Adapter<ListSourceViewHolder> {

    private Context context;
    private Website website;
     String finalDomain = "";

    private GrapFavIconService mService;

    public ListSourceAdapter(Context context, Website website) {
        this.context = context;
        this.website = website;

        mService = Constants.getIconService();
    }


    @NonNull
    @Override
    public ListSourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.source_list_item, parent, false);
        return new ListSourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListSourceViewHolder holder, int position) {


        String urlWithoutProtocol = RemoveProtocol(website.getSources().get(position).getUrl());

        if (urlWithoutProtocol.contains("/")) {
            finalDomain = extractDomain(urlWithoutProtocol);
        }else {
            finalDomain = urlWithoutProtocol;
        }
        mService.getIconUrl(finalDomain).enqueue(new Callback<GrapFavIcon>() {
            @Override
            public void onResponse(Call<GrapFavIcon> call, Response<GrapFavIcon> response) {
               List<Icons> icons =  response.body().getIcons();
                if (response.body().getIcons().size() > 0) {
                    Picasso.get().load(response.body().getIcons().get(0).getSrc())
                            .into(holder.sourceImage);
                }
            }

            @Override
            public void onFailure(Call<GrapFavIcon> call, Throwable t) {

            }
        });

        holder.sourceTitle.setText(website.getSources().get(position).getName());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
            }
        });
    }

    private String extractDomain(String urlWithoutProtocol) {
        String[] parts = urlWithoutProtocol.split("/");
        return parts[0];
    }

    @Override
    public int getItemCount() {
        return website.getSources().size();
    }

    public String RemoveProtocol(String url) {
        String urlWithoutProtocol = "";
        if (url.startsWith("http://")) {
            urlWithoutProtocol = url.replace("http://", "");
        } else if (url.startsWith("https://")) {
            urlWithoutProtocol = url.replace("https://", "");
        }

        return getDomain(urlWithoutProtocol);
    }

    public String getDomain(String urlWithoutProtocol) {
        String domain = "";
        if (urlWithoutProtocol.contains("www.")) {
            domain = urlWithoutProtocol.replace("www.", "");
        }
        return domain;
    }
}
