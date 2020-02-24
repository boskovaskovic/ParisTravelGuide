package com.bvinstruments.paristravelguide;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.request.RequestOptions;
import com.bvinstruments.paristravelguide.adapters.ViewPagerAdapter;
import com.bvinstruments.paristravelguide.fragments.EventsFragment;
import com.bvinstruments.paristravelguide.fragments.MapFragment;
import com.bvinstruments.paristravelguide.fragments.NewsFragment;
import com.bvinstruments.paristravelguide.fragments.ParisFragment;
import com.bvinstruments.paristravelguide.fragments.TodoFragment;
import com.bvinstruments.paristravelguide.model.Forecast;
import com.bvinstruments.paristravelguide.sql.DBHandler;
import com.bvinstruments.paristravelguide.util.DataLoader;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TabActivity extends AppCompatActivity {

    private TabLayout tab_layout;
    private ViewPager view_pageer;
    private AppBarLayout tabbed_app_bar;
    private TextView weather_date;
   // private TextView weather_city;
    private TextView weather_description;
    private ImageView weather_picture;
    private TextView weather_celsius_big;
    private TextView weather_humidity;
    private TextView weather_wind_speed;
    private TextView weather_pressure;
    private DBHandler dbHandler;
    private Button settings_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("change_language_pref", MODE_PRIVATE);
        String localePref = sharedPreferences.getString("locale", "en");
        Locale locale = new Locale(localePref);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_tab);
        dbHandler=new DBHandler(this);
        DataLoader.loadRestaurants(this);
        DataLoader.loadEvents(this);
        DataLoader.loadHotels(this);
        DataLoader.loadCultures(this);


        tab_layout=findViewById(R.id.tab_layout);
        view_pageer=findViewById(R.id.view_pager);
        tabbed_app_bar=findViewById(R.id.tabbed_app_bar);
       // weather_city=findViewById(R.id.weather_city);
        weather_date=findViewById(R.id.weather_date);
        loadDate();
        weather_description=findViewById(R.id.weather_description);
       weather_humidity=findViewById(R.id.weather_humidity);
       weather_wind_speed=findViewById(R.id.wind_speed);
       weather_pressure=findViewById(R.id.pressure);
weather_celsius_big=findViewById(R.id.weather_celsius);
        weather_picture=findViewById(R.id.weather_picture);
        settings_button=findViewById(R.id.settings_button);
        settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(v.getContext(),Settings_activity.class);

                v.getContext().startActivity(i);


            }
        });


        ViewPagerAdapter adapter =new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new ParisFragment(),"Paris");
        adapter.addFragment(new NewsFragment(),getResources().getString(R.string.news));
        adapter.addFragment(new MapFragment(),getResources().getString(R.string.map));
        adapter.addFragment(new EventsFragment(),this.getResources().getString(R.string.events));


        view_pageer.setAdapter(adapter);
    tab_layout.setupWithViewPager(view_pageer);
    if(isNetworkConnected())
    new WeatherService().execute();
    else {

loadLatestForecast();

    }


    }


    @Override
    public void onBackPressed(){
       finish();




    }

    private  class WeatherService extends AsyncTask<Void,Void,Void> {

   private final String weather_id="http://api.openweathermap.org/data/2.5/weather?q=Paris&appid=be8126490c8b433a278c4935a68ebc6b&units=metric";
   private final String celsius="\u2103";
        @Override
        protected Void doInBackground(Void... voids) {
            JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, weather_id, null, new Response.Listener<JSONObject>() {
              RequestOptions option=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
                @Override
                public void onResponse(JSONObject response) {
                    try{

                        JSONObject main_object=response.getJSONObject("main");
                        JSONObject main_object2=response.getJSONObject("wind");
                        JSONArray niz=response.getJSONArray("weather");
                        JSONObject object=niz.getJSONObject(0);

                        //weather_city.setText(response.get("name").toString());
                        weather_description.setText(object.getString("description"));
                        weather_celsius_big.setText(String.valueOf(main_object.getDouble("temp"))+celsius);
                        weather_humidity.setText(getResources().getString(R.string.humidity)+": "+String.valueOf(main_object.getDouble("humidity"))+" %");
                        weather_pressure.setText(getResources().getString(R.string.pressure)+": "+String.valueOf(main_object.getDouble("pressure"))+" Pa");
                        weather_wind_speed.setText(getResources().getString(R.string.wind_speed)+": "+String.valueOf(main_object2.getDouble("speed")+" km/h"));
                        weather_wind_speed.setSelected(true);
                        Forecast f=new Forecast(main_object.getDouble("humidity"),main_object2.getDouble("speed"),main_object.getDouble("pressure"),
                                main_object.getDouble("temp"),object.getString("description"));
                        dbHandler.insertForecastData(f);
                  Picasso.with(getBaseContext())
                          .load("http://openweathermap.org/img/w/"+object.getString("icon")+".png")
                          .into(weather_picture);


                        Animation anim= AnimationUtils.loadAnimation(getBaseContext(), R.anim.splash_transition);
                        anim.setDuration(1500);
                        weather_picture.startAnimation(anim);
                        loadDate();




                    }catch(JSONException e){e.printStackTrace();}


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {



                }
            });
            RequestQueue queue= Volley.newRequestQueue(getBaseContext());
            queue.add(request);
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();




        }

        @Override
        protected void onPostExecute(Void result){

            super.onPostExecute(result);



        }



    }

    private void loadDate(){

        String date=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());


        weather_date.setText(date);
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    private void loadLatestForecast(){
      final String celsius="\u2103";
        Forecast f=dbHandler.getLatestForecast();
        if(f!=null){
            weather_description.setText(f.getDescription());
            weather_celsius_big.setText(f.getTemperature()+celsius);
            weather_humidity.setText("Humidity: "+f.getHumidity()+" %");
            weather_pressure.setText("Pressure: "+f.getPressure()+" Pa");
            weather_wind_speed.setText("Wind speed: "+f.getWindspeed()+" km/h");
        }else {

            Toast.makeText(this,"Can not load weather data. Please check your internet connection!",Toast.LENGTH_SHORT).show();
weather_description.setText("No internet connection.");
        }




    }


}
