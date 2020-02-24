package com.bvinstruments.paristravelguide.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bvinstruments.paristravelguide.R;
import com.bvinstruments.paristravelguide.activities.CulturalHistoricalSights;
import com.bvinstruments.paristravelguide.activities.FitnessClubs;
import com.bvinstruments.paristravelguide.activities.Hotels;
import com.bvinstruments.paristravelguide.activities.Restaurants;
import com.bvinstruments.paristravelguide.adapters.MenuItemAdapter;
import com.bvinstruments.paristravelguide.items.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ParisFragment extends Fragment {

    private View view;
    private List<MenuItem> lista;
    private RecyclerView recyclerView;
    private MenuItemAdapter adapter;


    public ParisFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_paris,container,false);

        lista=new ArrayList<>();
        MenuItem<Restaurants> restaurantsMenuItem=new MenuItem<>(R.drawable.ic_icons8_food_and_wine,"Restaurants","Check out popular Paris restaurants",Restaurants.class);
        MenuItem<Hotels> hotelsMenuItem=new MenuItem<>(R.drawable.ic_fitness_center_black_24dp,"Hotels","Check out popular Paris restaurants",Hotels.class);
        MenuItem<FitnessClubs>fitnessClubsMenuItem=new MenuItem<>(R.drawable.ic_icons8_food_and_wine,"Restaurants","Check out popular Paris restaurants",FitnessClubs.class);
        MenuItem<CulturalHistoricalSights> culturalHistoricalSightsMenuItem=new MenuItem<>(R.drawable.ic_icons8_food_and_wine,"Cultural-Historical Sights","Check",CulturalHistoricalSights.class);
      lista.add(restaurantsMenuItem);
      lista.add(fitnessClubsMenuItem);
      lista.add(hotelsMenuItem);
      lista.add(culturalHistoricalSightsMenuItem);
        recyclerView=view.findViewById(R.id.recyclerView_paris);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        adapter=new MenuItemAdapter(getContext(),lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }



}
