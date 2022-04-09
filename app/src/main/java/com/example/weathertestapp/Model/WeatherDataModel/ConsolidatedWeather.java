package com.example.weathertestapp.Model.WeatherDataModel;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class ConsolidatedWeather {
    private long id;
    private String weatherStateName;
    private String weatherStateAbbr;
    private String windDirectionCompass;
    private OffsetDateTime created;
    private LocalDate applicableDate;
    private double minTemp;
    private double maxTemp;
    private double theTemp;
    private double windSpeed;
    private double windDirection;
    private double airPressure;
    private long humidity;
    private double visibility;
    private long predictability;

    @Override
    public String toString() {
        return "State='" + weatherStateName + '\'' + ",\n" +
                "Low=" + minTemp + ",\n" +
                "High=" + maxTemp + ",\n" +
                "Temp=" + theTemp + ",\n" +
                "Humidity" + humidity;

    }

    public long getID() {
        return id;
    }

    public void setID(long value) {
        this.id = value;
    }

    public String getWeatherStateName() {
        return weatherStateName;
    }

    public void setWeatherStateName(String value) {
        this.weatherStateName = value;
    }

    public String getWeatherStateAbbr() {
        return weatherStateAbbr;
    }

    public void setWeatherStateAbbr(String value) {
        this.weatherStateAbbr = value;
    }

    public String getWindDirectionCompass() {
        return windDirectionCompass;
    }

    public void setWindDirectionCompass(String value) {
        this.windDirectionCompass = value;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime value) {
        this.created = value;
    }

    public LocalDate getApplicableDate() {
        return applicableDate;
    }

    public void setApplicableDate(LocalDate value) {
        this.applicableDate = value;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double value) {
        this.minTemp = value;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double value) {
        this.maxTemp = value;
    }

    public double getTheTemp() {
        return theTemp;
    }

    public void setTheTemp(double value) {
        this.theTemp = value;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double value) {
        this.windSpeed = value;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double value) {
        this.windDirection = value;
    }

    public double getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(double value) {
        this.airPressure = value;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long value) {
        this.humidity = value;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double value) {
        this.visibility = value;
    }

    public long getPredictability() {
        return predictability;
    }

    public void setPredictability(long value) {
        this.predictability = value;
    }
}
