package com.example.hiennv.loigiaihay.ui.home;

import com.example.hiennv.loigiaihay.network.ApiClient;
import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.category.ResponseCategory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl implements MainContract.MainPresenter {
    private MainContract.MainView mainView;
    private ApiService apiService;

    public MainPresenterImpl(MainContract.MainView mainView) {
        this.mainView = mainView;
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    @Override
    public void loadListSession(int subjectId) {
        mainView.showLoading();
        Call<ResponseCategory> call = apiService.getResponseCategory(subjectId);
        call.enqueue(new Callback<ResponseCategory>() {
            @Override
            public void onResponse(Call<ResponseCategory> call, Response<ResponseCategory> response) {
                ResponseCategory responseCategory = response.body();
                if (responseCategory != null) {
                    mainView.hideLoading();
                    mainView.loadListSessionSuccess(responseCategory.getListEvents());
                }
            }

            @Override
            public void onFailure(Call<ResponseCategory> call, Throwable t) {
                mainView.hideLoading();
                mainView.loadListSessionError(t.getMessage());
            }
        });
    }
}
