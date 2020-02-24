package com.bvinstruments.paristravelguide.fragments;

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

import com.bvinstruments.paristravelguide.R;
import com.bvinstruments.paristravelguide.adapters.EventItemAdapter;
import com.bvinstruments.paristravelguide.adapters.ListItemAdapter;
import com.bvinstruments.paristravelguide.items.Item;
import com.bvinstruments.paristravelguide.items.ListItem;
import com.bvinstruments.paristravelguide.sql.DBHandler;

import java.util.ArrayList;
import java.util.List;

public class EventsFragment extends Fragment {

    private View view;
    private List<Item> lista;
    private RecyclerView recyclerView;
    private EventItemAdapter adapter;
    private EditText search_box;
    private DBHandler handler;

    public EventsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_events,container,false);
        handler=new DBHandler(this.getContext());



        lista=new ArrayList<>();
        lista.addAll(handler.getEvents());
        recyclerView=view.findViewById(R.id.recyclerView_events);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        adapter=new EventItemAdapter(getContext(),lista);
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
        return view;
    }



}
