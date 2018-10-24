package com.example.hiennv.loigiaihay.network.pojo.tag;

import com.example.hiennv.loigiaihay.network.pojo.tag.ConfigInfo;
import com.example.hiennv.loigiaihay.network.pojo.tag.Subject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SubjectResponse implements Serializable{
    @Expose
    @SerializedName("list_data")
    private List<Subject> listData;

    @Expose
    @SerializedName("cfg_info")
    private ConfigInfo configInfo;

    public List<Subject> getListData() {
        return listData;
    }

    public ConfigInfo getConfigInfo() {
        return configInfo;
    }
}
