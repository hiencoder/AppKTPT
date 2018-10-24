package com.example.hiennv.loigiaihay.network.pojo.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CatInfo {
    @Expose
    @SerializedName("picture")
    private String picture;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("alias")
    private String alias;

    @Expose
    @SerializedName("description")
    private String description;

    @Expose
    @SerializedName("contentBoxAbove")
    private String contentBoxAbove;

    @Expose
    @SerializedName("contentBoxBelow")
    private String contentBoxBelow;

    @Expose
    @SerializedName("app_note")
    private String appNote;

    @Expose
    @SerializedName("zip_status")
    private int zipStatus;

    @Expose
    @SerializedName("last_zip_time")
    private long lastZipTime;

    @Expose
    @SerializedName("itemId")
    private int itemId;

    @Expose
    @SerializedName("product_id")
    private String productId;

    public String getPicture() {
        return picture;
    }

    public String getTitle() {
        return title;
    }

    public String getAlias() {
        return alias;
    }

    public String getDescription() {
        return description;
    }

    public String getContentBoxAbove() {
        return contentBoxAbove;
    }

    public String getContentBoxBelow() {
        return contentBoxBelow;
    }

    public String getAppNote() {
        return appNote;
    }

    public int getZipStatus() {
        return zipStatus;
    }

    public long getLastZipTime() {
        return lastZipTime;
    }

    public int getItemId() {
        return itemId;
    }

    public String getProductId() {
        return productId;
    }
}
