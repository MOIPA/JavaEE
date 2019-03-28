package com.example.demo.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "my")
@Component
@Data
public class ConfigBean {
    private String name;
    private int age;
    private int number;
    private String greeting;
}
