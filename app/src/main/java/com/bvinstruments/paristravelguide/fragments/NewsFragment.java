package com.bvinstruments.paristravelguide.fragments;

import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bvinstruments.paristravelguide.R;
import com.bvinstruments.paristravelguide.adapters.NewsItemAdapter;
import com.bvinstruments.paristravelguide.items.ListItem;
import com.bvinstruments.paristravelguide.items.NewsItem;
import com.bvinstruments.paristravelguide.sql.DBHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    private View view;
    private List<ListItem> lista;
    private RecyclerView recyclerView;
    private NewsItemAdapter adapter;
    private SwipeRefreshLayout refresh_layout;
    private EditText search_box;
      private DBHandler handler;

    public NewsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_news,container,false);
        handler=new DBHandler(this.getContext());


        refresh_layout=view.findViewById(R.id.on_swipe_layout);
        lista=new ArrayList<>();
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        adapter=new NewsItemAdapter(getContext(),lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        search_box=view.findViewById(R.id.search_box);
        search_box.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
      // loadNews();
        refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                loadNews();

            }
        });

        return view;
    }


    private  class NewsDownloaderTask extends AsyncTask<Void,Void,Void> {

        private final String news_id="https://newsapi.org/v2/everything?q=paris+france&pageSize=100&apiKey=968491bb00f3402e8315a2099ba56ac3";

        @Override
        protected Void doInBackground(Void... voids) {

            JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, news_id, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    try{

                        JSONArray niz=response.getJSONArray("articles");
                        for(int i=0;i<100;i++){

                            JSONObject object=niz.getJSONObject(i);
                            JSONObject source=object.getJSONObject("source");
                            String news_source=source.getString("name");
                            String urlToImage=object.getString("urlToImage");

                            String publishedAt=object.getString("publishedAt");
                            String content=object.getString("content");
                            System.out.println(content);
                            String url=object.getString("url");
                            String title=object.getString("title");
                            String author=object.getString("author");
                            String description=object.getString("description");



                            ListItem item=new NewsItem(urlToImage,title,description,news_source,author,url,publishedAt,content);
                            lista.add(item);
                            adapter.notifyDataSetChanged();

                        }



                       /* weather_city.setText(response.get("name").toString());
                        weather_description.setText(object.getString("description"));
                        weather_celsius_big.setText(String.valueOf(main_object.getDouble("temp"))+celsius);
                        weather_humidity.setText("Humidity: "+String.valueOf(main_object.getDouble("humidity"))+" %");
                        weather_pressure.setText("Pressure: "+String.valueOf(main_object.getDouble("pressure"))+" Pa");
                        weather_wind_speed.setText("Wind speed: "+String.valueOf(main_object2.getDouble("speed")+" km/h"));*/
                    /*    Picasso.with(getBaseContext())
                                .load("http://openweathermap.org/img/w/"+object.getString("icon")+".png")
                                .into(weather_picture);


                        Animation anim= AnimationUtils.loadAnimation(getBaseContext(), R.anim.splash_transition);
                        anim.setDuration(1500);
                        weather_picture.startAnimation(anim);

                        String date=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());


                        weather_date.setText(date);
*/


                    }catch(JSONException e){e.printStackTrace();}


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {



                }
            });
            RequestQueue queue= Volley.newRequestQueue(getContext());
            queue.add(request);
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            refresh_layout.setRefreshing(true);



        }

        @Override
        protected void onPostExecute(Void result){

            super.onPostExecute(result);
            refresh_layout.setRefreshing(false);



        }



    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) this.getContext().getSystemService(this.getContext().CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }


    private void loadOfflineNews(){
List<NewsItem> offlineList=handler.getNews();
System.out.println("VELICINA "+offlineList.size());
        if(!offlineList.isEmpty()){
            lista.addAll(offlineList);
            adapter.notifyDataSetChanged();

        }else {

            Toast.makeText(this.getContext(),"There is no offline news!",Toast.LENGTH_SHORT).show();

        }

    }

    private void loadNews(){
        if(isNetworkConnected())
            new  NewsDownloaderTask().execute();
        else {

            loadOfflineNews();

        }
    }

}
