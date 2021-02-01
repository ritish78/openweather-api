package com.weather.openweather.openweatherapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.sun.istack.NotNull;

@JsonIgnoreType(false)
public class WeatherResponseHandler {

    private String city;
    private String country;
    private double temperature;
    private double feelsLike;
    private String main;
    private String description;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private double timeZone;

    public WeatherResponseHandler() {
    }

    public WeatherResponseHandler(String city, String country, double temperature, double feelsLike, String main, String description,
                                  double pressure, double humidity, double windSpeed, double timeZone) {
        this.city = city;
        this.country = country;
        this.main = main;
        this.description = description;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.timeZone = timeZone;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(double timeZone) {
        this.timeZone = timeZone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "WeatherResponseHandler{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", temperature=" + temperature +
                ", feelsLike=" + feelsLike +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", timeZone=" + timeZone +
                '}';
    }
}
