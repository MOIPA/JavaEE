package com.tr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootConfiguration
public class Application  {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
