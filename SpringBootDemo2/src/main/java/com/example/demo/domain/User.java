package com.example.demo.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "com.example")
public class User {

    private String name;
    private int age;

}
