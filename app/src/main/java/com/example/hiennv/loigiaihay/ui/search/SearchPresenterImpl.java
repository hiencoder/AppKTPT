package com.example.hiennv.loigiaihay.ui.search;

import android.content.Context;

import com.example.hiennv.loigiaihay.db.DatabaseHelper;
import com.example.hiennv.loigiaihay.network.ApiClient;
import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.search.ResponseSearch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenterImpl implements SearchContract.SearchPresenter {
    private ApiService apiService;
    private DatabaseHelper databaseHelper;
    private SearchContract.SearchView searchView;

    public SearchPresenterImpl(Context context, SearchContract.SearchView searchView) {
        this.searchView = searchView;
        databaseHelper = new DatabaseHelper(context);
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    @Override
    public void searchArticle(int limit, int page, String keyword, int catId) {
        searchView.showLoading();
        Call<ResponseSearch> call = apiService.getSearch(limit, page, keyword, catId);
        call.enqueue(new Callback<ResponseSearch>() {
            @Override
            public void onResponse(Call<ResponseSearch> call, Response<ResponseSearch> response) {
                ResponseSearch responseSearch = response.body();
                if (responseSearch != null) {
                    searchView.hideLoading();
                    searchView.searchArticleSuccess(responseSearch.getArticleSearchList());
                }else {
                    searchView.hideLoading();
                    searchView.searchArticleError();
                }
            }

            @Override
            public void onFailure(Call<ResponseSearch> call, Throwable t) {
                searchView.hideLoading();
                searchView.searchArticleError();
            }
        });
    }
}
