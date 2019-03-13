package com.example.hiennv.loigiaihay.ui.articledetail;

import android.content.Context;

import com.example.hiennv.loigiaihay.db.DatabaseHelper;
import com.example.hiennv.loigiaihay.db.model.Save;
import com.example.hiennv.loigiaihay.network.ApiClient;
import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.article.ResponseArticle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleDetailPresenterImpl implements ArticleDetailContract.ArticleDetailPresenter {
    private ArticleDetailContract.ArticleDetailView view;
    private ApiService apiService;
    private DatabaseHelper databaseHelper;

    public ArticleDetailPresenterImpl(Context context, ArticleDetailContract.ArticleDetailView view) {
        this.view = view;
        apiService = ApiClient.getClient().create(ApiService.class);
        databaseHelper = new DatabaseHelper(context);
    }

    @Override
    public void loadArticleDetail(int itemId) {
        view.showLoading();
        Call<ResponseArticle> call = apiService.getArticleByArticleId(itemId);
        call.enqueue(new Callback<ResponseArticle>() {
            @Override
            public void onResponse(Call<ResponseArticle> call, Response<ResponseArticle> response) {
                ResponseArticle responseArticle = response.body();
                if (responseArticle != null) {
                    view.loadArticleDetailSuccess(responseArticle);
                }
            }

            @Override
            public void onFailure(Call<ResponseArticle> call, Throwable t) {
                view.hideLoading();
                view.loadArticleDetailError(t.getMessage());
            }
        });
    }

    @Override
    public void saveLesson(Save save) {
        if (databaseHelper.insertSave(save)) {
            view.saveLessonSuccess();
        } else {
            view.saveLessonError();
        }
    }

    @Override
    public void checkLessonDownloaded(String articleId) {
        if (databaseHelper.checkLessonDownload(articleId)) {
            view.lessonDownloaded(true);
        } else {
            view.lessonDownloaded(false);
        }
    }

    @Override
    public void checkHistory(String articleId) {
        boolean value = databaseHelper.checkHistoryByArticleId(articleId);
        view.checkHistory(value);
    }
}
