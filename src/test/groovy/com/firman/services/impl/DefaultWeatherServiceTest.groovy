package com.firman.services.impl

import com.firman.domainobjects.WeatherDTO
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * Unit tests for {@link DefaultWeatherService}
 * Created by firman on 6/30/19.
 */
class DefaultWeatherServiceTest extends Specification {
    DefaultWeatherService weatherService = new DefaultWeatherService()
    RestTemplate restTemplate = Mock()
    String city = "Melbourne"

    def setup() {
        weatherService.restTemplate = restTemplate
        weatherService.apiKeyUrlVariable = "APPID"
        weatherService.cityUrlVariable = "q"
        weatherService.weatherServiceUrl = "url"
        weatherService.appId = "appId"
    }

    def "Retrieving weather for a city"() {
        given:
        def restTemplateArg
        restTemplate.getForObject(_, _, _) >> { arguments ->
            restTemplateArg = arguments
            WeatherDTO weatherDTO = new WeatherDTO()
            weatherDTO.name = city
            return weatherDTO
        }

        when:
        def result = weatherService.getWeather(city)

        then:
        // Checking the result returned by the service
        result instanceof WeatherDTO
        result.name == city
        // Checking the argument passed to the rest template
        def urlVar = restTemplateArg[2]
        urlVar[weatherService.apiKeyUrlVariable] == weatherService.appId
        urlVar[weatherService.cityUrlVariable] == city
    }
}
