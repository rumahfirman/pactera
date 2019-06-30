package com.firman.validators

import com.firman.domainobjects.City
import com.firman.repositories.CityRepository
import spock.lang.Specification

import javax.validation.ConstraintValidatorContext

/**
 * Unit tests for {@link CityValidator}
 * Created by firman on 6/30/19.
 */
class CityValidatorTest extends Specification {

    CityValidator validator = new CityValidator()
    CityRepository repository = Mock()
    def cities = ["Sydney", "Melbourne", "Wollongong"]

    def setup() {
        validator.cityRepository = repository
        repository.findByName(_) >> {
            arguments ->
                if (cities.contains(arguments[0]))
                    return new City()
                else
                    return null
        }
    }

    def "Valid city"() {
        when:
        def result = validator.isValid("Melbourne", Mock(ConstraintValidatorContext))

        then:
        result
    }

    def "Invalid city"() {
        when:
        def result = validator.isValid("London", Mock(ConstraintValidatorContext))

        then:
        !result
    }
}
