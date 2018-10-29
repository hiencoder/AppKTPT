package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.callback.ItemClassListener;
import com.example.hiennv.loigiaihay.network.pojo.tag.ClassEntity;
import com.example.hiennv.loigiaihay.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListClassAdapter extends RecyclerView.Adapter<ListClassAdapter.ListClassHolder>{
    private Context context;
    private List<ClassEntity> listClass;
    private ItemClassListener itemClassListener;
    public ListClassAdapter(Context context, List<ClassEntity> listClass, ItemClassListener itemClassListener) {
        this.context = context;
        this.listClass = listClass;
        this.itemClassListener = itemClassListener;
    }

    @NonNull
    @Override
    public ListClassHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class,parent,false);
        return new ListClassHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListClassHolder holder, int position) {
        ClassEntity classEntity = listClass.get(position);
        holder.bindClass(classEntity);
        holder.itemView.setOnClickListener(v -> {
            itemClassListener.classClick(classEntity);
        });
    }

    @Override
    public int getItemCount() {
        return listClass.size();
    }

    public class ListClassHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_class)
        ImageView ivClass;
        @BindView(R.id.tv_class)
        TextView tvClass;
        public ListClassHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindClass(ClassEntity classEntity){
            CommonUtils.loadImage(context,classEntity.getPicture(),ivClass);
            tvClass.setText(classEntity.getTitle());
        }
    }
}
