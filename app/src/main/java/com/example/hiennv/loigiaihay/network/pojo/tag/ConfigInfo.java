package com.example.hiennv.loigiaihay.network.pojo.tag;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ConfigInfo implements Serializable{
    @Expose
    @SerializedName("last_cfg_time")
    private String lastCfgTime;

    @Expose
    @SerializedName("ad.popup_frequency")
    private String adPopupFrequency;

    @Expose
    @SerializedName("ad.adsense.detail_bottom.unit_id")
    private String adAdsenseDetail;

    @Expose
    @SerializedName("ad.adsense.popup.unit_id")
    private String adAdsensePopup;

    @Expose
    @SerializedName("current.force.update.version")
    private String currentForceUpdate;

    @Expose
    @SerializedName("support.email")
    private String supportEmail;

    @Expose
    @SerializedName("support.fanpage")
    private String supportFanpage;

    @Expose
    @SerializedName("popup_rating_after")
    private String popupRatingAfter;

    @Expose
    @SerializedName("admob.app_id")
    private String admobAppId;

    @Expose
    @SerializedName("admob.unit.article_detail_bottom")
    private String admobUnitArticleDetailBottom;

    @Expose
    @SerializedName("admob.unit.article_detail_top")
    private String admobUnitArticleDetailTop;

    @Expose
    @SerializedName("admob.unit.event_article_top")
    private String admobUnitEventArticleTop;

    @Expose
    @SerializedName("admob.unit.interestial")
    private String admobUnitInterestial;

    @Expose
    @SerializedName("latest_version")
    private String latestVersion;

    @Expose
    @SerializedName("force_update")
    private boolean forceUpdate;

    public String getLastCfgTime() {
        return lastCfgTime;
    }

    public String getAdPopupFrequency() {
        return adPopupFrequency;
    }

    public String getAdAdsenseDetail() {
        return adAdsenseDetail;
    }

    public String getAdAdsensePopup() {
        return adAdsensePopup;
    }

    public String getCurrentForceUpdate() {
        return currentForceUpdate;
    }

    public String getSupportEmail() {
        return supportEmail;
    }

    public String getSupportFanpage() {
        return supportFanpage;
    }

    public String getPopupRatingAfter() {
        return popupRatingAfter;
    }

    public String getAdmobAppId() {
        return admobAppId;
    }

    public String getAdmobUnitArticleDetailBottom() {
        return admobUnitArticleDetailBottom;
    }

    public String getAdmobUnitArticleDetailTop() {
        return admobUnitArticleDetailTop;
    }

    public String getAdmobUnitEventArticleTop() {
        return admobUnitEventArticleTop;
    }

    public String getAdmobUnitInterestial() {
        return admobUnitInterestial;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public boolean isForceUpdate() {
        return forceUpdate;
    }
}
