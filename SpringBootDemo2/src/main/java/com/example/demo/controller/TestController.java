package com.example.demo.controller;

import com.example.demo.domain.ConfigBean;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class, User.class})
public class TestController {
    @Value("${my.name}")
    private String name;

    @Autowired
    ConfigBean configBean;
    @Autowired
    User user;

    @GetMapping("/name")
    public String getName() {
        return name + ":config:" + configBean.getGreeting() + ":User:" + user.getName();
    }

}
