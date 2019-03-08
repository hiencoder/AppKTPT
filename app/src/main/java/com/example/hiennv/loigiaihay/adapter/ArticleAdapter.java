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
import com.example.hiennv.loigiaihay.callback.ItemArticleListener;
import com.example.hiennv.loigiaihay.network.pojo.event.Article;
import com.example.hiennv.loigiaihay.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.biubiubiu.justifytext.library.JustifyTextView;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolder> {
    private Context context;
    private List<Article> articles;
    private ItemArticleListener itemArticleListener;

    public ArticleAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    public void setItemArticleListener(ItemArticleListener itemArticleListener) {
        this.itemArticleListener = itemArticleListener;
    }

    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder articleHolder, int position) {
        Article article = articles.get(position);
        articleHolder.bindArticle(article);

        if (itemArticleListener != null) {
            articleHolder.itemView.setOnClickListener(v -> itemArticleListener.doItemArticleClick(article.getArticleId()));
        }
    }

    @Override
    public int getItemCount() {
        return (articles == null) ? 0 : articles.size();
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
            tvArticleTitle.setText(article.getTitle());
            tvArticleIntroText.setText(article.getIntrotext());
        }
    }
}
