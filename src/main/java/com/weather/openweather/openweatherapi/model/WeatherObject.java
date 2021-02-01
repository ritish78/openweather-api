package com.weather.openweather.openweatherapi.model;

import java.util.List;
import java.util.Map;

public class WeatherObject {

    private Map<String, String> coord;
    private List<Map<String, String>> weather;
    private String base;
    private Map<String, String> main;
    private double visibility;
    private Map<String, String> wind;
    private Map<String, String> clouds;
    private Long dt;
    private Map<String, String> sys;
    private double timezone;
    private Long id;
    private String name;
    private Long cod;

    public WeatherObject() {
    }

    public WeatherObject(Map<String, String> coord, List<Map<String, String>> weather, String base,
                         Map<String, String> main, double visibility, Map<String, String> wind,
                         Map<String, String> clouds, Long dt, Map<String, String> sys, double timezone,
                         Long id, String name, Long cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Map<String, String> getCoord() {
        return coord;
    }

    public void setCoord(Map<String, String> coord) {
        this.coord = coord;
    }

    public List<Map<String, String>> getWeather() {
        return weather;
    }

    public void setWeather(List<Map<String, String>> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, String> getMain() {
        return main;
    }

    public void setMain(Map<String, String> main) {
        this.main = main;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public Map<String, String> getWind() {
        return wind;
    }

    public void setWind(Map<String, String> wind) {
        this.wind = wind;
    }

    public Map<String, String> getClouds() {
        return clouds;
    }

    public void setClouds(Map<String, String> clouds) {
        this.clouds = clouds;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Map<String, String> getSys() {
        return sys;
    }

    public void setSys(Map<String, String> sys) {
        this.sys = sys;
    }

    public double getTimezone() {
        return timezone;
    }

    public void setTimezone(double timezone) {
        this.timezone = timezone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "WeatherObject{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}
