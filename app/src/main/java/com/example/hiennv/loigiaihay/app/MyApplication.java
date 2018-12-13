package com.example.hiennv.loigiaihay.app;

import android.app.Application;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.receiver.NetworkReceiver;
import com.example.hiennv.loigiaihay.utils.AppLogger;
import com.squareup.leakcanary.LeakCanary;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MyApplication extends Application{
    private static MyApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
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

    public static synchronized MyApplication getInstance(){
        return mInstance;
    }

    public void setConnectivityListener(NetworkReceiver.ConnectivityReceiverListener connectivityListener){
        NetworkReceiver.connectivityReceiverListener = connectivityListener;
    }
}
