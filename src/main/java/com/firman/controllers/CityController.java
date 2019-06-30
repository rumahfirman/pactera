package com.firman.controllers;

import com.firman.domainobjects.City;
import com.firman.services.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manages list of cities to be presented in the client side.
 * Created by firman on 6/20/19.
 */
@RestController
@RequestMapping("/city")
public class CityController
{
    @Autowired
    private CityService cityService;


    @GetMapping("/cities")
    public List<City> listCities()
    {
        return cityService.listCities();
    }


    @PostMapping("/city")
    public void addCity(@RequestBody City city)
    {
        cityService.addCity(city);
    }
}
