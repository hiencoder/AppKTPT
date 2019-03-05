package com.example.hiennv.loigiaihay.utils;

import android.content.Context;

import com.example.hiennv.loigiaihay.BuildConfig;
import com.facebook.stetho.Stetho;

import timber.log.Timber;

public class AppLogger {
    public static void init(Context context) {
        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
            Stetho.initializeWithDefaults(context);
        }else {

        }
    }

    public static void d(String s, Object... objects) {
        Timber.d(s, objects);
    }

    public static void d(Throwable t, String s, Object... objects) {
        Timber.d(t, s, objects);
    }

    public static void e(String s, Object... objects){
        Timber.e(s, objects);
    }

    public static void e(Throwable t, String s, Object... objects){
        Timber.e(t, s, objects);
    }

    public static void i(String s, Object... objects){
        Timber.i(s, objects);
    }

    public static void i(Throwable t, String s, Object... objects){
        Timber.i(t, s, objects);
    }

    public static void w(String s, Object... objects){
        Timber.w(s, objects);
    }

    public static void w(Throwable t, String s, Object... objects){
        Timber.w(t, s, objects);
    }
}
