package com.firman.services;

import com.firman.domainobjects.City;
import java.util.List;

/**
 * Created by firman on 6/20/19.
 */
public interface CityService
{
    List<City> listCities();

    void addCity(City city);
}
