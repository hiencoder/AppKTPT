package com.example.hiennv.loigiaihay.network.pojo.search;

import com.example.hiennv.loigiaihay.network.pojo.event.Article;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleSearch extends Article{
    @Expose
    @SerializedName("picture")
    private String picture;

    public String getPicture() {
        return picture;
    }
}
