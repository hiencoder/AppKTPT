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
import com.example.hiennv.loigiaihay.network.pojo.article.OtherInCat;
import com.example.hiennv.loigiaihay.utils.CommonUtils;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OtherInCatAdapter extends RecyclerView.Adapter<OtherInCatAdapter.OtherInCatHolder> {
    private Context context;
    private List<OtherInCat> articles;
    private ItemArticleListener itemArticleListener;

    public OtherInCatAdapter(Context context, List<OtherInCat> articles) {
        this.context = context;
        this.articles = articles;
    }

    public void setItemArticleListener(ItemArticleListener itemOtherInCatListener) {
        this.itemArticleListener = itemOtherInCatListener;
    }

    @NonNull
    @Override
    public OtherInCatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new OtherInCatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OtherInCatHolder articleHolder, int position) {
        OtherInCat article = articles.get(position);
        articleHolder.bindOtherInCat(article);

        if (itemArticleListener != null) {
            articleHolder.itemView.setOnClickListener(v -> itemArticleListener.doItemArticleClick(article.getArticleId()));
        }
    }

    @Override
    public int getItemCount() {
        return (articles == null) ? 0 : articles.size();
    }

    public class OtherInCatHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_article)
        ImageView ivOtherInCat;
        @BindView(R.id.tv_article_title)
        TextView tvOtherInCatTitle;
        @BindView(R.id.tv_article_intro_text)
        TextView tvOtherInCatIntroText;

        public OtherInCatHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindOtherInCat(OtherInCat article) {
            CommonUtils.loadImage(context, article.getThumbnail(), ivOtherInCat);
            tvOtherInCatTitle.setText(CommonUtils.subStringByCharacter(article.getTitle()," "));
            tvOtherInCatIntroText.setText(CommonUtils.subStringByCharacter(article.getIntrotext()," "));
        }
    }
}
