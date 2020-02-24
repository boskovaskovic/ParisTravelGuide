package com.bvinstruments.paristravelguide;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class SplashScreen extends AppCompatActivity {

    private ImageView splash_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);

        splash_picture=(ImageView)findViewById(R.id.splash_picture);
        Animation anim= AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        splash_picture.startAnimation(anim);
        new MainLoader().execute();


    }




    private  class MainLoader extends AsyncTask<Void,Void,Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1000);
                Intent tabbed_activity=new Intent(getBaseContext(),TabActivity.class);

                startActivity(tabbed_activity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();



        }

        @Override
        protected void onPostExecute(Void result){

            super.onPostExecute(result);
            System.out.print("hi");


        }


    }


}
