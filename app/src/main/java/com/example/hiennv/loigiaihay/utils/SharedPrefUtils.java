package com.example.hiennv.loigiaihay.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPrefUtils(Context context) {
        sharedPreferences = context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void putBoolean(String key, boolean value) {

        editor.putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value).apply();
    }

    public int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public void putLong(String key, long value) {
        editor.putLong(key, value).apply();
    }

    public long getLong(String key, long defValue) {
        return sharedPreferences.getLong(key, defValue);
    }

    public void putString(String key, String value) {
        editor.putString(key, value).apply();
    }

    public String getString(String key, String defValue){
        return sharedPreferences.getString(key, defValue);
    }

    public void putFloat(String key, float value){
        editor.putFloat(key, value).apply();
    }

    public float getFloat(String key, float defValue){
        return sharedPreferences.getFloat(key, defValue);
    }
}
