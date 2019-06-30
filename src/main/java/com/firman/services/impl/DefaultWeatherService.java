package com.firman.services.impl;

import com.firman.domainobjects.WeatherDTO;
import com.firman.services.WeatherService;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by firman on 6/30/19.
 */
@Service
public class DefaultWeatherService implements WeatherService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultWeatherService.class);
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


    @Override
    public WeatherDTO getWeather(String city)
    {
        Map<String, String> urlVars = new HashMap<>();
        urlVars.put(cityUrlVariable, city);
        urlVars.put(apiKeyUrlVariable, appId);
        LOGGER.info("url vars: " + urlVars);
        LOGGER.info("URL: " + weatherServiceUrl);
        return restTemplate.getForObject(weatherServiceUrl, WeatherDTO.class, urlVars);
    }
}
