package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.callback.ItemSubEventListener;
import com.example.hiennv.loigiaihay.network.pojo.event.SubEvent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubEventAdapter extends RecyclerView.Adapter<SubEventAdapter.SubEventHolder> {
    private Context context;
    private List<SubEvent> subEvents;
    private ItemSubEventListener subEventListener;
    public SubEventAdapter(Context context, List<SubEvent> subEvents) {
        this.context = context;
        this.subEvents = subEvents;
    }

    public void setSubEventListener(ItemSubEventListener subEventListener) {
        this.subEventListener = subEventListener;
    }

    @NonNull
    @Override
    public SubEventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sub_event, parent, false);
        return new SubEventHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubEventHolder holder, int position) {
        SubEvent subEvent = subEvents.get(position);
        holder.bindSubEvent(subEvent);
        if (subEventListener != null){
            holder.itemView.setOnClickListener(v -> subEventListener.doItemSubEventClick(subEvent.getItemId()));
        }
    }

    @Override
    public int getItemCount() {
        return (subEvents == null) ? 0 : subEvents.size();
    }

    public class SubEventHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_sub_event_title)
        TextView tvSubEventTitle;

        public SubEventHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindSubEvent(SubEvent subEvent) {
            tvSubEventTitle.setText(subEvent.getTitle());
        }
    }


}
