package com.example.hiennv.loigiaihay.ui.articledetail;

import com.example.hiennv.loigiaihay.db.model.Save;
import com.example.hiennv.loigiaihay.network.pojo.article.ResponseArticle;
import com.example.hiennv.loigiaihay.ui.base.BaseView;

public interface ArticleDetailContract {
    interface ArticleDetailView extends BaseView {
        void loadArticleDetailSuccess(ResponseArticle responseArticle);

        void loadArticleDetailError(String message);

        void saveLessonSuccess();

        void saveLessonError();
    }

    interface ArticleDetailPresenter {
        void loadArticleDetail(int itemId);

        void saveLesson(Save save);
    }
}
