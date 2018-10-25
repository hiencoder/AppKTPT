package com.example.hiennv.loigiaihay.network.pojo.search;

import com.example.hiennv.loigiaihay.network.pojo.tag.ConfigInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSearch {
    @Expose
    @SerializedName("listArticles")
    private List<ArticleSearch> articleSearchList;

    @Expose
    @SerializedName("cfg_info")
    private ConfigInfo configInfo;

    @Expose
    @SerializedName("total")
    private int total;

    public List<ArticleSearch> getArticleSearchList() {
        return articleSearchList;
    }

    public ConfigInfo getConfigInfo() {
        return configInfo;
    }

    public int getTotal() {
        return total;
    }
}
