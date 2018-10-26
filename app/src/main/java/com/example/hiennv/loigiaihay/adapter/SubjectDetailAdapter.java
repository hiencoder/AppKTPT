package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.network.pojo.category.Event;
import com.example.hiennv.loigiaihay.network.pojo.category.SubItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubjectDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Event> events;
    private final int TYPE_HEADER = 1;
    private final int TYPE_DETAIL = 2;

    public SubjectDetailAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_subject_detail,parent,false);
                return new SubjectHeaderHolder(view);

            case 2:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_subject_detail,parent,false);
                return new SubjectDetailHolder(view1);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case TYPE_HEADER:
                SubjectHeaderHolder headerHolder = (SubjectHeaderHolder) holder;
                headerHolder.bindHeader(events.get(position));
                break;
            case TYPE_DETAIL:
                SubjectDetailHolder detailHolder = (SubjectDetailHolder) holder;
                detailHolder.bindDetail(events.get(position).getSubItems().get(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (events.get(position).getTitle() != null) {
            return TYPE_HEADER;

        } else {
            return TYPE_DETAIL;
        }

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class SubjectHeaderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_header_subject)
        TextView tvHeader;
        public SubjectHeaderHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindHeader(Event event){
            tvHeader.setText(event.getTitle());
        }
    }

    public class SubjectDetailHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_subject_title)
        TextView tvSubjectTitle;
        public SubjectDetailHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindDetail(SubItem subItem){
            tvSubjectTitle.setText(subItem.getTitle());
        }
    }
}
