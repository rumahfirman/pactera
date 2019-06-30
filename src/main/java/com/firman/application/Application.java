package com.firman.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by firman on 2/2/19.
 */
@EnableSwagger2
@EnableJpaRepositories(basePackages = {"com.firman.repositories"})
@EntityScan({"com.firman.domainobjects"})
@ComponentScan({"com.firman.controllers", "com.firman.services", "com.firman.exception.handler"})
@SpringBootApplication
public class Application extends SpringBootServletInitializer
{

    @Value("${weather.service.url}")
    private String weatherServiceUrl;

    @Value("${api.key}")
    private String appId;


    public static void main(String[] args)
    {
        SpringApplication.run(Application.class);
    }


    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(Application.class);
    }


    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }


    @Bean
    public Docket docket()
    {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.firman"))
            .paths(PathSelectors.any())
            .build();
    }

}
