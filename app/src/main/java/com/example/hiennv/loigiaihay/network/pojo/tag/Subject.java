package com.example.hiennv.loigiaihay.network.pojo.tag;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Subject implements Serializable{
    @Expose
    @SerializedName("item_id")
    private int itemId;

    @Expose
    @SerializedName("item_type")
    private int itemType;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("alias")
    private String alias;

    @Expose
    @SerializedName("picture")
    private String picture;

    @Expose
    @SerializedName("is_link")
    private int isLink;

    @Expose
    @SerializedName("redirect_link")
    private String redirectLink;

    @Expose
    @SerializedName("product_id")
    private String productId;

    public int getItemId() {
        return itemId;
    }

    public int getItemType() {
        return itemType;
    }

    public String getTitle() {
        return title;
    }

    public String getAlias() {
        return alias;
    }

    public String getPicture() {
        return picture;
    }

    public int getIsLink() {
        return isLink;
    }

    public String getRedirectLink() {
        return redirectLink;
    }

    public String getProductId() {
        return productId;
    }
}
