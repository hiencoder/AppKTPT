package com.example.hiennv.loigiaihay.network;

import com.example.hiennv.loigiaihay.network.pojo.article.ResponseArticle;
import com.example.hiennv.loigiaihay.network.pojo.category.ResponseCategory;
import com.example.hiennv.loigiaihay.network.pojo.event.ResponseEvent;
import com.example.hiennv.loigiaihay.network.pojo.subject.SubjectResponse;
import com.example.hiennv.loigiaihay.network.pojo.tag.ResponseTag;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    //Get list class ()
    @GET("tags")
    Call<ResponseTag> getListClass();

    //Get list subject
    @GET("tags/{tagId}")
    Call<SubjectResponse> getListSubjectByTagId(@Path("tagId") String tagId);

    //Get list Events()
    @GET("categories/{subjectId}")
    Call<ResponseCategory> getResponseCategory(@Path("subjectId") int subjectId);

    //Get list article
    @GET("events/{itemId}")
    Call<ResponseEvent> getResponseEventByItemId(@Path("itemId") int itemId);

    //Get ArticleDetail by articleId
    @GET("articles/{articleId}")
    Call<ResponseArticle> getArticleByArticleId(@Path("articleId") int articleId);

    //Search article

}
