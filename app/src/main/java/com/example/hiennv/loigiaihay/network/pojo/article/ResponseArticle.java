package com.example.hiennv.loigiaihay.network.pojo.article;

import com.example.hiennv.loigiaihay.network.pojo.tag.ConfigInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseArticle {
    @Expose
    @SerializedName("cfg_info")
    private ConfigInfo configInfo;

    @Expose
    @SerializedName("articleInfo")
    private ArticleInfo articleInfo;

    @Expose
    @SerializedName("relateArticles")
    private List<RelateArticle> relateArticles;

    @Expose
    @SerializedName("othersInCat")
    private List<OtherInCat> otherInCats;

    @Expose
    @SerializedName("eventInfo")
    private EventInfo eventInfo;

    @Expose
    @SerializedName("banner")
    private Banner banner;

    public ConfigInfo getConfigInfo() {
        return configInfo;
    }

    public ArticleInfo getArticleInfo() {
        return articleInfo;
    }

    public List<RelateArticle> getRelateArticles() {
        return relateArticles;
    }

    public List<OtherInCat> getOtherInCats() {
        return otherInCats;
    }

    public EventInfo getEventInfo() {
        return eventInfo;
    }

    public Banner getBanner() {
        return banner;
    }
}
