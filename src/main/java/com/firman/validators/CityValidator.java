package com.firman.validators;

import com.firman.domainobjects.City;
import com.firman.repositories.CityRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by firman on 6/22/19.
 */
public class CityValidator implements ConstraintValidator<CityConstraint, String>
{
    @Autowired
    private CityRepository cityRepository;


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
    {
        City city = cityRepository.findByName(s);
        if (city != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
