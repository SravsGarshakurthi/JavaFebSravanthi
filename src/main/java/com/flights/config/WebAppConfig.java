package com.flights.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.flights")
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurationSupport {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver r = new InternalResourceViewResolver();
        r.setPrefix("/views/");
        r.setSuffix(".jsp");
        return r;
    }

    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer c) {
        c.enable();
    }
}