package com.example.hiennv.loigiaihay.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.home.MainActivity;
import com.example.hiennv.loigiaihay.ui.intro.IntroActivity;
import com.example.hiennv.loigiaihay.ui.listclass.ListClassActivity;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

public class SplashActivity extends BaseActivity {
    private SharedPrefUtils sharedPrefUtils;
    private boolean isFirstLaunch;
    private String className;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        sharedPrefUtils = new SharedPrefUtils(this);
        isFirstLaunch = sharedPrefUtils.getBoolean(AppConstants.IS_FIRST_LAUNCH, true);
        className = sharedPrefUtils.getString(AppConstants.KEY_CLASS_NAME, "");
        if (isFirstLaunch) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, IntroActivity.class));
                }
            }, 2000);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (className != null && !className.equals("")) {
                        //open main
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    } else {
                        //Open list
                        startActivity(new Intent(SplashActivity.this, ListClassActivity.class));
                    }
                }
            }, 2000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
