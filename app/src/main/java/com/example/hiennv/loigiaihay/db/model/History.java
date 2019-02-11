package com.example.hiennv.loigiaihay.db.model;

import java.io.Serializable;

public class History implements Serializable {
    private int historyId;
    private String historyName;
    private String historyIntro;
    private String historyAvatar;
    private String historyUrl;
    private String historyArticleId;

    public History(int historyId, String historyName, String historyIntro, String historyAvatar, String historyUrl, String historyArticleId) {
        this.historyId = historyId;
        this.historyName = historyName;
        this.historyIntro = historyIntro;
        this.historyAvatar = historyAvatar;
        this.historyUrl = historyUrl;
        this.historyArticleId = historyArticleId;
    }

    public History(String historyName, String historyIntro, String historyAvatar, String historyUrl, String historyArticleId) {
        this.historyName = historyName;
        this.historyIntro = historyIntro;
        this.historyAvatar = historyAvatar;
        this.historyUrl = historyUrl;
        this.historyArticleId = historyArticleId;
    }

    public History() {
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public String getHistoryName() {
        return historyName;
    }

    public void setHistoryName(String historyName) {
        this.historyName = historyName;
    }

    public String getHistoryIntro() {
        return historyIntro;
    }

    public void setHistoryIntro(String historyIntro) {
        this.historyIntro = historyIntro;
    }

    public String getHistoryAvatar() {
        return historyAvatar;
    }

    public void setHistoryAvatar(String historyAvatar) {
        this.historyAvatar = historyAvatar;
    }

    public String getHistoryUrl() {
        return historyUrl;
    }

    public void setHistoryUrl(String historyUrl) {
        this.historyUrl = historyUrl;
    }

    public String getHistoryArticleId() {
        return historyArticleId;
    }

    public void setHistoryArticleId(String historyArticleId) {
        this.historyArticleId = historyArticleId;
    }
}
