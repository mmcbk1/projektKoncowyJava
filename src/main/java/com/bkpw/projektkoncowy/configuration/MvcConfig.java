package com.bkpw.projektkoncowy.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableAutoConfiguration
public class MvcConfig implements WebMvcConfigurer {


    //Cors maping
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }



/*

    //Page
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }
*/


}


