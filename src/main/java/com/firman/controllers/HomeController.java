package com.firman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by firman on 6/21/19.
 */
@Controller
public class HomeController
{

    @RequestMapping(value = "/")
    public String index()
    {
        return "index";
    }
}
