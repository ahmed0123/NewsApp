package com.example.hendawy.newsapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hendawy.newsapp.Interface.ItemClickListener;
import com.example.hendawy.newsapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListSourceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ItemClickListener itemClickListener;

    TextView sourceTitle;
    CircleImageView sourceImage;

    public ListSourceViewHolder(View itemView) {
        super(itemView);
        sourceTitle = itemView.findViewById(R.id.source_title);
        sourceImage = itemView.findViewById(R.id.source_image);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }
}
