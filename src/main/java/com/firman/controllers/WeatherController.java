package com.firman.controllers;

import com.firman.domainobjects.WeatherDTO;
import com.firman.services.WeatherService;
import com.firman.validators.CityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Serves the weather.
 * Created by firman on 6/20/19.
 */
@RestController
@RequestMapping("/weather")
@Validated
public class WeatherController
{

    @Autowired
    private WeatherService weatherService;


    /**
     * The weather endpoint.
     *
     * @param city The city name for which weather data will be retrieved.
     *             This will be validated against the city list in the database.
     *             If the given city is not in the database, exception is thrown.
     * @return The weather object for the city.
     */
    @GetMapping("/{city}")
    public WeatherDTO getWeather(@CityConstraint @PathVariable String city)
    {
        return weatherService.getWeather(city);
    }
}
