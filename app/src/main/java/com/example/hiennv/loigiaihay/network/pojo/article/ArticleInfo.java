package com.example.hiennv.loigiaihay.network.pojo.article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleInfo {
    @Expose
    @SerializedName("articleId")
    private int articleId;

    @Expose
    @SerializedName("catId")
    private int catId;

    @Expose
    @SerializedName("catTitle")
    private String catTitle;

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
    private String introText;

    @Expose
    @SerializedName("content")
    private String content;

    @Expose
    @SerializedName("display_type")
    private int displayType;

    @Expose
    @SerializedName("cmt_count")
    private int cmtCount;

    @Expose
    @SerializedName("zip_status")
    private int zipStatus;

    @Expose
    @SerializedName("last_modified_time")
    private long lastModifiedTime;

    @Expose
    @SerializedName("last_zip_time")
    private long lastZipTime;

    @Expose
    @SerializedName("zip_link")
    private String zipLink;

    @Expose
    @SerializedName("picture")
    private String picture;

    @Expose
    @SerializedName("comment_url")
    private String commentUrl;

    @Expose
    @SerializedName("origin_url")
    private String originUrl;

    public int getArticleId() {
        return articleId;
    }

    public int getCatId() {
        return catId;
    }

    public String getCatTitle() {
        return catTitle;
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

    public String getIntroText() {
        return introText;
    }

    public String getContent() {
        return content;
    }

    public int getDisplayType() {
        return displayType;
    }

    public int getCmtCount() {
        return cmtCount;
    }

    public int getZipStatus() {
        return zipStatus;
    }

    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public long getLastZipTime() {
        return lastZipTime;
    }

    public String getZipLink() {
        return zipLink;
    }

    public String getPicture() {
        return picture;
    }

    public String getCommentUrl() {
        return commentUrl;
    }

    public String getOriginUrl() {
        return originUrl;
    }
}
