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
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class WeatherControllerTest
{

    // TODO: inject mock rest template
    @Autowired
    private MockMvc mvc;


    /**
     * Tests getting weather for Sydney, which is valid (Sydney exists in database)
     *
     * @throws Exception
     */
    @Test
    public void testGetWeatherValidCity() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/weather/Sydney").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().is(200));
    }


    /**
     * Tests getting weather for London, which is invalid because London does not exist in database.
     *
     * @throws Exception
     */
    @Test(expected = NestedServletException.class)
    public void testGetWeatherInvalidCity() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/weather/London").accept(MediaType.APPLICATION_JSON));
    }
}
