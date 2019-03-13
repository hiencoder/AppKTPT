package com.example.hiennv.loigiaihay.ui.articleoffline;

import com.example.hiennv.loigiaihay.db.model.Save;

public interface ArticleOfflineContract {
    interface ArticleOfflineView {
        void loadArticleDetailSuccess(Save save);

        void loadArticleDetailError();
    }

    interface ArticlePresenter {
        void loadArticleDetail(int id);
    }
}
