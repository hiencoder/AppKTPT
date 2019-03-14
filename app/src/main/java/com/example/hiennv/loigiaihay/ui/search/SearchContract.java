package com.example.hiennv.loigiaihay.ui.search;

import com.example.hiennv.loigiaihay.network.pojo.search.ArticleSearch;
import com.example.hiennv.loigiaihay.ui.base.BaseView;

import java.util.List;

public interface SearchContract {
    interface SearchView extends BaseView {
        void searchArticleSuccess(List<ArticleSearch> articleSearches);

        void searchArticleError();
    }

    interface SearchPresenter {
        void searchArticle(int limit, int page, String keyword, int catId);
    }
}
