package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@RestController
@RequestMapping("/index")
public class SpringBootStartApplication  extends SpringBootServletInitializer {

////    @GetMapping("/")
//    public ModelAndView index() {
//        return new ModelAndView();
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringBootStartApplication.class, args);
//    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(Application.class);
    }


}
