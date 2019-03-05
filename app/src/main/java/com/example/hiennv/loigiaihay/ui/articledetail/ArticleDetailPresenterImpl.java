package com.example.hiennv.loigiaihay.ui.articledetail;

import com.example.hiennv.loigiaihay.network.ApiClient;
import com.example.hiennv.loigiaihay.network.ApiService;

public class ArticleDetailPresenterImpl implements ArticleDetailContract.ArticleDetailPresenter {
    private ArticleDetailContract.ArticleDetailView view;
    private ApiService apiService;

    public ArticleDetailPresenterImpl(ArticleDetailContract.ArticleDetailView view) {
        this.view = view;
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    @Override
    public void loadArticleDetail(int itemId) {
        view.showLoading();

    }
}
