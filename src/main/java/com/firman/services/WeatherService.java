package com.firman.services;

import com.firman.domainobjects.WeatherDTO;

/**
 * Created by firman on 6/30/19.
 */
public interface WeatherService
{
    WeatherDTO getWeather(String city);
}
