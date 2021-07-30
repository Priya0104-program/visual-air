package com.example.visual_air;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class bpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpage);

        WebView w = (WebView) findViewById(R.id.web);


        w.loadUrl("https://industrial.ubidots.com/app/dashboards/public/widget/fzLPPK3EeI9pR4jGrdwz2pMBCypjF-aD8teLs59uq48?embed=true");

        w.getSettings().setJavaScriptEnabled(true);


        w.setWebViewClient(new WebViewClient());
    }
}