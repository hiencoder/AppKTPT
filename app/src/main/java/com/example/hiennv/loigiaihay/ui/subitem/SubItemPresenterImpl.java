package com.example.hiennv.loigiaihay.ui.subitem;

import com.example.hiennv.loigiaihay.network.ApiClient;
import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.event.ResponseEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubItemPresenterImpl implements SubItemContract.SubItemPresenter {
    private SubItemContract.SubItemView subItemView;
    private ApiService apiService;

    public SubItemPresenterImpl(SubItemContract.SubItemView subItemView) {
        this.subItemView = subItemView;
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    @Override
    public void loadSubItem(int itemId) {
        subItemView.showLoading();
        Call<ResponseEvent> call = apiService.getResponseEventByItemId(itemId);
        call.enqueue(new Callback<ResponseEvent>() {
            @Override
            public void onResponse(Call<ResponseEvent> call, Response<ResponseEvent> response) {
                ResponseEvent responseEvent = response.body();
                if (responseEvent != null) {
                    subItemView.hideLoading();
                    subItemView.loadSubItemSuccess(responseEvent);
                }
            }

            @Override
            public void onFailure(Call<ResponseEvent> call, Throwable t) {
                subItemView.hideLoading();
                subItemView.loadSubItemError(t.getMessage());
            }
        });
    }
}
