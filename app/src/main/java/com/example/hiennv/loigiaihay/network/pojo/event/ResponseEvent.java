package com.example.hiennv.loigiaihay.network.pojo.event;

import com.example.hiennv.loigiaihay.network.pojo.tag.ConfigInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseEvent {
    @Expose
    @SerializedName("eventInfo")
    private EventInfo eventInfo;

    @Expose
    @SerializedName("cfg_info")
    private ConfigInfo configInfo;

    @Expose
    @SerializedName("listArticles")
    private List<Article> listArticles;

    @Expose
    @SerializedName("mostViews")
    private List<MostView> mostViews;

    @Expose
    @SerializedName("listSubEvent")
    private List<SubEvent> subEvents;

    public EventInfo getEventInfo() {
        return eventInfo;
    }

    public ConfigInfo getConfigInfo() {
        return configInfo;
    }

    public List<Article> getListArticles() {
        return listArticles;
    }

    public List<MostView> getMostViews() {
        return mostViews;
    }

    public List<SubEvent> getSubEvents() {
        return subEvents;
    }
}
