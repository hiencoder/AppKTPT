package com.example.hiennv.loigiaihay.ui.listclass.listsubject;

import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.subject.SubjectResponse;
import com.example.hiennv.loigiaihay.utils.AppLogger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSubjectPresenterImpl implements ListSubjectContract.ListSubjectPresenter{
    private ListSubjectContract.ListSubjectView subjectView;
    private ApiService apiService;

    public ListSubjectPresenterImpl(ListSubjectContract.ListSubjectView subjectView, ApiService apiService) {
        this.subjectView = subjectView;
        this.apiService = apiService;
    }

    @Override
    public void loadListSubject(String tagId) {
        Call<SubjectResponse> call = apiService.getListSubjectByTagId(tagId);
        call.enqueue(new Callback<SubjectResponse>() {
            @Override
            public void onResponse(Call<SubjectResponse> call, Response<SubjectResponse> response) {
                SubjectResponse subjectResponse = response.body();
                if (subjectResponse != null){
                    subjectView.loadListSubjectSuccess(subjectResponse);
                }
            }

            @Override
            public void onFailure(Call<SubjectResponse> call, Throwable t) {
                AppLogger.e("Error",t);
            }
        });
    }

    @Override
    public void loadSubjectDetail(int itemId) {
        //Call<>
    }
}
