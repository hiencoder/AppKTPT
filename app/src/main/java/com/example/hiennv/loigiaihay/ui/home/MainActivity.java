package com.example.hiennv.loigiaihay.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.ui.base.BaseActivity;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

public class MainActivity extends BaseActivity {
    //https://stackoverflow.com/questions/33284812/android-change-navigation-drawer-menu-items-text-programmatically
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private SharedPrefUtils sharedPrefUtils;
    @Override
    protected void initData() {
        sharedPrefUtils = new SharedPrefUtils(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
