package com.example.hiennv.loigiaihay.network.pojo.tag;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ClassEntity implements Serializable{
    @Expose
    @SerializedName("tagId")
    private String tagId;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("picture")
    private String picture;

    @Expose
    @SerializedName("product_id")
    private String productId;

    public ClassEntity() {
    }

    public ClassEntity(String tagId, String title, String picture, String productId) {
        this.tagId = tagId;
        this.title = title;
        this.picture = picture;
        this.productId = productId;
    }

    public String getTagId() {
        return tagId;
    }

    public String getTitle() {
        return title;
    }

    public String getPicture() {
        return picture;
    }

    public String getProductId() {
        return productId;
    }
}
