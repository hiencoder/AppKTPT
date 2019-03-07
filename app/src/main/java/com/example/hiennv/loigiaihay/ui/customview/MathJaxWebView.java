package com.example.hiennv.loigiaihay.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class MathJaxWebView extends WebView {
    public MathJaxWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        clearCache(true);
        //getSettings().setCacheMode(CacheMo);
    }
}
