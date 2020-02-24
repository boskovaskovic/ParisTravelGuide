package com.bvinstruments.paristravelguide;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Settings_activity extends PreferenceActivity  {

    private ListPreference list;
    private CheckBoxPreference check_box;
    private SharedPreferences.OnSharedPreferenceChangeListener listener;
    private Context x;
    private static final String LANGUAGE_PREFERENCE_KEY = "languageType";
    private static final String CACHING_NEWS_DATA_PREFERENCE_KEY = "applicationCaching";
    public String languagePref_ID;
    public String languageDE="de";
    public String languageEN="en";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("change_language_pref", MODE_PRIVATE);
        String localePref = sharedPreferences.getString("locale","en");
        Locale locale = new Locale(localePref);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        addPreferencesFromResource(R.xml.activity_settings_activity);
        list= (ListPreference) findPreference("change_language_pref");
        check_box=(CheckBoxPreference)findPreference("cache_option");

        if("en".equals(localePref)){
            list.setValue(languageEN);
        }else{
            list.setValue(languageDE);
        }

        list.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                Locale locale = new Locale("de","DE");


                Locale.setDefault(locale);
                Resources resources = getResources();
                Configuration configuration = resources.getConfiguration();
                configuration.locale = locale;
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());

                SharedPreferences sharedPreferences = getSharedPreferences("change_language_pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("locale", locale.getLanguage());
                editor.apply();
                resetActivity();

                return false;
            }
        });
    }
    private void resetActivity(){
        Intent intent = new Intent(getApplicationContext(),TabActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    public static Locale getCurrentLocale(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return context.getResources().getConfiguration().getLocales().get(0);
        } else{
            return context.getResources().getConfiguration().locale;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        resetActivity();
    }
}
