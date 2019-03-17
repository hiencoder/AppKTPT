package com.example.hiennv.loigiaihay.service;

public class DataService {
    /*package com.tp.loigiaihay.network;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.NetworkResponse;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tp.loigiaihay.activitys.CacMonDaTaiOffline;
import com.tp.loigiaihay.activitys.DetailLessonActivity;
import com.tp.loigiaihay.ultils.AppConfig;
import com.tp.loigiaihay.ultils.ApplicationController;
import com.tp.loigiaihay.ultils.Constants;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataServices {
    static String changeClass;
    public static List<String> listItemId;
    public static int page = 1;
    static String urlRequest;
    public static String urlRequest2;

    public static void getLesson(Context context, final NetworkListener networkListener) {
        String str;
        String sPStringValue = AppConfig.getSPStringValue(context, Constants.strItemId);
        if (AppConfig.getSPStringValue(context, Constants.strItemType).equals("1")) {
            str = "categories";
        } else {
            str = "event";
        }
        urlRequest = Constants.SERVER + String.format(Constants.GET_CATEGORY, new Object[]{str, sPStringValue});
        final String valueOf = String.valueOf(context.getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, 0).getLong("last_cfg_time", 0));
        final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(0, urlRequest, null, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                System.out.println("Success url " + DataServices.urlRequest + IOUtils.LINE_SEPARATOR_UNIX + jSONObject.toString());
                networkListener.onNetworkSuccess(jSONObject);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                Log.i(Constants.TAG, "Error url " + DataServices.urlRequest);
                volleyError.printStackTrace();
            }
        }) {
            public Map<String, String> getHeaders() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put(AppConfig.REQ_HEADER_LAST_CFG_TIME, valueOf);
                hashMap.put("X-os", AbstractSpiCall.ANDROID_CLIENT_TYPE);
                hashMap.put("X-book-type", AppConfig.getSPStringValue(context2, Constants.strXbookType));
                return hashMap;
            }
        }, Constants.tag_service);
    }

    public static void showCategorySubjects(final Context context, final NetworkListener networkListener) {
        changeClass = AppConfig.getSPStringValue(context, Constants.strNumberClass);
        urlRequest = "https://api.loigiaihay.com/v3/tags/" + changeClass;
        final String valueOf = String.valueOf(context.getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, 0).getLong("last_cfg_time", 0));
        final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new CachedNoExpiredJsonObjectRequest(urlRequest, null, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                Log.i(Constants.TAG, "Success url " + DataServices.urlRequest + IOUtils.LINE_SEPARATOR_UNIX + jSONObject.toString());
                networkListener.onNetworkSuccess(jSONObject);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                Log.i(Constants.TAG, "Error url " + DataServices.urlRequest);
                volleyError.printStackTrace();
                DataServices.showCategorySubjects(context, networkListener);
            }
        }) {
            public Map<String, String> getHeaders() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put(AppConfig.REQ_HEADER_LAST_CFG_TIME, valueOf);
                hashMap.put("X-book-type", AppConfig.getSPStringValue(context2, Constants.strXbookType));
                return hashMap;
            }
        }, Constants.tag_service);
    }

    public static void showCategorySubjectsTest(final Context context, final NetworkListener networkListener) {
        changeClass = AppConfig.getSPStringValue(context, Constants.strNumberClass);
        urlRequest = "https://api.loigiaihay.com/v3/tags/" + changeClass;
        final String valueOf = String.valueOf(context.getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, 0).getLong("last_cfg_time", 0));
        final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new CachedNoExpiredJsonObjectRequest(urlRequest, null, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                Log.i(Constants.TAG, "Success url " + DataServices.urlRequest + IOUtils.LINE_SEPARATOR_UNIX + jSONObject.toString());
                networkListener.onNetworkSuccess(jSONObject);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                Log.i(Constants.TAG, "Error url " + DataServices.urlRequest);
                volleyError.printStackTrace();
                DataServices.showCategorySubjects(context, networkListener);
            }
        }) {
            public Map<String, String> getHeaders() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put(AppConfig.REQ_HEADER_LAST_CFG_TIME, valueOf);
                hashMap.put("X-os", AbstractSpiCall.ANDROID_CLIENT_TYPE);
                hashMap.put("X-book-type", AppConfig.getSPStringValue(context2, Constants.strXbookType));
                return hashMap;
            }
        }, Constants.tag_service);
    }

    public static void cancelAllRequest() {
        ApplicationController.getInstance().cancelPendingRequests(Constants.TAG);
    }

    public static void getDetailLesson(final Context context, final NetworkListener networkListener) {
        String sPStringValue = AppConfig.getSPStringValue(context, Constants.strIdAr);
        sPStringValue = String.format(Constants.DETAIL_LESSON, new Object[]{sPStringValue});
        final String[] strArr = new String[]{Constants.SERVER + sPStringValue};
        final int[] iArr = new int[]{1};
        iArr[0] = 0;
        final String valueOf = String.valueOf(context.getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, 0).getLong("last_cfg_time", 0));
        String str = strArr[0];
        Listener anonymousClass10 = new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                Log.i(Constants.TAG, "Success url " + strArr[0] + IOUtils.LINE_SEPARATOR_UNIX + jSONObject.toString());
                networkListener.onNetworkSuccess(jSONObject);
            }
        };
        ErrorListener anonymousClass11 = new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                if (volleyError.getMessage() != null) {
                    Log.i(Constants.TAG, "Error url " + strArr[0]);
                    volleyError.printStackTrace();
                }
                int[] iArr = iArr;
                iArr[0] = iArr[0] + 1;
                if (iArr[0] < 2) {
                    DataServices.getDetailLesson(context, networkListener);
                }
            }
        };
        final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(str, null, anonymousClass10, anonymousClass11) {
            public Map<String, String> getHeaders() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put(AppConfig.REQ_HEADER_LAST_CFG_TIME, valueOf);
                if ("true".equals(DetailLessonActivity.fromWeb)) {
                    hashMap.put("X-book-type", DetailLessonActivity.xbookType);
                } else {
                    hashMap.put("X-book-type", AppConfig.getSPStringValue(context2, Constants.strXbookType));
                }
                return hashMap;
            }
        }, Constants.tag_service);
    }

    public static void getTag(final Context context, final NetworkListener networkListener) {
        final String str = Constants.SERVER + Constants.GET_EVENT + AppConfig.getSPStringValue(context, Constants.strItemIdHome);
        final String valueOf = String.valueOf(context.getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, 0).getLong("last_cfg_time", 0));
        final int[] iArr = new int[]{1};
        iArr[0] = 0;
        Listener anonymousClass13 = new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                System.out.println("Success url " + str + IOUtils.LINE_SEPARATOR_UNIX + jSONObject.toString());
                networkListener.onNetworkSuccess(jSONObject);
            }
        };
        ErrorListener anonymousClass14 = new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                if (volleyError.getMessage() != null) {
                    Log.i(Constants.TAG, "Error url " + str);
                    volleyError.printStackTrace();
                }
                int[] iArr = iArr;
                iArr[0] = iArr[0] + 1;
                if (iArr[0] < 2) {
                    DataServices.getTag(context, networkListener);
                }
            }
        };
        final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(str, null, anonymousClass13, anonymousClass14) {
            public Map<String, String> getHeaders() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put(AppConfig.REQ_HEADER_LAST_CFG_TIME, valueOf);
                hashMap.put("X-book-type", AppConfig.getSPStringValue(context2, Constants.strXbookType));
                return hashMap;
            }
        }, Constants.tag_service);
    }

    public static void viewSavePost(Context context, final NetworkListener networkListener) {
        String str = "http://www.json-generator.com/api/json/get/bUyuMfFCPS?indent=2";
        ApplicationController.getInstance().addToRequestQueue(new CachedNoExpiredJsonObjectRequest("http://www.json-generator.com/api/json/get/bUyuMfFCPS?indent=2", null, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                Log.i(Constants.TAG, "Success url http://www.json-generator.com/api/json/get/bUyuMfFCPS?indent=2\n" + jSONObject.toString());
                networkListener.onNetworkSuccess(jSONObject);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                Log.i(Constants.TAG, "Error url http://www.json-generator.com/api/json/get/bUyuMfFCPS?indent=2");
                volleyError.printStackTrace();
            }
        }), Constants.tag_service);
    }

    public static void getClass(Context context, final NetworkListener networkListener) {
        String str = "https://api.loigiaihay.com/v3/tags";
        final String valueOf = String.valueOf(context.getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, 0).getLong("last_cfg_time", 0));
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest("https://api.loigiaihay.com/v3/tags", null, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                Log.i(Constants.TAG, "Success url https://api.loigiaihay.com/v3/tags\n" + jSONObject.toString());
                networkListener.onNetworkSuccess(jSONObject);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                Log.i(Constants.TAG, "Error url https://api.loigiaihay.com/v3/tags");
                volleyError.printStackTrace();
            }
        }) {
            public Map<String, String> getHeaders() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put(AppConfig.REQ_HEADER_LAST_CFG_TIME, valueOf);
                hashMap.put("X-os", AbstractSpiCall.ANDROID_CLIENT_TYPE);
                return hashMap;
            }
        }, Constants.tag_service);
    }

    public static void getSearchCategory(final Context context, final NetworkListener networkListener) {
        String sPStringValue = AppConfig.getSPStringValue(context, Constants.strSearch);
        if (sPStringValue == null) {
            sPStringValue = "";
        }
        String sPStringValue2 = AppConfig.getSPStringValue(context, Constants.strItemId);
        String sPStringValue3 = AppConfig.getSPStringValue(context, Constants.strItemType);
        String sPStringValue4 = AppConfig.getSPStringValue(context, Constants.strPageSearch);
        Object obj = -1;
        switch (sPStringValue3.hashCode()) {
            case 49:
                if (sPStringValue3.equals("1")) {
                    obj = null;
                    break;
                }
                break;
            case 50:
                if (sPStringValue3.equals("2")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                urlRequest2 = "https://api.loigiaihay.com/v3/article/search?limit=8&page=" + sPStringValue4 + "&keyword=" + sPStringValue + "&catId=" + sPStringValue2;
                break;
            case 1:
                urlRequest2 = "https://api.loigiaihay.com/v3/article/search?limit=8&page=" + sPStringValue4 + "&keyword=" + sPStringValue + "&catId=" + sPStringValue2;
                break;
        }
        final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(urlRequest2, null, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                Log.i(Constants.TAG, "Success url " + DataServices.urlRequest2 + IOUtils.LINE_SEPARATOR_UNIX + jSONObject.toString());
                networkListener.onNetworkSuccess(jSONObject);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                Log.i(Constants.TAG, "Error url " + DataServices.urlRequest2);
                volleyError.printStackTrace();
                DataServices.getSearchCategory(context, networkListener);
            }
        }) {
            public Map<String, String> getHeaders() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("X-os", AbstractSpiCall.ANDROID_CLIENT_TYPE);
                hashMap.put("X-book-type", AppConfig.getSPStringValue(context2, Constants.strXbookType));
                return hashMap;
            }
        }, Constants.tag_service);
    }

    public static void getSubscribe(final Context context, final NetworkListener networkListener) {
        FirebaseApp.initializeApp(context);
        String token = FirebaseInstanceId.getInstance().getToken();
        String str = "https://api.loigiaihay.com/v3/subscribe";
        str = AppConfig.getSPStringValueClassAndObject(context, Constants.strItemType, "");
        String sPStringValueClassAndObject = AppConfig.getSPStringValueClassAndObject(context, Constants.strItemId, "");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reg_id", token);
            jSONObject.put(Param.TYPE, "1");
            jSONObject.put("item_type", str);
            jSONObject.put(FirebaseAnalytics.Param.ITEM_ID, sPStringValueClassAndObject);
            jSONObject.put("api_version", Integer.valueOf(VERSION.SDK));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
        }
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(1, "https://api.loigiaihay.com/v3/subscribe", jSONObject, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                try {
                    AppConfig.setSPStringValue(context, Constants.strSuccessRequestPost, jSONObject.getString(FirebaseAnalytics.Param.SUCCESS) + "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                networkListener.onNetworkSuccess(jSONObject);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                Log.i(Constants.TAG, "Error url " + DataServices.urlRequest);
                volleyError.printStackTrace();
            }
        }), Constants.tag_service);
    }

    public static void getListSearch(Context context, final NetworkListener networkListener) {
        String sPStringValueClassAndObject = AppConfig.getSPStringValueClassAndObject(context, Constants.strItemType, "");
        urlRequest = "http://api.loigiaihay.com/v3/items?item_type=" + sPStringValueClassAndObject + "&item_id=" + AppConfig.getSPStringValueClassAndObject(context, Constants.strItemId, "");
        final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(urlRequest, null, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                Log.i(Constants.TAG, "Success url " + DataServices.urlRequest + IOUtils.LINE_SEPARATOR_UNIX + jSONObject.toString());
                networkListener.onNetworkSuccess(jSONObject);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                Log.i(Constants.TAG, "Error url " + DataServices.urlRequest);
                volleyError.printStackTrace();
            }
        }) {
            public Map<String, String> getHeaders() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("X-os", AbstractSpiCall.ANDROID_CLIENT_TYPE);
                hashMap.put("X-book-type", AppConfig.getSPStringValue(context2, Constants.strXbookType));
                return hashMap;
            }
        }, Constants.tag_service);
    }

    public static void getConfig(Context context, final NetworkListener networkListener) {
        urlRequest = "http://api.loigiaihay.com/v3/config";
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(urlRequest, null, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                Log.i(Constants.TAG, "Success url " + DataServices.urlRequest + IOUtils.LINE_SEPARATOR_UNIX + jSONObject.toString());
                networkListener.onNetworkSuccess(jSONObject);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                Log.i(Constants.TAG, "Error url " + DataServices.urlRequest);
                volleyError.printStackTrace();
            }
        }), Constants.tag_service);
    }

    public static void getCapcha(Context context, final NetworkListener networkListener) {
        final String token = FirebaseInstanceId.getInstance().getToken();
        urlRequest = "https://api.loigiaihay.com/v3/feedback/captcha?token=" + token;
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(urlRequest, null, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                Log.i(Constants.TAG, "Success url " + DataServices.urlRequest + IOUtils.LINE_SEPARATOR_UNIX + jSONObject.toString());
                networkListener.onNetworkSuccess(jSONObject);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                Log.i(Constants.TAG, "Error url " + DataServices.urlRequest + InternalZipConstants.ZIP_FILE_SEPARATOR + token);
                volleyError.printStackTrace();
            }
        }), Constants.tag_service);
    }

    public static void putComment(final Context context, final NetworkListener networkListener) {
        String sPStringValue = AppConfig.getSPStringValue(context, Constants.strDetaiComment);
        String sPStringValue2 = AppConfig.getSPStringValue(context, Constants.strInfoComment);
        String sPStringValue3 = AppConfig.getSPStringValue(context, Constants.strCaptchaComment);
        String sPStringValue4 = AppConfig.getSPStringValue(context, Constants.strItemType);
        String sPStringValue5 = AppConfig.getSPStringValue(context, Constants.strItemId);
        String sPStringValue6 = AppConfig.getSPStringValue(context, Constants.strTitleClass);
        String sPStringValue7 = AppConfig.getSPStringValue(context, Constants.strTitleObject);
        String str = "https://api.loigiaihay.com/v3/feedback/add";
        String token = FirebaseInstanceId.getInstance().getToken();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("notify_token", token);
            jSONObject.put("user_feedback", sPStringValue);
            jSONObject.put("contact_info", sPStringValue2);
            jSONObject.put("captcha", sPStringValue3);
            jSONObject.put("home_category", "Lớp " + sPStringValue6 + " - " + sPStringValue7);
            jSONObject.put("refer_item_id", sPStringValue5);
            jSONObject.put("refer_item_type", sPStringValue4);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
        }
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(1, "https://api.loigiaihay.com/v3/feedback/add", jSONObject, new Listener<JSONObject>() {
            public void onResponse(JSONObject jSONObject) {
                System.out.println("Success url https://api.loigiaihay.com/v3/feedback/add\n" + jSONObject.toString());
                try {
                    if (jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE).equals("Mã captcha không đúng")) {
                        Toast.makeText(context, "Mã số không đúng!", 0).show();
                    } else {
                        Toast.makeText(context, "Đã gửi phản hồi thành công!", 0).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                networkListener.onNetworkSuccess(jSONObject);
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                networkListener.onNetworkError();
                Log.i(Constants.TAG, "Error url https://api.loigiaihay.com/v3/feedback/add");
                volleyError.printStackTrace();
            }
        }), Constants.tag_service);
    }

    public static void luuThongTinMuaMonHoc(Context context, final NetworkListener networkListener) {
        final String sPStringValue = AppConfig.getSPStringValue(context, Constants.strItemIdMonTai);
        String str = "https://api.loigiaihay.com/v3/categories/saveOrder";
        final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new StringRequest(1, "https://api.loigiaihay.com/v3/categories/saveOrder", new Listener<String>() {
            public void onResponse(String str) {
                System.out.println("Success url https://api.loigiaihay.com/v3/categories/saveOrder\n" + str.toString());
                try {
                    networkListener.onNetworkSuccess(new JSONObject(str.toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                VolleyLog.d("volley", new Object[]{"Error: " + volleyError.getMessage()});
                volleyError.printStackTrace();
            }
        }) {
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            public Map<String, String> getHeaders() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("X-book-type", AppConfig.getSPStringValue(context2, Constants.strXbookType));
                return hashMap;
            }

            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("dataSignature", AppConfig.getSPStringValue(context2, Constants.signatures));
                hashMap.put("purchaseData", AppConfig.getSPStringValue(context2, Constants.purchaseData));
                hashMap.put(FirebaseAnalytics.Param.ITEM_ID, sPStringValue);
                hashMap.put("subject_title", AppConfig.getSPStringValue(context2, Constants.fileNameSlideChange));
                hashMap.put("for_class", AppConfig.getSPStringValue(context2, Constants.strNumberClass));
                hashMap.put("item_type", "1");
                hashMap.put("ccCode", "khongcan");
                hashMap.put("email", AppConfig.getSPStringValueClassAndObject(context2, Constants.emailOder, "không có"));
                return hashMap;
            }
        }, Constants.tag_service);
    }

    public static void luuThongTinMuaCalop(final Context context, final NetworkListener networkListener) {
        AppConfig.getSPStringValue(context, Constants.strItemIdMonTai);
        String str = "https://api.loigiaihay.com/v3/categories/saveOrder";
        final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new StringRequest(1, "https://api.loigiaihay.com/v3/categories/saveOrder", new Listener<String>() {
            public void onResponse(String str) {
                System.out.println("Success url https://api.loigiaihay.com/v3/categories/saveOrder\n" + str.toString());
                try {
                    JSONObject jSONObject = new JSONObject(str.toString());
                    networkListener.onNetworkSuccess(jSONObject);
                    JSONArray jSONArray = jSONObject.getJSONObject("zip_status").getJSONArray("sub_items");
                    DataServices.listItemId = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        DataServices.listItemId.add(jSONArray.getJSONObject(i).getString(TtmlNode.ATTR_ID));
                    }
                    AppConfig.setSPStringValue(context, Constants.listItemIdSize, DataServices.listItemId.size() + "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                VolleyLog.d("volley", new Object[]{"Error: " + volleyError.getMessage()});
                volleyError.printStackTrace();
            }
        }) {
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("dataSignature", AppConfig.getSPStringValue(context2, Constants.signatures));
                hashMap.put("purchaseData", AppConfig.getSPStringValue(context2, Constants.purchaseData));
                hashMap.put("subject_title", "Lớp " + AppConfig.getSPStringValue(context2, Constants.strNumberClass));
                hashMap.put("for_class", AppConfig.getSPStringValue(context2, Constants.strNumberClass));
                hashMap.put("ccCode", "chuaco");
                hashMap.put("X-book-type", AppConfig.getSPStringValue(context2, Constants.strXbookType));
                hashMap.put("orderType", "2");
                hashMap.put("email", AppConfig.getSPStringValueClassAndObject(context2, Constants.emailOder, "không có"));
                return hashMap;
            }
        }, Constants.tag_service);
    }

    public static void checkMonHoc(Context context, final NetworkListener networkListener) {
        AppConfig.getSPStringValue(context, Constants.strItemIdMonTai);
        String str = "https://api.loigiaihay.com/v3/zip/checkCategoryZipStatus";
        final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new StringRequest(1, "https://api.loigiaihay.com/v3/zip/checkCategoryZipStatus", new Listener<String>() {
            public void onResponse(String str) {
                System.out.println("Success url https://api.loigiaihay.com/v3/zip/checkCategoryZipStatus\n" + str.toString());
                try {
                    JSONObject jSONObject = new JSONObject(str.toString());
                    networkListener.onNetworkSuccess(jSONObject);
                    jSONObject = jSONObject.getJSONObject("zip_status");
                    if (jSONObject.has("sub_items")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("sub_items");
                        DataServices.listItemId = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            DataServices.listItemId.add(jSONArray.getJSONObject(i).getString(TtmlNode.ATTR_ID));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                NetworkResponse networkResponse = volleyError.networkResponse;
                if (!(networkResponse == null || networkResponse.data == null)) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(networkResponse.data));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                VolleyLog.d("volley", new Object[]{"Error: " + volleyError.getMessage()});
                volleyError.printStackTrace();
            }
        }) {
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("orderId", AppConfig.getSPStringValue(context2, Constants.strOrderId));
                hashMap.put("purchaseToken", AppConfig.getSPStringValue(context2, Constants.purchaseToken));
                return hashMap;
            }
        }, Constants.tag_service);
    }

    public static void restoreMonHoc(Context context, final NetworkListener networkListener) {
        String str = "https://api.loigiaihay.com/v3/categories/restoreOrder";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("list_order_ids", CacMonDaTaiOffline.listOrderId);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
        }
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(1, "https://api.loigiaihay.com/v3/categories/restoreOrder", jSONObject, new Listener<JSONObject>() {
            /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /*public void onResponse(JSONObject jSONObject) {
        System.out.println("Success url https://api.loigiaihay.com/v3/categories/restoreOrder\n" + jSONObject.toString());
        try {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        networkListener.onNetworkSuccess(jSONObject);
    }
}, new ErrorListener() {
public void onErrorResponse(VolleyError volleyError) {
        networkListener.onNetworkError();
        Log.i(Constants.TAG, "Error url https://api.loigiaihay.com/v3/categories/restoreOrder");
        volleyError.printStackTrace();
        }
        }), Constants.tag_service);
        }*/

/*public static void getLinkBaiOffline(Context context, final NetworkListener networkListener) {
        urlRequest = "https://api.loigiaihay.com/v3/zip/checkArticleZipStatus?articleId=" + AppConfig.getSPStringValue(context, Constants.strIdAr);
final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(urlRequest, null, new Listener<JSONObject>() {
public void onResponse(JSONObject jSONObject) {
        Log.i(Constants.TAG, "Success url " + DataServices.urlRequest + IOUtils.LINE_SEPARATOR_UNIX + jSONObject.toString());
        networkListener.onNetworkSuccess(jSONObject);
        }
        }, new ErrorListener() {
public void onErrorResponse(VolleyError volleyError) {
        networkListener.onNetworkError();
        Log.i(Constants.TAG, "Error url " + DataServices.urlRequest);
        volleyError.printStackTrace();
        }
        }) {
public Map<String, String> getHeaders() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("X-book-type", AppConfig.getSPStringValue(context2, Constants.strXbookType));
        hashMap.put("X-os", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        return hashMap;
        }
        }, Constants.tag_service);
        }*/

/*public static void gopYBaoLoi(final Context context, final NetworkListener networkListener, String str, String str2, String str3) {
        String str4 = "https://api.loigiaihay.com/v3/feedback/report";
        JSONObject jSONObject = new JSONObject();
        try {
        jSONObject.put("type_feedback", str);
        jSONObject.put(FirebaseAnalytics.Param.CONTENT, str2);
        jSONObject.put("post_id", str3);
        jSONObject.put("cat_id", AppConfig.getSPStringValue(context, Constants.strItemId));
        } catch (JSONException e) {
        e.printStackTrace();
        } catch (NullPointerException e2) {
        }*/
/*final Context context2 = context;
        ApplicationController.getInstance().addToRequestQueue(new JsonObjectRequest(1, "https://api.loigiaihay.com/v3/feedback/report", jSONObject, new Listener<JSONObject>() {
public void onResponse(JSONObject jSONObject) {
        try {
        if (jSONObject.getString(FirebaseAnalytics.Param.SUCCESS).equals("true")) {
        Toast.makeText(context, "Đã gửi báo cáo thành công!", 0).show();
        } else {
        Toast.makeText(context, "Chưa gửi được báo cáo!", 0).show();
        }
        } catch (JSONException e) {
        e.printStackTrace();
        }
        networkListener.onNetworkSuccess(jSONObject);
        }
        }, new ErrorListener() {*/
/*public void onErrorResponse(VolleyError volleyError) {
        networkListener.onNetworkError();
        Log.i(Constants.TAG, "Error url https://api.loigiaihay.com/v3/feedback/report");
        volleyError.printStackTrace();
        }
        }) {*/
/*public Map<String, String> getHeaders() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("X-book-type", AppConfig.getSPStringValue(context2, Constants.strXbookType));
        hashMap.put("X-os", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        return hashMap;
        }
        }, Constants.tag_service);
        }
        }*/
        
}
