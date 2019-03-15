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
import com.example.hiennv.loigiaihay.callback.ItemArticleListener;
import com.example.hiennv.loigiaihay.callback.ItemArticleOfflineListener;
import com.example.hiennv.loigiaihay.db.model.History;
import com.example.hiennv.loigiaihay.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {
    private Context context;
    private List<History> histories;
    private ItemArticleListener listener;

    public HistoryAdapter(Context context, List<History> histories) {
        this.context = context;
        this.histories = histories;
    }

    public void setListener(ItemArticleListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder historyHolder, int position) {
        History history = histories.get(position);
        historyHolder.bindHistory(history);
        if (listener != null) {
            historyHolder.itemView.setOnClickListener(v -> listener.doItemArticleClick(Integer.parseInt(history.getHistoryArticleId())));
        }
    }

    @Override
    public int getItemCount() {
        return (histories != null) ? histories.size() : 0;
    }

    /**
     * Remove item position
     *
     * @param position
     */
    public void removeItem(int position) {
        histories.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

    /**
     * Restore item
     *
     * @param save
     * @param position
     */
    public void restoreItem(History save, int position) {
        histories.add(position, save);
        // notify item added by position
        notifyItemInserted(position);
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_article_title)
        TextView tvLessonTitle;
        @BindView(R.id.tv_article_intro_text)
        TextView tvLessonIntro;
        @BindView(R.id.iv_article)
        ImageView ivArticle;

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        /**
         * @param history
         */
        public void bindHistory(History history) {
            tvLessonTitle.setText(history.getHistoryName());
            tvLessonIntro.setText(history.getHistoryIntro());
            CommonUtils.loadImage(context, history.getHistoryAvatar(), ivArticle);
        }
    }
}
