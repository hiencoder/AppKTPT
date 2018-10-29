package com.example.hiennv.loigiaihay.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.ui.Main2Activity;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.ui.changeclass.ChangeClassActivity;
import com.example.hiennv.loigiaihay.ui.home.MainActivity;
import com.example.hiennv.loigiaihay.ui.intro.IntroActivity;
import com.example.hiennv.loigiaihay.utils.AppConstants;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;


public class SplashActivity extends BaseActivity {
    private boolean isFirstLaunch;
    private String classId;
    private String classTitle;
    private String subjectId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        sharedPrefUtils = new SharedPrefUtils(this);
        isFirstLaunch = sharedPrefUtils.getBoolean(AppConstants.IS_FIRST_LAUNCH, true);
        classId = sharedPrefUtils.getString(AppConstants.KEY_CLASS_ID, "");
        classTitle = sharedPrefUtils.getString(AppConstants.KEY_CLASS_TITLE, "");
        subjectId = sharedPrefUtils.getString(AppConstants.KEY_SUBJECT_ID, "");

        if (isFirstLaunch) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, IntroActivity.class));
                    finish();
                }
            }, 2000);
        } else {
            if (subjectId != null && !subjectId.equals("")) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //open main
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    }
                }, 2000);
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, ChangeClassActivity.class));
                        finish();
                    }
                }, 2000);
            }

        }
    }

    @Override
    protected void setUpToolbar() {

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
