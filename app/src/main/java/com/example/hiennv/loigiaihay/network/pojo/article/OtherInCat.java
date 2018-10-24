package com.example.hiennv.loigiaihay.network.pojo.article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtherInCat {
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
    @SerializedName("is_link")
    private int isLink;

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

    public int getIsLink() {
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
