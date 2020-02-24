package com.bvinstruments.paristravelguide;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bvinstruments.paristravelguide.activities.Restaurants;

public class MainActivity extends AppCompatActivity {

    private CardView restaurants_button;
    private CardView atms_button;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
activity=this;

        restaurants_button=findViewById(R.id.restaurants_button);
        atms_button=findViewById(R.id.atms_button);

        atms_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(v.getContext(),ItemActivity.class);
                v.getContext().startActivity(i);


            }
        });

        restaurants_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getBaseContext(), Restaurants.class);
                startActivity(i);

            }
        });

       // new NewsDownloaderTask().execute();



    }





}
