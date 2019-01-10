package com.example.hiennv.loigiaihay.ui.base;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.hiennv.loigiaihay.app.MyApplication;
import com.example.hiennv.loigiaihay.receiver.NetworkReceiver;
import com.example.hiennv.loigiaihay.utils.SharedPrefUtils;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity
        implements NetworkReceiver.ConnectivityReceiverListener {
    public static final String TAG = BaseActivity.class.getSimpleName();
    protected boolean isNetworkConnected;
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
        setColorStatusBar();
        initData();
        initEvents();
    }

    //Set color for status bar and navigation bar
    protected void setColorStatusBar(){
        if (Build.VERSION.SDK_INT >= 21){
            //get window
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            //Set color for status bar
            window.setStatusBarColor(Color.parseColor("#9E9E9E"));
            //set color for navigation bar
            window.setNavigationBarColor(Color.parseColor("#000000"));
        }
    }

    //Hide keyboard
    protected void hideKeyboard(){
        View currentFocus = getCurrentFocus();
        if (currentFocus != null){
            ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(currentFocus.getWindowToken(),
                            InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
    }

//    https://stackoverflow.com/questions/4165414/how-to-hide-soft-keyboard-on-android-after-clicking-outside-edittext?rq=1
    //Check network
    protected boolean checkNetwork(){
        if (((ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo() != null){
            return true;
        }
        return false;
    }
    @Override
    protected void onResume() {
        super.onResume();
        //register connection status listener
        MyApplication.getInstance().setConnectivityListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if (!isConnected){
            Toast.makeText(this, "No connection!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Connecting", Toast.LENGTH_SHORT).show();
        }
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
