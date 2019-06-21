package com.firman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Serves index.html for web app and swagger page for API documentation.
 * Created by firman on 6/21/19.
 */
@Controller
@ApiIgnore
public class HomeController
{

    /**
     * Spring thymeleaf will reroute this to templates/index.html where the React app is served.
     *
     * @return
     */
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
