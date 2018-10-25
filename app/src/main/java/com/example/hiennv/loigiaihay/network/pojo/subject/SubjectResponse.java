package com.example.hiennv.loigiaihay.network.pojo.subject;

import com.example.hiennv.loigiaihay.network.pojo.subject.Subject;
import com.example.hiennv.loigiaihay.network.pojo.tag.ConfigInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SubjectResponse implements Serializable{
    @Expose
    @SerializedName("list_data")
    private List<SubjectData> listData;

    @Expose
    @SerializedName("cfg_info")
    private ConfigInfo configInfo;

    public List<SubjectData> getListData() {
        return listData;
    }

    public ConfigInfo getConfigInfo() {
        return configInfo;
    }
}
