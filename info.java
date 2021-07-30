package com.example.visual_air;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://www.nrdc.org/stories/air-pollution-everything-you-need-know");
    }
}