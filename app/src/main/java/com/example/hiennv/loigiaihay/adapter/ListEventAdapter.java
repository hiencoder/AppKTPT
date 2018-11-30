package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.hiennv.loigiaihay.network.pojo.category.Event;

import java.util.List;

public class ListEventAdapter extends RecyclerView.Adapter<ListEventAdapter.ListEventHolder> {
    private Context context;
    private List<Event> listEvents;

    public ListEventAdapter(Context context, List<Event> listEvents) {
        this.context = context;
        this.listEvents = listEvents;
    }

    @NonNull
    @Override
    public ListEventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListEventHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listEvents.size();
    }

    public class ListEventHolder extends RecyclerView.ViewHolder {
        public ListEventHolder(View itemView) {
            super(itemView);
        }
    }
}
