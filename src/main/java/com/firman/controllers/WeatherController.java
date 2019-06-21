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


    @GetMapping("/{cityName}")
    public WeatherDTO getWeather(@CityConstraint @PathVariable String cityName)
    {
        Map<String, String> urlVars = new HashMap<>();
        urlVars.put(cityUrlVariable, cityName);
        urlVars.put(apiKeyUrlVariable, appId);
        LOGGER.info("url vars: " + urlVars);
        LOGGER.info("URL: " + weatherServiceUrl);
        return restTemplate.getForObject(weatherServiceUrl, WeatherDTO.class, urlVars);
    }
}
