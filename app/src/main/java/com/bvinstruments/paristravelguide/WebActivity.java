package com.bvinstruments.paristravelguide;

import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {
    private WebView web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        web_view=findViewById(R.id.web_view_element);
        if(isNetworkConnected()){

            web_view.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return false;
                }
            });
            final String url=getIntent().getStringExtra("url");
            web_view.getSettings().setJavaScriptEnabled(true);
            web_view.loadUrl(url);

        }else {

            Toast.makeText(this,"Can not load data. Please check your internet connection!",Toast.LENGTH_SHORT).show();
    onBackPressed();
        }

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
