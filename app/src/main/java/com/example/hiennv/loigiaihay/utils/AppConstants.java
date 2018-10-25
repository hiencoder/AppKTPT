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

    //Data saved in shared
    public static final String PREF_NAME = "pref_name";
    public static final String IS_FIRST_LAUNCH = "first_launch";
    public static final String KEY_CLASS_NAME = "class_name"; //classId


    public static final long REQUEST_TIMEOUT = 600l;
}
