package com.example.hendawy.newsapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hendawy.newsapp.R;
import com.example.hendawy.newsapp.ViewHolder.ListSourceViewHolder;
import com.example.hendawy.newsapp.model.Website;

public class ListSourceAdapter extends RecyclerView.Adapter<ListSourceViewHolder> {

    private Context context;
    private Website website;

    public ListSourceAdapter(Context context, Website website) {
        this.context = context;
        this.website = website;
    }


    @NonNull
    @Override
    public ListSourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.source_list_item, parent, false);
        return new ListSourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListSourceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
