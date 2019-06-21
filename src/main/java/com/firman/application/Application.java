package com.firman.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by firman on 2/2/19.
 */
@EnableJpaRepositories(basePackages = {"com.firman.repositories"})
@EntityScan({"com.firman.domainobjects"})
@ComponentScan({"com.firman.controllers", "com.firman.services"})
@SpringBootApplication
public class Application implements WebMvcConfigurer
{

    @Value("${weather.service.url}")
    private String weatherServiceUrl;

    @Value("${api.key}")
    private String appId;


    public static void main(String[] args)
    {
        SpringApplication.run(Application.class);
    }


    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

}
