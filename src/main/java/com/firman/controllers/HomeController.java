package com.firman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by firman on 6/21/19.
 */
@Controller
@ApiIgnore
public class HomeController
{

    @RequestMapping(value = "/")
    public String index()
    {
        return "index";
    }


    @RequestMapping("/swagger")
    public String swagger()
    {
        return "redirect:swagger-ui.html";
    }
}
