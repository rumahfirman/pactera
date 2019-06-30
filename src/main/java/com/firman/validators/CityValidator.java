package com.firman.validators;

import com.firman.domainobjects.City;
import com.firman.repositories.CityRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by firman on 6/22/19.
 */
public class CityValidator implements ConstraintValidator<CityConstraint, String>
{

    private static final Logger LOGGER = LoggerFactory.getLogger(CityValidator.class);

    @Autowired
    private CityRepository cityRepository;


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
    {
        City city = cityRepository.findByName(s);
        if (city != null)
        {
            LOGGER.info("City {} found in database", new Object[] {s});
            return true;
        }
        else
        {
            LOGGER.info("Can not find city {} in database", new Object[] {s});
            return false;
        }
    }
}
