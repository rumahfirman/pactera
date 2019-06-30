package com.firman.controllers

import com.firman.domainobjects.City
import com.firman.services.CityService
import spock.lang.Specification

import java.util.stream.Collectors

/**
 * Unit tests for {@link CityController}
 * Created by firman on 6/30/19.
 */
class CityControllerTest extends Specification {

    CityController cityController = new CityController()
    CityService cityService = Mock()
    def cities = [new City("Sydney"), new City("Melbourne"), new City("Wollongong")]

    def setup() {
        cityService.listCities() >> cities
        cityController.cityService = cityService
    }

    def "Retrieving list of cities"() {
        when:
        List<City> result = cityController.listCities()
        println result

        then:
        result.sort() == cities.sort()
    }

    def "Adding city"() {
        given:
        City city = ["London"]
        def serviceArgument
        cityService.addCity(_) >> { arguments -> serviceArgument = arguments[0] }

        when:
        cityController.addCity(city)

        then:
        serviceArgument instanceof City
        serviceArgument.name == "London"
    }

}
