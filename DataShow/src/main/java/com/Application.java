package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@RestController
@RequestMapping("/index")
public class Application {

//    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
