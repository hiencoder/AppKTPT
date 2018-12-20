package com.example.hiennv.loigiaihay.db.model;

import java.io.Serializable;

public class Ticker implements Serializable {
    private int tickerId;
    private String tickerSubjectId;
    private String tickerSubjectDownload;

    public Ticker(int tickerId, String tickerSubjectId, String tickerSubjectDownload) {
        this.tickerId = tickerId;
        this.tickerSubjectId = tickerSubjectId;
        this.tickerSubjectDownload = tickerSubjectDownload;
    }

    public Ticker(String tickerSubjectId, String tickerSubjectDownload) {
        this.tickerSubjectId = tickerSubjectId;
        this.tickerSubjectDownload = tickerSubjectDownload;
    }

    public Ticker() {
    }

    public int getTickerId() {
        return tickerId;
    }

    public void setTickerId(int tickerId) {
        this.tickerId = tickerId;
    }

    public String getTickerSubjectId() {
        return tickerSubjectId;
    }

    public void setTickerSubjectId(String tickerSubjectId) {
        this.tickerSubjectId = tickerSubjectId;
    }

    public String getTickerSubjectDownload() {
        return tickerSubjectDownload;
    }

    public void setTickerSubjectDownload(String tickerSubjectDownload) {
        this.tickerSubjectDownload = tickerSubjectDownload;
    }
}
