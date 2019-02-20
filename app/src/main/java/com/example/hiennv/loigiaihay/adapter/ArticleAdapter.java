package com.example.hiennv.loigiaihay.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolder> {
    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder articleHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ArticleHolder extends RecyclerView.ViewHolder {
        public ArticleHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
