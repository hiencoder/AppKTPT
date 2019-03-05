package com.example.hiennv.loigiaihay.db.model;

import java.io.Serializable;

public class Search implements Serializable {
    private int searchId;
    private String searchSubjectId;
    private String searchSubjectType;
    private String searchArticleId;
    private String searchNameText;
    private String searchNameNotSigned;
    private String searchIsLink;
    private String searchRedirectLink;

    public Search(int searchId, String searchSubjectId, String searchSubjectType, String searchArticleId ,String searchNameText,
                  String searchNameNotSigned, String searchIsLink, String searchRedirectLink) {
        this.searchId = searchId;
        this.searchSubjectId = searchSubjectId;
        this.searchSubjectType = searchSubjectType;
        this.searchArticleId = searchArticleId;
        this.searchNameText = searchNameText;
        this.searchNameNotSigned = searchNameNotSigned;
        this.searchIsLink = searchIsLink;
        this.searchRedirectLink = searchRedirectLink;
    }

    public Search(String searchSubjectId, String searchSubjectType, String searchArticleId,String searchNameText,
                  String searchNameNotSigned, String searchIsLink, String searchRedirectLink) {
        this.searchSubjectId = searchSubjectId;
        this.searchSubjectType = searchSubjectType;
        this.searchArticleId = searchArticleId;
        this.searchNameText = searchNameText;
        this.searchNameNotSigned = searchNameNotSigned;
        this.searchIsLink = searchIsLink;
        this.searchRedirectLink = searchRedirectLink;
    }

    public Search() {
    }

    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    public String getSearchSubjectId() {
        return searchSubjectId;
    }

    public void setSearchSubjectId(String searchSubjectId) {
        this.searchSubjectId = searchSubjectId;
    }

    public String getSearchSubjectType() {
        return searchSubjectType;
    }

    public void setSearchSubjectType(String searchSubjectType) {
        this.searchSubjectType = searchSubjectType;
    }

    public String getSearchNameText() {
        return searchNameText;
    }

    public void setSearchNameText(String searchNameText) {
        this.searchNameText = searchNameText;
    }

    public String getSearchNameNotSigned() {
        return searchNameNotSigned;
    }

    public void setSearchNameNotSigned(String searchNameNotSigned) {
        this.searchNameNotSigned = searchNameNotSigned;
    }

    public String getSearchIsLink() {
        return searchIsLink;
    }

    public void setSearchIsLink(String searchIsLink) {
        this.searchIsLink = searchIsLink;
    }

    public String getSearchRedirectLink() {
        return searchRedirectLink;
    }

    public void setSearchRedirectLink(String searchRedirectLink) {
        this.searchRedirectLink = searchRedirectLink;
    }

    public String getSearchArticleId() {
        return searchArticleId;
    }

    public void setSearchArticleId(String searchArticleId) {
        this.searchArticleId = searchArticleId;
    }
}
