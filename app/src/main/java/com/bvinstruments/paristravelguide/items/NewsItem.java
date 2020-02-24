package com.bvinstruments.paristravelguide.items;

import java.util.Objects;

public class NewsItem extends ListItem {

 private String source;
 private String author;
 private String url;
 private String publishedAt;
 private String content;


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getImaageURL() {
        return super.getImaageURL();
    }

    @Override
    public void setImaageURL(String imaageURL) {
        super.setImaageURL(imaageURL);
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getHeadline() {
        return super.getHeadline();
    }

    @Override
    public void setHeadline(String headline) {
        super.setHeadline(headline);
    }

    public NewsItem(String imaageURL, String headline, String description, String source, String author, String url, String publishedAt, String content) {
        super(imaageURL, headline, description);
        this.source = source;
        this.author = author;
        this.url = url;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NewsItem newsItem = (NewsItem) o;
        return Objects.equals(source, newsItem.source) &&
                Objects.equals(author, newsItem.author) &&
                Objects.equals(url, newsItem.url) &&
                Objects.equals(publishedAt, newsItem.publishedAt) &&
                Objects.equals(content, newsItem.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), source, author, url, publishedAt, content);
    }
}
