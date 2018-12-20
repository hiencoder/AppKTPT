package com.example.hiennv.loigiaihay.db.model;

import java.io.Serializable;

public class Save implements Serializable {
    private int saveId;
    private String saveName;
    private String saveIntro;
    private String saveBody;
    private String saveUrl;
    private String saveArticleId;

    public Save(int saveId, String saveName, String saveIntro, String saveBody, String saveUrl, String saveArticleId) {
        this.saveId = saveId;
        this.saveName = saveName;
        this.saveIntro = saveIntro;
        this.saveBody = saveBody;
        this.saveUrl = saveUrl;
        this.saveArticleId = saveArticleId;
    }

    public Save(String saveName, String saveIntro, String saveBody, String saveUrl, String saveArticleId) {
        this.saveName = saveName;
        this.saveIntro = saveIntro;
        this.saveBody = saveBody;
        this.saveUrl = saveUrl;
        this.saveArticleId = saveArticleId;
    }

    public Save() {
    }

    public int getSaveId() {
        return saveId;
    }

    public void setSaveId(int saveId) {
        this.saveId = saveId;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public String getSaveIntro() {
        return saveIntro;
    }

    public void setSaveIntro(String saveIntro) {
        this.saveIntro = saveIntro;
    }

    public String getSaveBody() {
        return saveBody;
    }

    public void setSaveBody(String saveBody) {
        this.saveBody = saveBody;
    }

    public String getSaveUrl() {
        return saveUrl;
    }

    public void setSaveUrl(String saveUrl) {
        this.saveUrl = saveUrl;
    }

    public String getSaveArticleId() {
        return saveArticleId;
    }

    public void setSaveArticleId(String saveArticleId) {
        this.saveArticleId = saveArticleId;
    }
}
