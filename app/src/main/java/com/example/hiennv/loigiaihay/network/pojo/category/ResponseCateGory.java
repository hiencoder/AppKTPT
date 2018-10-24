package com.example.hiennv.loigiaihay.network.pojo.category;

import com.example.hiennv.loigiaihay.network.pojo.tag.ConfigInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseCateGory {
    @Expose
    @SerializedName("cfg_info")
    private ConfigInfo configInfo;

    @Expose
    @SerializedName("catInfo")
    private CatInfo catInfo;

    @Expose
    @SerializedName("listEvents")
    private List<Event> listEvents;

    public ConfigInfo getConfigInfo() {
        return configInfo;
    }

    public CatInfo getCatInfo() {
        return catInfo;
    }

    public List<Event> getListEvents() {
        return listEvents;
    }
}
