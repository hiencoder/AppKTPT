package com.example.hiennv.loigiaihay.app;

import android.app.Application;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.utils.AppLogger;
import com.squareup.leakcanary.LeakCanary;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AppLogger.init(this);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);

    }
}
