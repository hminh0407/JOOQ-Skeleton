package com.personal.jooq.skeleton.config;

import com.personal.jooq.skeleton.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by minhpham on 6/7/16.
 */
@Configuration
@ComponentScan(basePackageClasses = Application.class)
@PropertySource("application.properties")
@PropertySource(value = "file:${CONF_DIR}/application-override.properties", ignoreResourceNotFound = true)
public class ApplicationConfig {

}
