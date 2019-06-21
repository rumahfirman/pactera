package com.firman.domainobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
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
