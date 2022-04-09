package com.example.weathertestapp.Model.WeatherDataModel;

public class Source {
    private String title;
    private String slug;
    private String url;
    private long crawlRate;

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public String getSlug() { return slug; }
    public void setSlug(String value) { this.slug = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public long getCrawlRate() { return crawlRate; }
    public void setCrawlRate(long value) { this.crawlRate = value; }
}
