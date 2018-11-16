package com.example.hiennv.loigiaihay.network;

import com.example.hiennv.loigiaihay.network.pojo.category.ResponseCateGory;
import com.example.hiennv.loigiaihay.network.pojo.subject.SubjectResponse;
import com.example.hiennv.loigiaihay.network.pojo.tag.ResponseTag;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    //Get list class
    @GET("tags")
    Call<ResponseTag> getListClass();

    //Get list subject
    @GET("tags/{tagId}")
    Call<SubjectResponse> getListSubjectByTagId(@Path("tagId") String tagId);

    //Get list Events()
    @GET("categories/{subjectId}")
    Call<ResponseCateGory> getResponseCategory(@Path("subjectId") String subjectId);



}
