package com.example.hiennv.loigiaihay.network.pojo.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MostView {
    @Expose
    @SerializedName("articleId")
    private int articleId;

    @Expose
    @SerializedName("catId")
    private int catId;

    @Expose
    @SerializedName("publishTime")
    private long publishTime;

    @Expose
    @SerializedName("isHot")
    private int isHot;

    @Expose
    @SerializedName("is_link")
    private int is_link;

    @Expose
    @SerializedName("thumbnail")
    private String thumbnail;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("alias")
    private String alias;

    @Expose
    @SerializedName("introtext")
    private String introtext;

    public int getArticleId() {
        return articleId;
    }

    public int getCatId() {
        return catId;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public int getIsHot() {
        return isHot;
    }

    public int getIs_link() {
        return is_link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getAlias() {
        return alias;
    }

    public String getIntrotext() {
        return introtext;
    }
}
