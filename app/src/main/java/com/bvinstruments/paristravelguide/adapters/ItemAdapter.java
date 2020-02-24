package com.bvinstruments.paristravelguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bvinstruments.paristravelguide.R;
import com.bvinstruments.paristravelguide.activities.DetailActivity;
import com.bvinstruments.paristravelguide.holders.ItemHolder;
import com.bvinstruments.paristravelguide.items.Item;
import com.bvinstruments.paristravelguide.sql.DBHandler;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;
import java.util.List;

public  class ItemAdapter extends RecyclerView.Adapter<ItemHolder> implements Filterable {

    protected Context context;
    protected  List<Item> lista;
    protected List<Item>itemsFiltered;
    protected RequestOptions option;




    public ItemAdapter(Context context, List<Item> lista){
super();
        this.lista=lista;
        this.context=context;
itemsFiltered=lista;
        option=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,  int i) {
        View view;

        final LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.favorable_item,viewGroup,false);
        LikeButton likeButton=view.findViewById(R.id.like_button);
        final DBHandler handler=new DBHandler(view.getContext());

       final ItemHolder holder=new ItemHolder(view);
        view.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("item",itemsFiltered.get(holder.getAdapterPosition()));
                context.startActivity(intent);


            }
        });

        likeButton.setOnLikeListener(new OnLikeListener() {

            @Override
            public void liked(LikeButton likeButton) {
Item item=itemsFiltered.get(holder.getAdapterPosition());
item.setFavorite(1);
handler.insertRestaurant(item);
            }

            @Override
            public void unLiked(LikeButton likeButton) {

                Item item=itemsFiltered.get(holder.getAdapterPosition());
                item.setFavorite(0);
                handler.insertRestaurant(item);

            }
        });



        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder ItemHolder, int i) {

        ItemHolder.getDescription().setText(itemsFiltered.get(ItemHolder.getAdapterPosition()).getDescription());
        ItemHolder.getHeadline().setText(itemsFiltered.get(ItemHolder.getAdapterPosition()).getHeadline());
        int integer=itemsFiltered.get(ItemHolder.getAdapterPosition()).isFavorite();
        if(integer==1)ItemHolder.getLikeButton().setLiked(true);
        else ItemHolder.getLikeButton().setLiked(false);


    Glide.with(context).load(itemsFiltered.get(i).getImageResource()).apply(option).into(ItemHolder.getImage());




    }

    @Override
    public int getItemCount(){

       return itemsFiltered.size();

    }

    @Override
    public Filter getFilter() {


        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
               String dataToSearch=constraint.toString();
                List<Item> listaFilter= new ArrayList<>();
                if(dataToSearch.isEmpty()){

                    listaFilter=lista;

                }else {

                    for(Item item:lista){


                        if((item.getHeadline().toLowerCase().contains(dataToSearch.toLowerCase()))||(item.getDescription().toLowerCase().contains(dataToSearch.toLowerCase())))listaFilter.add(item); }

                }

                   FilterResults results=new FilterResults();
               results.values=listaFilter;
               results.count=listaFilter.size();
               return results;






            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
itemsFiltered=(ArrayList<Item>)results.values;

notifyDataSetChanged();
            }
        };
    }
}
