package com.bvinstruments.paristravelguide.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bvinstruments.paristravelguide.R;

import com.bvinstruments.paristravelguide.activities.DetailActivity;
import com.bvinstruments.paristravelguide.items.Item;
import com.bvinstruments.paristravelguide.sql.DBHandler;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private View view;
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private static final LatLng paris_coords=new LatLng( 48.864716, 2.349014);

    public MapFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_map,container,false);
        if(getActivity()!=null) {
            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.google_map);
            if (mapFragment != null) {
                mapFragment.getMapAsync(this);
            }
        }


        return view;
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(false);
        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(paris_coords)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(mMap.getCameraPosition().zoom - 10.0f));
        loadMarkers();

    }

    private void loadMarkers(){

        LatLng comice=new LatLng(48.849559, 2.275946);
        LatLng hugoco=new LatLng(48.870889, 2.294056);
        LatLng detour=new LatLng(48.877921, 2.332389);
        LatLng oysters=new LatLng(48.854377, 2.338732);
        LatLng larpege=new LatLng(48.855942, 2.317036);
        LatLng lassiette=new LatLng(48.840540, 2.349644);

mMap.addMarker(new MarkerOptions().position(comice)
.title("Comice")
.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

mMap.addMarker(new MarkerOptions().position(hugoco)
                .title("Hugo & Co")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

mMap.addMarker(new MarkerOptions().position(detour)
                .title("Détour")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

mMap.addMarker(new MarkerOptions().position(larpege)
                .title("L’Arpège")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

mMap.addMarker(new MarkerOptions().position(oysters)
                .title("Oysters at l’Huîtrerie Régi")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mMap.addMarker(new MarkerOptions().position(lassiette)
                .title("L'Assiette")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));



mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
    DBHandler handler=new DBHandler(getContext());
    @Override
    public void onInfoWindowClick(Marker marker) {
        if(marker.getTitle().equals("Comice")){
            Intent intent=new Intent(getContext(), DetailActivity.class);

            ArrayList<Item>items = handler.getRestaurants();

            intent.putExtra("item",items.get(getPosition(items,marker.getTitle())));
            startActivity(intent);

        }
        else if(marker.getTitle().equals("Hugo & Co")){
            Intent intent=new Intent(getContext(), DetailActivity.class);

            ArrayList<Item>items = handler.getRestaurants();

            intent.putExtra("item",items.get(getPosition(items,marker.getTitle())));
            startActivity(intent);

        }
        else if(marker.getTitle().equals("Détour")){
            Intent intent=new Intent(getContext(), DetailActivity.class);

            ArrayList<Item>items = handler.getRestaurants();

            intent.putExtra("item",items.get(getPosition(items,marker.getTitle())));
            startActivity(intent);

        }
        else if(marker.getTitle().equals("L’Arpège")){
            Intent intent=new Intent(getContext(), DetailActivity.class);

            ArrayList<Item>items = handler.getRestaurants();

            intent.putExtra("item",items.get(getPosition(items,marker.getTitle())));
            startActivity(intent);

        }
       else  if(marker.getTitle().equals("Oysters at l’Huîtrerie Régi")){
            Intent intent=new Intent(getContext(), DetailActivity.class);

            ArrayList<Item>items = handler.getRestaurants();

            intent.putExtra("item",items.get(getPosition(items,marker.getTitle())));
            startActivity(intent);

        }
       else if(marker.getTitle().equals("L'Assiette")){
            Intent intent=new Intent(getContext(), DetailActivity.class);

            ArrayList<Item>items = handler.getRestaurants();

            intent.putExtra("item",items.get(getPosition(items,marker.getTitle())));
            startActivity(intent);

        }

    }
});


    }

private int getPosition(List<Item> items, String title){
    int indexOf=0;
    for(int i=0;i<items.size();i++)if(items.get(i).getHeadline().equals(title)){

        indexOf=i;
        break;
    }
     return indexOf;
}

}
