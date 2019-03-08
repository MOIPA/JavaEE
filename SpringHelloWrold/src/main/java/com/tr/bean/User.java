package com.tr.bean;

public class User {
    private String name;
    private Integer age;
    private Car car;


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void init() {
        System.out.println("init bean");
    }

    public void destory() {
        System.out.println("destory");
    }

    @Override
    public String toString() {
        return this.getAge()+" "+this.getName()+this.getCar();
    }
}
