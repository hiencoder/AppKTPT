package com.example.hiennv.loigiaihay.utils;

public class AppConstants {
    public static final String BASE_URL = "https://api.loigiaihay.com/v3/";
    //Get list class
    //https://api.loigiaihay.com/v3/tags

    //Get class info
    //https://api.loigiaihay.com/v3/tags/12 (tagId)(api get list class)

    //Get categories https://api.loigiaihay.com/v3/categories/{item_id}
    //https://api.loigiaihay.com/v3/categories/47

    //Get event https://api.loigiaihay.com/v3/events/{eventId} ()
    //https://api.loigiaihay.com/v3/events/616

    //Get detail lesson https://api.loigiaihay.com/v3/articles/%s(articleId) tu articleId = 89
    //https://api.loigiaihay.com/v3/articles/89

    //Search category
    //https://api.loigiaihay.com/v3/article/search?limit=8&page=" + sPStringValue4 + "&keyword=" + sPStringValue + "&catId=" + sPStringValue2;
    //https://api.loigiaihay.com/v3/article/search?limit=8&page=1&keyword=hinh%20hoc&catId=47

    //Image
    //https://www.youtube.com/watch?v=H0QFyXQ7H14
    //Data saved in shared
    public static final String PREF_NAME = "pref_name";
    public static final String IS_FIRST_LAUNCH = "first_launch";//Lan dau chay app
    public static final String KEY_CLASS_ID = "tag_id"; //id lop
    public static final String KEY_CLASS_TITLE = "class_title"; //title class
    public static final String KEY_SUBJECT_ID = "subject_id"; //item_id
    public static final String KEY_SUBJECT_TITLE = "subject_title";//title subject

    public static final String KEY_PRODUCT_ID = "product_id"; //Thông tin bài học đang học
    public static final String KEY_SUPPORT_FANPAGE = "support_fanpage";
    public static final String KEY_AD_MOB = "admob_ad_unit_id_event";
    public static final String KEY_AD_POPUP = "ad.adsense.popup.unit_id";

    public static final String KEY_ITEM_ID = "item_id";
    //abc
    public static final long REQUEST_TIMEOUT = 600l;

    //Table search
    public static final String TABLE_SEARCH = "tb_search";
    public static final String SEARCH_ID = "search_id";
    public static final String SEARCH_SUBJECT_ID = "search_subject_id";
    public static final String SEARCH_SUBJECT_TYPE = "search_subject_type";
    public static final String SEARCH_NAME_TEXT = "search_name_text";
    public static final String SEARCH_NAME_NOT_SIGNED = "search_name_not_signed";
    public static final String SEARCH_ARTICLE_ID = "search_article_id";
    public static final String SEARCH_IS_LINK = "search_is_link";
    public static final String SEARCH_REDIRECT_LINK = "search_redirect_link";

    /*
    * save	CREATE TABLE save(id_save INTEGER PRIMARY KEY,name_save TEXT,intro_save TEXT,body_save TEXT,url_save TEXT,articleId_save TEXT)
    history	CREATE TABLE history(id_his INTEGER PRIMARY KEY,name_his TEXT,intro_his TEXT,avatar_his TEXT,url_his TEXT,articleId_his TEXT)
    notification_table	CREATE TABLE notification_table(id_notifi INTEGER PRIMARY KEY,title_notifi TEXT,content_notifi TEXT,url_notifi TEXT,date_notifi TEXT,status_notifi TEXT)
    ticked_table	CREATE TABLE ticked_table(id_ticked INTEGER PRIMARY KEY,id_mon_tai TEXT,ten_mon_tai TEXT)
    order_id_table	CREATE TABLE oder_id_table(id_oder_id INTEGER PRIMARY KEY,name_oder_id TEXT)*/

    public static final String DATABASE_NAME = "ktht_db";
    public static final int DATABASE_VERSION = 1;
    //Table save
    public static final String TABLE_SAVE = "tb_save";
    public static final String SAVE_ID = "save_id";
    public static final String SAVE_NAME = "save_name";
    public static final String SAVE_INTRO = "save_intro";
    public static final String SAVE_BODY = "save_body";
    public static final String SAVE_URL = "save_url";
    public static final String SAVE_ARTICLE_ID = "save_article_id";

    //TABLE HISTORY
    public static final String TABLE_HISTORY = "tb_history";
    public static final String HISTORY_ID = "history_id";
    public static final String HISTORY_NAME = "history_name";
    public static final String HISTORY_INTRO = "history_intro";
    public static final String HISTORY_AVATAR = "history_avatar";
    public static final String HISTORY_URL = "history_url";
    public static final String HISTORY_ARTICLE_ID = "history_article_id";

    //TABLE NOTIFICATION
    public static final String TABLE_NOTIFICATION = "tb_notification";
    public static final String NOTIFICATION_ID = "notification_id";
    public static final String NOTIFICATION_TITLE = "notification_title";
    public static final String NOTIFICATION_CONTENT = "notification_content";
    public static final String NOTIFICATION_URL = "notification_url";
    public static final String NOTIFICATION_DATE = "notification_date";
    public static final String NOTIFICATION_STATUS = "notification_status";

    //TABLE TICKED
    public static final String TABLE_TICKED = "tb_ticked";
    public static final String TICKED_ID = "ticked_id";
    public static final String TICKED_SUBJECT_ID = "ticked_subject_id";
    public static final String TICKED_SUBJECT_DOWNLOAD = "ticked_subject_download";

    //TABLE ORDERI_D
    public static final String TABLE_ORDER_ID = "tb_order_id";
    public static final String ORDER_ID = "order_id";
    public static final String ORDER_ID_NAME = "order_id_name";

    //TYPE FOR LOAD BASEVENT
    public static final int TYPE_BASE_EVENT = 0;
    public static final int TYPE_ARTICLE = 1;
    public static final int TYPE_SUB_EVENT = 2;
    public static final String KEY_ARTICLE_ID = "article_id";

    //FIRST OPEN ACTIVITY DETAIL
    public static final String KEY_FIRST_OPEN_DETAIL = "first_open_detail";
    public static final String SPACE = " ";

    //articleOfflineId
    public static final String KEY_ARTICLE_OFFLINE_ID = "article_offline_id";

    //KeyWord
    public static final String KEY_WORD_SEARCH = "key_word";

}
