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
import com.bvinstruments.paristravelguide.NewsActivity;
import com.bvinstruments.paristravelguide.R;
import com.bvinstruments.paristravelguide.holders.ListItemHolder;
import com.bvinstruments.paristravelguide.items.ListItem;
import com.bvinstruments.paristravelguide.sql.DBHandler;

import java.util.ArrayList;
import java.util.List;

public  class ListItemAdapter extends RecyclerView.Adapter<ListItemHolder> implements Filterable {

    protected Context context;
    protected  List<ListItem> lista;
    protected List<ListItem>itemsFiltered;
    protected RequestOptions option;




    public ListItemAdapter(Context context, List<ListItem> lista){
super();
        this.lista=lista;
        this.context=context;
itemsFiltered=lista;
        option=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,  int i) {
        View view;

        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.row_item,viewGroup,false);
       final ListItemHolder holder=new ListItemHolder(view);
        view.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(), NewsActivity.class);
                intent.putExtra("newsitem",itemsFiltered.get(holder.getAdapterPosition()));
                new DBHandler(v.getContext()).insertNews(itemsFiltered.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder listItemHolder, int i) {

        listItemHolder.getDescription().setText(itemsFiltered.get(listItemHolder.getAdapterPosition()).getDescription());
        listItemHolder.getHeadline().setText(itemsFiltered.get(listItemHolder.getAdapterPosition()).getHeadline());

    Glide.with(context).load(R.drawable.ic_icons8_museum).apply(option).into(listItemHolder.getImage());




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
                List<ListItem> listaFilter= new ArrayList<>();
                if(dataToSearch.isEmpty()){

                    listaFilter=lista;

                }else {

                    for(ListItem item:lista){


                        if((item.getHeadline().toLowerCase().contains(dataToSearch.toLowerCase()))||(item.getDescription().toLowerCase().contains(dataToSearch.toLowerCase())))listaFilter.add(item); }

                }

                   FilterResults results=new FilterResults();
               results.values=listaFilter;
               results.count=listaFilter.size();
               return results;






            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
itemsFiltered=(ArrayList<ListItem>)results.values;

notifyDataSetChanged();
            }
        };
    }
}
