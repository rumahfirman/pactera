package com.firman.services.impl

import com.firman.domainobjects.City
import com.firman.repositories.CityRepository
import spock.lang.Specification

/**
 * Unit tests for {@link DefaultCityService}
 * Created by firman on 6/30/19.
 */
class DefaultCityServiceTest extends Specification {

    DefaultCityService cityService = new DefaultCityService();
    CityRepository cityRepository = Mock()
    Iterable<City> cities = [new City("Sydney"), new City("Melbourne"), new City("Wollongong")]

    def setup() {
        cityService.cityRepository = cityRepository
        cityRepository.findAll() >> cities
    }

    def "Listing cities"() {
        when:
        def result = cityService.listCities()

        then:
        result instanceof List
        result.size() == cities.size()
        result.sort() == cities.sort()
    }

    def "Adding city"() {
        given:
        def repositoryArgument
        cityRepository.save(_) >> { arguments -> repositoryArgument = arguments[0] }

        when:
        cityService.addCity(new City("Kuala Lumpur"))

        then:
        repositoryArgument instanceof City
        repositoryArgument.name == "Kuala Lumpur"
    }

}
