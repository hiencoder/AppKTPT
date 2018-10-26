package com.example.hiennv.loigiaihay.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailHolder>{
    @NonNull
    @Override
    public DetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DetailHolder extends RecyclerView.ViewHolder {
        public DetailHolder(View itemView) {
            super(itemView);
        }
    }
}
