package com.example.hiennv.loigiaihay.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {
    private SharedPreferences sharedPreferences;

    public SharedPrefUtils(Context context) {
        sharedPreferences = context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key,value).apply();
    }

    public boolean getBoolean(String key, boolean defValue){
        return sharedPreferences.getBoolean(key,defValue);
    }

    public void putInt(String key, int value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key,value);
    }

    public int getInt(String key, int defValue){
        return sharedPreferences.getInt(key, defValue);
    }

    public void putLong(String key, long value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
    }
}
