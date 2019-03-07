package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.callback.ItemBaseEventListener;
import com.example.hiennv.loigiaihay.network.pojo.event.Article;
import com.example.hiennv.loigiaihay.network.pojo.event.BaseEvent;
import com.example.hiennv.loigiaihay.network.pojo.event.SubEvent;
import com.example.hiennv.loigiaihay.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<BaseEvent> baseEvents;
    private ItemBaseEventListener itemBaseEventListener;

    public EventViewAdapter(Context context, List<BaseEvent> baseEvents) {
        this.context = context;
        this.baseEvents = baseEvents;
    }

    public void setItemBaseEventListener(ItemBaseEventListener itemBaseEventListener) {
        this.itemBaseEventListener = itemBaseEventListener;
    }

    private static final int TYPE_ARTICLE = 1;
    private static final int TYPE_SUB_EVENT = 2;
    private static final int TYPE_EVENT_TITLE = 3;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ARTICLE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
            return new ArticleHolder(view);
        } else if (viewType == TYPE_SUB_EVENT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sub_event, parent, false);
            return new SubEventHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (baseEvents.get(position) instanceof Article) {
            ((ArticleHolder) viewHolder).bindArticle((Article) baseEvents.get(position));

        } else if (baseEvents.get(position) instanceof SubEvent) {
            ((SubEventHolder) viewHolder).bindSubEvent((SubEvent) baseEvents.get(position));
        }
        viewHolder.itemView.setOnClickListener(v -> {
                    if (itemBaseEventListener != null) {
                        itemBaseEventListener.doItemBaseClick(baseEvents.get(position));
                    }
                }
        );

    }

    @Override
    public int getItemViewType(int position) {
        if (baseEvents.get(position) instanceof Article) {
            return TYPE_ARTICLE;
        } else {
            return TYPE_SUB_EVENT;
        }
    }

    @Override
    public int getItemCount() {
        return (baseEvents == null) ? 0 : baseEvents.size();
    }

    public class ArticleHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_article)
        ImageView ivArticle;
        @BindView(R.id.tv_article_title)
        TextView tvArticleTitle;
        @BindView(R.id.tv_article_intro_text)
        TextView tvArticleIntroText;

        public ArticleHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindArticle(Article article) {
            CommonUtils.loadImage(context, article.getThumbnail(), ivArticle);
            tvArticleTitle.setText(CommonUtils.subStringByCharacter(article.getTitle(), " "));
            tvArticleIntroText.setText(CommonUtils.subStringByCharacter(article.getIntrotext()," "));
        }
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

    public class TitleHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_event_title)
        TextView tvEventTitle;

        public TitleHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
