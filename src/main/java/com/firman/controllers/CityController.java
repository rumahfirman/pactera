package com.firman.controllers;

import com.firman.domainobjects.City;
import com.firman.services.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by firman on 6/20/19.
 */
@RestController
@RequestMapping("/city")
public class CityController
{
    @Autowired
    private CityService cityService;


    @GetMapping("/getcities")
    public List<City> listCities()
    {
        return cityService.listCities();
    }


    @PostMapping("/addcity")
    public void addCity(City city)
    {
        cityService.addCity(city);
    }
}
