package com.bvinstruments.paristravelguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bvinstruments.paristravelguide.R;
import com.bvinstruments.paristravelguide.holders.MenuItemHolder;
import com.bvinstruments.paristravelguide.items.MenuItem;

import java.util.List;

public  class MenuItemAdapter extends RecyclerView.Adapter<MenuItemHolder> {

    protected Context context;
    protected  List<MenuItem> lista;
    protected List<MenuItem>itemsFiltered;
    protected RequestOptions option;




    public MenuItemAdapter(Context context, List<MenuItem> lista){
super();
        this.lista=lista;
        this.context=context;
itemsFiltered=lista;
        option=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public MenuItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,  int i) {
        View view;

        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.menu_item,viewGroup,false);
       final MenuItemHolder holder=new MenuItemHolder(view);
        view.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(),lista.get( holder.getAdapterPosition()).getKlasa());
                context.startActivity(intent);




               

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemHolder MenuItemHolder, int i) {

        MenuItemHolder.getDescription().setText(itemsFiltered.get(MenuItemHolder.getAdapterPosition()).getDescription());
        MenuItemHolder.getHeadline().setText(itemsFiltered.get(MenuItemHolder.getAdapterPosition()).getHeadline());

    Glide.with(context).load(itemsFiltered.get(i).getImageResource()).apply(option).into(MenuItemHolder.getImage());




    }

    @Override
    public int getItemCount(){

       return itemsFiltered.size();

    }


}
