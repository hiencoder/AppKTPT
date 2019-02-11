package com.example.hiennv.loigiaihay.db.realmdb.realmobject;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TickerRealm extends RealmObject {
    @PrimaryKey
    private int tickerId;
    private String tickerSubjectId;
    private String tickerSubjectDownload;

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
