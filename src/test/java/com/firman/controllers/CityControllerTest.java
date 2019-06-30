package com.firman.controllers;

import com.firman.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CityControllerTest
{

    private static final String ADD_CITY = "{\"name\":\"Jakarta\"}";
    @Autowired
    private MockMvc mvc;


    /**
     * Tests getting list of cities.
     *
     * @throws Exception
     */
    @Test
    public void testListCities() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/city/cities").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().is(200));
    }


    /**
     * Tests adding new city.
     *
     * @throws Exception
     */
    @Test
    public void testAddCity() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.post("/city/city").contentType(MediaType.APPLICATION_JSON).content(ADD_CITY))
            .andExpect(status().is(200));

    }
}
