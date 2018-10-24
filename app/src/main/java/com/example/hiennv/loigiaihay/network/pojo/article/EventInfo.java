package com.example.hiennv.loigiaihay.network.pojo.article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventInfo {
    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("catId")
    private int catId;

    @Expose
    @SerializedName("alias")
    private String alias;

    @Expose
    @SerializedName("introtext")
    private String introText;

    @Expose
    @SerializedName("itemId")
    private int itemId;

    @Expose
    @SerializedName("itemType")
    private int itemType;

    public String getTitle() {
        return title;
    }

    public int getCatId() {
        return catId;
    }

    public String getAlias() {
        return alias;
    }

    public String getIntroText() {
        return introText;
    }

    public int getItemId() {
        return itemId;
    }

    public int getItemType() {
        return itemType;
    }
}
