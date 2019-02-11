package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.network.pojo.category.SubItem;
import com.example.hiennv.loigiaihay.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemEventAdapter extends RecyclerView.Adapter<ItemEventAdapter.ItemEventHolder> {
    private Context context;
    private List<SubItem> listChap;

    public ItemEventAdapter(Context context, List<SubItem> listChap) {
        this.context = context;
        this.listChap = listChap;
    }

    @NonNull
    @Override
    public ItemEventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_subject,parent,false);
        return new ItemEventHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemEventHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listChap.size();
    }

    public class ItemEventHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_subject)
        ImageView ivSubject;
        @BindView(R.id.tv_subject)
        TextView tvSubject;
        public ItemEventHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindSubItem(SubItem subItem){
            //CommonUtils.loadImage(context,subItem.get);
        }
    }
}
