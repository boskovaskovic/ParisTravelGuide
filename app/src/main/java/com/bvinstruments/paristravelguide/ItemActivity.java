package com.bvinstruments.paristravelguide;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.bvinstruments.paristravelguide.clients.ParisWebViewClient;

public class ItemActivity extends AppCompatActivity {


    public static String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        WebView view=findViewById(R.id.web_view);
        WebSettings settings=view.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportMultipleWindows(true);
        ParisWebViewClient client=new ParisWebViewClient(this);
        view.setWebViewClient(client);
        view.loadUrl("https://www.google.com");



    }
}