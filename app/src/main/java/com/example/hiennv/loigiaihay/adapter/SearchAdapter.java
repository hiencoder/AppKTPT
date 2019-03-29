package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.hiennv.loigiaihay.db.model.Search;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {
    private Context context;
    private List<Search> searches;

    public SearchAdapter(Context context, List<Search> searches) {
        this.context = context;
        this.searches = searches;
    }

    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder searchHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return searches.size();
    }

    public class SearchHolder extends RecyclerView.ViewHolder {
        public SearchHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
