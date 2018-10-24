package com.example.hiennv.loigiaihay.network.pojo.event;

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
    private String introtext;

    @Expose
    @SerializedName("itemId")
    private int itemId;

    @Expose
    @SerializedName("itemType")
    private int itemType;

    @Expose
    @SerializedName("picture")
    private String picture;

    @Expose
    @SerializedName("catTitle")
    private String catTitle;

    @Expose
    @SerializedName("contentBoxAbove")
    private String contentBoxAbove;

    public String getTitle() {
        return title;
    }

    public int getCatId() {
        return catId;
    }

    public String getAlias() {
        return alias;
    }

    public String getIntrotext() {
        return introtext;
    }

    public int getItemId() {
        return itemId;
    }

    public int getItemType() {
        return itemType;
    }

    public String getPicture() {
        return picture;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public String getContentBoxAbove() {
        return contentBoxAbove;
    }
}
