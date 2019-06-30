package com.firman.controllers

import com.firman.domainobjects.WeatherDTO
import com.firman.services.WeatherService
import spock.lang.Specification

/**
 * Unit tests for {@link WeatherController}
 * Created by firman on 6/30/19.
 */
class WeatherControllerTest extends Specification {
    WeatherController weatherController = new WeatherController();
    WeatherService weatherService = Mock()

    def setup() {
        weatherController.weatherService = weatherService
    }

    def "Retrieving weather"() {
        given:
        WeatherDTO weatherDTO = new WeatherDTO()
        weatherDTO.name = "Cloudy"
        weatherService.getWeather(_) >> weatherDTO

        when:
        def result = weatherController.getWeather("")

        then:
        result instanceof WeatherDTO
        result.name == "Cloudy"
    }
}
