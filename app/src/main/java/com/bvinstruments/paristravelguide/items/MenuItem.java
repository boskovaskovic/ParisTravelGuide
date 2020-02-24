package com.bvinstruments.paristravelguide.items;

import java.io.Serializable;
import java.util.Objects;

public class MenuItem<T> implements Serializable {

    private String headline;
    private String description;
    private int imageResource;
    private Class<T> klasa;

 

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public MenuItem(){
        super();
    }

    public MenuItem(int imageResource, String headline, String description, Class<T> klasa
    ){
        super();
        this.headline=headline;
        this.imageResource=imageResource;
        this.description=description;
        this.klasa=klasa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem listItem = (MenuItem) o;
        return Objects.equals(headline, listItem.headline) &&
                Objects.equals(description, listItem.description) &&
                Objects.equals(imageResource, listItem.imageResource);
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public Class<T> getKlasa() {
        return klasa;
    }

    public void setKlasa(Class<T> klasa) {
        this.klasa = klasa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(headline, description, imageResource);
    }
}
