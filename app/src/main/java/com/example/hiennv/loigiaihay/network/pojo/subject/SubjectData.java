package com.example.hiennv.loigiaihay.network.pojo.subject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubjectData {
    @Expose
    @SerializedName("book_type")
    private String bookType;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("tab_color_code")
    private String tabColorCode;

    @Expose
    @SerializedName("base_url")
    private String baseUrl;

    @Expose
    @SerializedName("list_subject")
    private List<Subject> listSubject;

    public String getBookType() {
        return bookType;
    }

    public String getTitle() {
        return title;
    }

    public String getTabColorCode() {
        return tabColorCode;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public List<Subject> getListSubject() {
        return listSubject;
    }
}
