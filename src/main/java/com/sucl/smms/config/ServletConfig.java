package com.sucl.smms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author sucl
 * @since 2019/3/21
 */
@Configuration
@ComponentScan(value = "com.sucl.smms",useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter({Controller.class,ControllerAdvice.class})})
@EnableWebMvc
public class ServletConfig extends WebMvcConfigurationSupport {

}
