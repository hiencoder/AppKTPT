package com.example.hiennv.loigiaihay.network.pojo.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {
    @Expose
    @SerializedName("articleId")
    protected int articleId;

    @Expose
    @SerializedName("catId")
    protected int catId;

    @Expose
    @SerializedName("publishTime")
    protected long publishTime;

    @Expose
    @SerializedName("typeEx")
    protected int typeEx;

    @Expose
    @SerializedName("isHot")
    protected int isHot;

    @Expose
    @SerializedName("is_link")
    protected String isLink;

    @Expose
    @SerializedName("thumbnail")
    protected String thumbnail;

    @Expose
    @SerializedName("title")
    protected String title;

    @Expose
    @SerializedName("alias")
    protected String alias;

    @Expose
    @SerializedName("introtext")
    protected String introtext;

    public int getArticleId() {
        return articleId;
    }

    public int getCatId() {
        return catId;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public int getTypeEx() {
        return typeEx;
    }

    public int getIsHot() {
        return isHot;
    }

    public String getIsLink() {
        return isLink;
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
