package com.gracie.ecommerce.security.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.gracie.ecommerce.**"})
@EnableAutoConfiguration
public class ServiceConfig {
}
