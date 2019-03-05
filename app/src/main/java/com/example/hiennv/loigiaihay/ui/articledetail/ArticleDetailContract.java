package com.example.hiennv.loigiaihay.ui.articledetail;

import com.example.hiennv.loigiaihay.network.pojo.event.Article;
import com.example.hiennv.loigiaihay.ui.base.BaseView;

public interface ArticleDetailContract {
    interface ArticleDetailView extends BaseView {
        void loadArticleDetailSuccess(Article article);

        void loadArticleDetailError(String message);
    }

    interface ArticleDetailPresenter {
        void loadArticleDetail(int itemId);
    }
}
