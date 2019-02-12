package com.example.hiennv.loigiaihay.ui.changesubject;

import com.example.hiennv.loigiaihay.network.ApiService;
import com.example.hiennv.loigiaihay.network.pojo.subject.SubjectResponse;

import com.example.hiennv.loigiaihay.utils.AppLogger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangeSubjectPresenterImpl implements ChangeSubjectContract.ChangeSubjectPresenter{
    private ChangeSubjectContract.ChangeSubjectView subjectView;
    private ApiService apiService;

    public ChangeSubjectPresenterImpl(ChangeSubjectContract.ChangeSubjectView subjectView, ApiService apiService) {
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
                subjectView.loadListSubjectError(t.getMessage());
            }
        });
    }

    @Override
    public void loadSubjectDetail(int itemId) {
        //Call<>
    }
}
