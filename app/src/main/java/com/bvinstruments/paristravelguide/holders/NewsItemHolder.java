package com.bvinstruments.paristravelguide.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bvinstruments.paristravelguide.R;

public class NewsItemHolder extends RecyclerView.ViewHolder {
private TextView headline;
private TextView description;
private ImageView image;


    public NewsItemHolder(@NonNull View itemView) {
        super(itemView);
        headline=itemView.findViewById(R.id.headline);
        description=itemView.findViewById(R.id.description);
        image=itemView.findViewById(R.id.thumbnail);
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
