package com.bvinstruments.paristravelguide.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bvinstruments.paristravelguide.R;

public class MenuItemHolder extends RecyclerView.ViewHolder {
private TextView headline;
private TextView description;
private ImageView image;


    public MenuItemHolder(@NonNull View itemView) {
        super(itemView);
        headline=itemView.findViewById(R.id.headline_menu);
        description=itemView.findViewById(R.id.description_menu);
        image=itemView.findViewById(R.id.thumbnail_menu);
    }

    public TextView getHeadline() {
        return headline;
    }

    public void setHeadline(TextView headline) {
        this.headline = headline;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
