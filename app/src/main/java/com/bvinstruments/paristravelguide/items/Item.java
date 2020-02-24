package com.bvinstruments.paristravelguide.items;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {

    private String headline;
    private String description;
    private int favorite;
    private int imageResource;



    public Item(String headline, String description, int imageResource,int favorite) {
        this.headline = headline;
        this.description = description;
        this.imageResource = imageResource;
        this.favorite=favorite;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int isFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return imageResource == item.imageResource &&
                Objects.equals(headline, item.headline) &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(headline, description, imageResource);
    }
}
