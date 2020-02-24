package com.bvinstruments.paristravelguide.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.bvinstruments.paristravelguide.R;
import com.bvinstruments.paristravelguide.adapters.ItemAdapter;
import com.bvinstruments.paristravelguide.items.Item;
import com.bvinstruments.paristravelguide.sql.DBHandler;

import java.util.ArrayList;
import java.util.List;

public class Restaurants extends AppCompatActivity {

    private List<Item> lista;
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private SwipeRefreshLayout refresh_layout;
    private EditText search_box;
    private DBHandler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        handler=new DBHandler(this);



        lista=new ArrayList<>();
       lista.addAll(new DBHandler(this).getRestaurants());
        recyclerView=findViewById(R.id.recyclerView_restaurants);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        adapter=new ItemAdapter(this,lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        search_box=findViewById(R.id.search_box);
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
    }








}
