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
import com.example.hiennv.loigiaihay.callback.ItemSubjectListener;
import com.example.hiennv.loigiaihay.network.pojo.subject.Subject;
import com.example.hiennv.loigiaihay.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {
    private Context context;
    private List<Subject> subjects;
    private ItemSubjectListener itemSubjectListener;

    public BookAdapter(Context context, List<Subject> subjects, ItemSubjectListener itemSubjectListener) {
        this.context = context;
        this.subjects = subjects;
        this.itemSubjectListener = itemSubjectListener;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subject, parent, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        Subject subject = subjects.get(position);
        holder.bindSubject(subject);
        itemSubjectListener.subjectClick(subject);
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_subject)
        ImageView ivSubject;
        @BindView(R.id.tv_subject)
        TextView tvSubject;

        public BookHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindSubject(Subject subject){
            CommonUtils.loadImage(context,subject.getPicture(),ivSubject);
            tvSubject.setText(subject.getTitle());
        }
    }


}
