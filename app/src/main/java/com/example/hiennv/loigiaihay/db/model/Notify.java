package com.example.hiennv.loigiaihay.db.model;

import java.io.Serializable;

public class Notify implements Serializable {
    private int notifyId;
    private String notifyTitle;
    private String notifyContent;
    private String notifyUrl;
    private String notifyDate;
    private String notifyStatus;

    public Notify(int notifyId, String notifyTitle, String notifyContent, String notifyUrl, String notifyDate, String notifyStatus) {
        this.notifyId = notifyId;
        this.notifyTitle = notifyTitle;
        this.notifyContent = notifyContent;
        this.notifyUrl = notifyUrl;
        this.notifyDate = notifyDate;
        this.notifyStatus = notifyStatus;
    }

    public Notify(String notifyTitle, String notifyContent, String notifyUrl, String notifyDate, String notifyStatus) {
        this.notifyTitle = notifyTitle;
        this.notifyContent = notifyContent;
        this.notifyUrl = notifyUrl;
        this.notifyDate = notifyDate;
        this.notifyStatus = notifyStatus;
    }

    public Notify() {
    }

    public int getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(int notifyId) {
        this.notifyId = notifyId;
    }

    public String getNotifyTitle() {
        return notifyTitle;
    }

    public void setNotifyTitle(String notifyTitle) {
        this.notifyTitle = notifyTitle;
    }

    public String getNotifyContent() {
        return notifyContent;
    }

    public void setNotifyContent(String notifyContent) {
        this.notifyContent = notifyContent;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getNotifyDate() {
        return notifyDate;
    }

    public void setNotifyDate(String notifyDate) {
        this.notifyDate = notifyDate;
    }

    public String getNotifyStatus() {
        return notifyStatus;
    }

    public void setNotifyStatus(String notifyStatus) {
        this.notifyStatus = notifyStatus;
    }
}
