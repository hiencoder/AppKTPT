package com.example.hiennv.loigiaihay.db.realmdb.realmobject;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SaveRealm extends RealmObject {
    @PrimaryKey
    private int saveId;
    private String saveName;
    private String saveIntro;
    private String saveBody;
    private String saveUrl;
    private String saveArticleId;

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
