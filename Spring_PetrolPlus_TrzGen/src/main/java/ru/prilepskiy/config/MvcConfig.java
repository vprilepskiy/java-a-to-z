package ru.prilepskiy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Created by VLADIMIR on 09.04.2018.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
     * Редирект контроллер.
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/r").setViewName("readme.txt");
//        registry.addViewController("/rr").setViewName("templates/readme1.txt");
//        registry.addViewController("/signin").setViewName("signin.html");
    }
}
