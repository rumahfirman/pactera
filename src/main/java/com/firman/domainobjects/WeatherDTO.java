package com.firman.domainobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by firman on 6/21/19.
 */

public class WeatherDTO
{
    private String name;
    private String weather;
    private Number temperature;
    private Number wind;
    private String updateTime = new Date().toString();


    @JsonProperty("weather")
    public void retrieveWeather(List<Map<String, Object>> json)
    {
        this.weather = (String) json.get(0).get("main");
    }


    @JsonProperty("main")
    public void retrieveTemperature(Map<String, Object> json)
    {
        this.temperature = (Number) json.get("temp");
    }


    @JsonProperty("wind")
    public void unpackWind(Map<String, Object> json)
    {
        this.wind = (Number) json.get("speed");
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getWeather()
    {
        return weather;
    }


    public void setWeather(String weather)
    {
        this.weather = weather;
    }


    public Number getTemperature()
    {
        return temperature;
    }


    public void setTemperature(Number temperature)
    {
        this.temperature = temperature;
    }


    public Number getWind()
    {
        return wind;
    }


    public void setWind(Number wind)
    {
        this.wind = wind;
    }


    public String getUpdateTime()
    {
        return updateTime;
    }


    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }
}
