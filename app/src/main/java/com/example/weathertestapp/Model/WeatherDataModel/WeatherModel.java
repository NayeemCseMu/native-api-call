package com.example.weathertestapp.Model.WeatherDataModel;

import java.time.OffsetDateTime;

public class WeatherModel {
    private ConsolidatedWeather[] consolidatedWeather;
    private OffsetDateTime time;
    private OffsetDateTime sunRise;
    private OffsetDateTime sunSet;
    private String timezoneName;
    private Parent parent;
    private Source[] sources;
    private String title;
    private String locationType;
    private long woeid;
    private String lattLong;
    private String timezone;

    public ConsolidatedWeather[] getConsolidatedWeather() {
        return consolidatedWeather;
    }

    public void setConsolidatedWeather(ConsolidatedWeather[] value) {
        this.consolidatedWeather = value;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    public void setTime(OffsetDateTime value) {
        this.time = value;
    }

    public OffsetDateTime getSunRise() {
        return sunRise;
    }

    public void setSunRise(OffsetDateTime value) {
        this.sunRise = value;
    }

    public OffsetDateTime getSunSet() {
        return sunSet;
    }

    public void setSunSet(OffsetDateTime value) {
        this.sunSet = value;
    }

    public String getTimezoneName() {
        return timezoneName;
    }

    public void setTimezoneName(String value) {
        this.timezoneName = value;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent value) {
        this.parent = value;
    }

    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] value) {
        this.sources = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String value) {
        this.locationType = value;
    }

    public long getWoeid() {
        return woeid;
    }

    public void setWoeid(long value) {
        this.woeid = value;
    }

    public String getLattLong() {
        return lattLong;
    }

    public void setLattLong(String value) {
        this.lattLong = value;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String value) {
        this.timezone = value;
    }
}
