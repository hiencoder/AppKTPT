package com.example.hiennv.loigiaihay.ui.changeclass;

import com.example.hiennv.loigiaihay.network.ApiClient;
import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.tag.ClassEntity;
import com.example.hiennv.loigiaihay.network.pojo.tag.ResponseTag;
import com.example.hiennv.loigiaihay.utils.AppLogger;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangeClassPresenterImpl implements ChangeClassContract.ChangeClassPresenter {
    private ChangeClassContract.ChangeClassView listClassView;
    private ApiService apiService;

    public ChangeClassPresenterImpl(ChangeClassContract.ChangeClassView listClassView) {
        this.listClassView = listClassView;
        apiService = ApiClient.getClient().create(ApiService.class);
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
