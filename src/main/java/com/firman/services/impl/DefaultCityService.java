package com.firman.services.impl;

import com.firman.domainobjects.City;
import com.firman.repositories.CityRepository;
import com.firman.services.CityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by firman on 6/20/19.
 */
@Service
public class DefaultCityService implements CityService
{
    @Autowired
    private CityRepository cityRepository;


    @Override
    public List<City> listCities()
    {
        final List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(cities::add);
        return cities;
    }


    @Override
    public void addCity(City city)
    {
        cityRepository.save(city);
    }
}
