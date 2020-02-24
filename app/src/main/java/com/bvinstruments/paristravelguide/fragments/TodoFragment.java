package com.bvinstruments.paristravelguide.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bvinstruments.paristravelguide.ItemActivity;
import com.bvinstruments.paristravelguide.R;
import com.bvinstruments.paristravelguide.activities.Restaurants;
import com.bvinstruments.paristravelguide.handlers.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TodoFragment extends Fragment {

    private View view;

    private CardView restaurants_button;
    private CardView atms_button;
    private Activity activity;


    public TodoFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_todo,container,false);
        loadStart();
        return view;
    }


private void loadStart(){

    restaurants_button=view.findViewById(R.id.restaurants_button);
    atms_button=view.findViewById(R.id.atms_button);

    atms_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent i=new Intent(v.getContext(), ItemActivity.class);
            v.getContext().startActivity(i);


        }
    });

    restaurants_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent i=new Intent(v.getContext(), Restaurants.class);
            startActivity(i);

        }
    });
}

    private  class NewsDownloaderTask extends AsyncTask<Void,Void,Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler handler=new HttpHandler();
            String data= null;
            try {
                data = handler.getData();
                JSONObject ob=new JSONObject(data);
                JSONArray ar=ob.getJSONArray("articles");
                System.out.println("Velicina: "+ar.length());
                System.out.println(ob.toString());
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getView().getContext(),"We are getting relevant news for Paris...",Toast.LENGTH_LONG).show();



        }

        @Override
        protected void onPostExecute(Void result){

            super.onPostExecute(result);
            System.out.print("hi");


        }


    }



}
