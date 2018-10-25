package com.example.hiennv.loigiaihay.ui.listclass;

import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.tag.ClassEntity;
import com.example.hiennv.loigiaihay.network.pojo.tag.ResponseTag;
import com.example.hiennv.loigiaihay.utils.AppLogger;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListClassPresenterImpl implements ListClassContract.ListClassPresenter {
    private ListClassContract.ListClassView listClassView;
    private ApiService apiService;

    public ListClassPresenterImpl(ListClassContract.ListClassView listClassView, ApiService apiService) {
        this.listClassView = listClassView;
        this.apiService = apiService;
    }

    @Override
    public void loadListClass() {
        listClassView.showLoading();
        Call<ResponseTag> call = apiService.getListClass();
        call.enqueue(new Callback<ResponseTag>() {
            @Override
            public void onResponse(Call<ResponseTag> call, Response<ResponseTag> response) {
                if (response != null && response.body() != null) {
                    listClassView.hideLoading();
                    ResponseTag responseTag = response.body();
                    List<ClassEntity> list = responseTag.getListClass();
                    if (list != null && list.size() > 0) {
                        AppLogger.d("SizeClass",list.size() + "");
                        listClassView.loadSuccess(list);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseTag> call, Throwable t) {
                AppLogger.e(t, "Error", t);
            }
        });
    }
}
