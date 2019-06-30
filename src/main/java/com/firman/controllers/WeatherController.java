package com.firman.controllers;

import com.firman.domainobjects.WeatherDTO;
import com.firman.validators.CityConstraint;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Serves the weather.
 * Created by firman on 6/20/19.
 */
@RestController
@RequestMapping("/weather")
@Validated
public class WeatherController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);
    @Autowired
    private RestTemplate restTemplate;
    @Value("${weather.service.url.variable.key}")
    private String apiKeyUrlVariable;
    @Value("${weather.service.url.variable.city}")
    private String cityUrlVariable;
    @Value("${weather.service.url}")
    private String weatherServiceUrl;
    @Value("${api.key}")
    private String appId;


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
        Map<String, String> urlVars = new HashMap<>();
        urlVars.put(cityUrlVariable, city);
        urlVars.put(apiKeyUrlVariable, appId);
        LOGGER.info("url vars: " + urlVars);
        LOGGER.info("URL: " + weatherServiceUrl);
        return restTemplate.getForObject(weatherServiceUrl, WeatherDTO.class, urlVars);
    }
}
