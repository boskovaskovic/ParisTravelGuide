package com.bvinstruments.paristravelguide.items;

import java.io.Serializable;
import java.util.Objects;

public class ListItem implements Serializable {

    private String headline;
    private String description;
    private String imaageURL;

    public String getImaageURL() {
        return imaageURL;
    }

    public void setImaageURL(String imaageURL) {
        this.imaageURL = imaageURL;
    }

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

    public ListItem(){
        super();
    }

    public ListItem(String imaageURL,String headline, String description){
        super();
        this.headline=headline;
        this.imaageURL=imaageURL;
        this.description=description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListItem listItem = (ListItem) o;
        return Objects.equals(headline, listItem.headline) &&
                Objects.equals(description, listItem.description) &&
                Objects.equals(imaageURL, listItem.imaageURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(headline, description, imaageURL);
    }
}
