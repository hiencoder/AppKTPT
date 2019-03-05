package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.callback.ItemMostViewListener;
import com.example.hiennv.loigiaihay.network.pojo.event.MostView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MostViewAdapter extends RecyclerView.Adapter<MostViewAdapter.MostViewHolder> {
    private Context context;
    private List<MostView> mostViews;
    private ItemMostViewListener mostViewListener;

    public MostViewAdapter(Context context, List<MostView> mostViews) {
        this.context = context;
        this.mostViews = mostViews;
    }

    public void setMostViewListener(ItemMostViewListener mostViewListener) {
        this.mostViewListener = mostViewListener;
    }

    @NonNull
    @Override
    public MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mostview, parent, false);
        return new MostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewHolder holder, int position) {
        MostView mostView = mostViews.get(position);
        holder.bindMostView(mostView);
        if (mostViewListener != null) {
            holder.itemView.setOnClickListener(v -> mostViewListener.doItemMostViewClick(mostView.getArticleId()));
        }
    }

    @Override
    public int getItemCount() {
        return (mostViews == null) ? 0 : mostViews.size();
    }

    public class MostViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_most_view_title)
        TextView tvMostViewTitle;

        public MostViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindMostView(MostView mostView) {
            tvMostViewTitle.setText(mostView.getTitle());
        }
    }


}
