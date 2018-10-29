package com.example.hiennv.loigiaihay.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity{
    protected abstract int getLayoutId();
    protected abstract void initData();
    protected abstract void setUpToolbar();
    protected abstract void initEvents();
    protected SharedPrefUtils sharedPrefUtils;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setUpToolbar();
        initData();
        initEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
