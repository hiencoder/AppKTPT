package com.example.hiennv.loigiaihay.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class MathJaxWebView extends WebView {
    public MathJaxWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        clearCache(true);
        getSettings().setCacheMode(-1);
        setBackgroundColor(0);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setBuiltInZoomControls(false);
        setHorizontalScrollBarEnabled(false);
    }

    public MathJaxWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MathJaxWebView(Context context) {
        super(context);
    }

    public void setText(String str) {
        loadDataWithBaseURL("http://bar", "<head><style>img{max-width:100%}\r\naudio{background:#2888e1;padding:10px;height: 47px;}</style><script type=\"text/x-mathjax-config\">MathJax.Hub.Config({\n              showMathMenu: false,\n                messageStyle: \"none\",\n                     SVG: {\n                          scale: 120,\n                          linebreaks: {\n                              automatic: true\n                          }\n                     },\n                     \"HTML-CSS\": { linebreaks: { automatic: true } },\n                      CommonHTML: { linebreaks: { automatic: true } },\n            tex2jax: {\n                   inlineMath: [ ['$','$'], [\"\\\\(\",\"\\\\)\"] ]\n            }\n            });MathJax.Hub.Queue(function () {    document.getElementById(\"hide_page\").style.visibility = \"\";  });</script><script type=\"text/javascript\" async src=\"file:///android_asset/MathJax/MathJax.js?config=TeX-AMS-MML_HTMLorMML\"></script></head><body style=\"text-align:justify\">" + str + "</body></html>", AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, "");
    }
}