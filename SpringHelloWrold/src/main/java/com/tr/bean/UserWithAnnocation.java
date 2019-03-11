package com.tr.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Component("userW")  //相当于applicationContext.xml里配置 <bean name="userW" class="...">
    @Service("")    // service层
    @Controller("") // web层
    @Repository("") // dao 层
//这三个注解是为了使用者划分层次

@Scope(scopeName = "prototype") //singleton //作用类型 单例或者多例

public class UserWithAnnocation {
    @Value("tom")   //给name属性赋值  @Value可以加在属性上（直接对属性赋值 破坏了封装性），可以加在set方法上(操作set方法)
    private String name;
    @Value(value = "18")
    private Integer age;
    private Car car;

    public String getName() {
        return name;
    }
    @Value("tom")
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
