package com.example.hiennv.loigiaihay.ui.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

@SuppressLint("AppCompatCustomView")
public class MyAutoCompleteTextView extends AutoCompleteTextView {
    private static final int DEFAULT_AUTOCOMPLETE_DELAY = 100;
    private static final int MESSAGE_TEXT_CHANGED = 100;
    private int mAutoCompleteDelay = 100;
    private final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            MyAutoCompleteTextView.super.performFiltering((CharSequence)msg.obj,msg.arg1);
        }
    };

    private ProgressBar mProgressBar;

    public void setProgressBar(ProgressBar progressBar){
        this.mProgressBar = progressBar;
    }

    public void setAutoCompleteDelay(int autoCompleteDelay) {
        this.mAutoCompleteDelay = autoCompleteDelay;
    }

    @Override
    protected void performFiltering(CharSequence text, int keyCode) {
        if (mProgressBar != null){
            mProgressBar.setVisibility(VISIBLE);
        }
        handler.removeMessages(MESSAGE_TEXT_CHANGED);
        handler.sendMessageDelayed(handler.obtainMessage(100,text),mAutoCompleteDelay);
    }

    @Override
    public void onFilterComplete(int count) {
        if (mProgressBar != null){
            mProgressBar.setVisibility(GONE);
        }
        super.onFilterComplete(count);
    }

    public MyAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
