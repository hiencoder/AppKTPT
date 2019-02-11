package com.example.hiennv.loigiaihay.db.realmdb.realmobject;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SearchRealm extends RealmObject {
    @PrimaryKey
    private int searchId;
    private String searchSubjectId;
    private String searchSubjectType;
    private String searchArticleId;
    private String searchNameText;
    private String searchNameNotSigned;
    private String searchIsLink;
    private String searchRedirectLink;

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

    public String getSearchArticleId() {
        return searchArticleId;
    }

    public void setSearchArticleId(String searchArticleId) {
        this.searchArticleId = searchArticleId;
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
}
