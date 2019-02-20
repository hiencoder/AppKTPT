package com.example.hiennv.loigiaihay.network.pojo.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubEvent {
    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("itemId")
    private String itemId;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("short_title")
    private String shortTitle;

    @Expose
    @SerializedName("is_link")
    private int isLink;

    public String getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public int getIsLink() {
        return isLink;
    }
}
