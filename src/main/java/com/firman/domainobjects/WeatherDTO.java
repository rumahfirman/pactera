package com.firman.domainobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

/**
 * Created by firman on 6/21/19.
 */

public class WeatherDTO
{
    @JsonProperty("name")
    private String cityName;
    @JsonProperty("weather")
    private List<Weather> weathers;
    @JsonProperty("main")
    private Temperature temperature;
    private Wind wind;
    private String updateTime = new Date().toString();


    public String getUpdateTime()
    {
        return updateTime;
    }


    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }


    public Wind getWind()
    {
        return wind;
    }


    public void setWind(Wind wind)
    {
        this.wind = wind;
    }


    public String getCityName()
    {
        return cityName;
    }


    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }


    public List<Weather> getWeathers()
    {
        return weathers;
    }


    public void setWeathers(List<Weather> weathers)
    {
        this.weathers = weathers;
    }


    public Temperature getTemperature()
    {
        return temperature;
    }


    public void setTemperature(Temperature temperature)
    {
        this.temperature = temperature;
    }


    public static class Wind
    {
        private double speed;
        private double degree;


        public double getSpeed()
        {
            return speed;
        }


        public void setSpeed(double speed)
        {
            this.speed = speed;
        }


        public double getDegree()
        {
            return degree;
        }


        public void setDegree(double degree)
        {
            this.degree = degree;
        }
    }

    public static class Temperature
    {
        private double temp;


        public double getTemp()
        {
            return temp;
        }


        public void setTemp(double temp)
        {
            this.temp = temp;
        }
    }

    public static class Weather
    {
        private String main;


        public String getMain()
        {
            return main;
        }


        public void setMain(String main)
        {
            this.main = main;
        }
    }
}
