package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.db.model.Save;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleOfflineAdaper extends RecyclerView.Adapter<ArticleOfflineAdaper.ArticleOfflineHolder> {
    private Context context;
    private List<Save> saves;

    public ArticleOfflineAdaper(Context context, List<Save> saves) {
        this.context = context;
        this.saves = saves;
    }

    @NonNull
    @Override
    public ArticleOfflineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saved_offline, parent, false);
        return new ArticleOfflineHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleOfflineHolder articleOfflineHolder, int position) {
        Save save = saves.get(position);
        articleOfflineHolder.bindArticleOffline(save);
    }

    @Override
    public int getItemCount() {
        return (saves != null) ? saves.size() : 0;
    }

    /**
     * Remove item position
     *
     * @param position
     */
    public void removeItem(int position) {
        saves.remove(position);
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
    public void restoreItem(Save save, int position) {
        saves.add(position, save);
        // notify item added by position
        notifyItemInserted(position);
    }

    public class ArticleOfflineHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_lesson_title)
        TextView tvLessonTitle;
        @BindView(R.id.tv_lesson_intro_text)
        TextView tvLessonIntro;
        @BindView(R.id.view_background)
        RelativeLayout viewBackground;
        @BindView(R.id.view_foreground)
         RelativeLayout viewForeground;

        public ArticleOfflineHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        /**
         * @param save
         */
        public void bindArticleOffline(Save save) {
            tvLessonTitle.setText(save.getSaveName());
            tvLessonIntro.setText(save.getSaveIntro());
        }
    }
}
