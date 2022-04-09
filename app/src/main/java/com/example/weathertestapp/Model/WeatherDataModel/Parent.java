package com.example.weathertestapp.Model.WeatherDataModel;

public class Parent {
    private String title;
    private String locationType;
    private long woeid;
    private String lattLong;

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public String getLocationType() { return locationType; }
    public void setLocationType(String value) { this.locationType = value; }

    public long getWoeid() { return woeid; }
    public void setWoeid(long value) { this.woeid = value; }

    public String getLattLong() { return lattLong; }
    public void setLattLong(String value) { this.lattLong = value; }
}
