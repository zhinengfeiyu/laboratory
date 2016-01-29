package com.example.mylaboratory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by ShineMo-177 on 2015/12/28.
 */
public class StyleTestActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style_test_activity);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        webView = new WebView(this);
        webView.setLayoutParams(params);
        layout.addView(webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.baidu.com");
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        }
        else {
            finish();
        }
    }
}
