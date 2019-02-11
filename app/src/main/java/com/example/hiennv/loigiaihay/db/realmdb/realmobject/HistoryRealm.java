package com.example.hiennv.loigiaihay.db.realmdb.realmobject;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class HistoryRealm extends RealmObject {
    @PrimaryKey
    private int historyId;
    private String historyName;
    private String historyIntro;
    private String historyAvatar;
    private String historyUrl;
    private String historyArticleId;

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
