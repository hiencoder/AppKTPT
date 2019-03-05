package com.example.hiennv.loigiaihay.network.pojo.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class BaseEvent {
    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("is_link")
    private int isLink;

    public String getTitle() {
        return title;
    }

    public int getIsLink() {
        return isLink;
    }
}
