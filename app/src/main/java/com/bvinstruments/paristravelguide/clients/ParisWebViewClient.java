package com.bvinstruments.paristravelguide.clients;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URI;

public class ParisWebViewClient extends WebViewClient {

    private Context activity;

    public ParisWebViewClient(Context context){

this.activity=activity;

    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url){

        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(i);

        return false;
    }
}
