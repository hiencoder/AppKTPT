package com.example.hiennv.loigiaihay.network.pojo.tag;

import com.example.hiennv.loigiaihay.network.pojo.tag.ClassEntity;
import com.example.hiennv.loigiaihay.network.pojo.tag.ConfigInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TagResponse implements Serializable{
    @Expose
    @SerializedName("list_class")
    private List<ClassEntity> listClass;

    @Expose
    @SerializedName("cfg_info")
    private ConfigInfo configInfo;

    public List<ClassEntity> getListClass() {
        return listClass;
    }

    public ConfigInfo getConfigInfo() {
        return configInfo;
    }
}
