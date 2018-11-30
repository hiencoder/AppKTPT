package com.example.hiennv.loigiaihay.ui.home;

import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.category.ResponseCateGory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl implements MainContract.MainPresenter{
    private MainContract.MainView mainView;
    private ApiService apiService;
    public MainPresenterImpl(MainContract.MainView mainView, ApiService apiService) {
        this.mainView = mainView;
        this.apiService = apiService;
    }

    @Override
    public void loadListSession(String subjectId) {
        Call<ResponseCateGory> call = apiService.getResponseCategory(subjectId);
        call.enqueue(new Callback<ResponseCateGory>() {
            @Override
            public void onResponse(Call<ResponseCateGory> call, Response<ResponseCateGory> response) {

            }

            @Override
            public void onFailure(Call<ResponseCateGory> call, Throwable t) {

            }
        });
    }
}
