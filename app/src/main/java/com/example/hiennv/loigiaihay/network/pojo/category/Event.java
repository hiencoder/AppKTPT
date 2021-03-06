package com.example.hiennv.loigiaihay.network.pojo.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event {
    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("catId")
    private int catId;

    @Expose
    @SerializedName("is_link")
    private int isLink;

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

    @Expose
    @SerializedName("subItems")
    private List<SubItem> subItems;

    public String getTitle() {
        return title;
    }

    public int getCatId() {
        return catId;
    }

    public int getIsLink() {
        return isLink;
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

    public List<SubItem> getSubItems() {
        return subItems;
    }
}
