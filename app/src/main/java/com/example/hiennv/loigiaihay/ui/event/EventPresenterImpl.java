package com.example.hiennv.loigiaihay.ui.event;

import com.example.hiennv.loigiaihay.network.ApiClient;
import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.event.ResponseEvent;
import com.example.hiennv.loigiaihay.utils.AppLogger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventPresenterImpl implements EventContract.EventPresenter {
    private EventContract.EventView eventView;
    private ApiService apiService;

    public EventPresenterImpl(EventContract.EventView eventView) {
        this.eventView = eventView;
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    @Override
    public void loadEvent(int itemId) {
        eventView.showLoading();
        Call<ResponseEvent> call = apiService.getResponseEventByItemId(itemId);
        call.enqueue(new Callback<ResponseEvent>() {
            @Override
            public void onResponse(Call<ResponseEvent> call, Response<ResponseEvent> response) {
                ResponseEvent responseEvent = response.body();
                if (responseEvent != null) {
                    eventView.hideLoading();
                    eventView.loadEventSuccess(responseEvent);
                }
            }

            @Override
            public void onFailure(Call<ResponseEvent> call, Throwable t) {
                eventView.hideLoading();
                AppLogger.d("Error", t.getMessage());
            }
        });
    }
}
