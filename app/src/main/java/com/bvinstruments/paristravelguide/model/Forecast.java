package com.bvinstruments.paristravelguide.model;

public class Forecast {

    private double humidity;
    private double windspeed;
    private double temperature;
    private double pressure;
    private String description;

    public Forecast(double humidity, double windspeed,  double pressure, double temperature, String description) {
        this.humidity = humidity;
        this.windspeed = windspeed;
        this.temperature = temperature;
        this.pressure = pressure;
        this.description=description;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
