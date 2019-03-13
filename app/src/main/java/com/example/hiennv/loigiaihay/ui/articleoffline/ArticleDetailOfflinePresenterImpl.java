package com.example.hiennv.loigiaihay.ui.articleoffline;

import android.content.Context;

import com.example.hiennv.loigiaihay.db.DatabaseHelper;
import com.example.hiennv.loigiaihay.db.model.Save;
import com.example.hiennv.loigiaihay.ui.articledetail.ArticleDetailContract;

public class ArticleDetailOfflinePresenterImpl implements ArticleOfflineContract.ArticlePresenter {
    private ArticleOfflineContract.ArticleOfflineView view;
    private DatabaseHelper databaseHelper;

    public ArticleDetailOfflinePresenterImpl(Context context, ArticleOfflineContract.ArticleOfflineView view) {
        databaseHelper = new DatabaseHelper(context);
        this.view = view;
    }

    @Override
    public void loadArticleDetail(int id) {
        Save save = databaseHelper.getSaveById(id);
        if (save != null) {
            view.loadArticleDetailSuccess(save);
        } else {
            view.loadArticleDetailError();
        }
    }
}
