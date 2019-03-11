package com.orika;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaTest {
    public static void main(String[] args) {
        new UseDemo().fun2();
    }
}

/**
 *  MapperFactory用于注册字段映射，配置转换器，自定义映射器等
 *  MapperFacade和spring，apache中的BeanUtils具有相同的地位，负责对象间的映射，也是实际使用中，我们使用的最多的类
 */
class UseDemo {
    public void fun1() {
//        MapperFactory用于注册字段映射，配置转换器，自定义映射器等
        MapperFactory factory = new DefaultMapperFactory.Builder().build();
//        MapperFacade和spring，apache中的BeanUtils具有相同的地位，负责对象间的映射，也是实际使用中，我们使用的最多的类
        MapperFacade mapperFacade = factory.getMapperFacade();

        Person person = new Person();
        person.setAge(18);
        person.setName("t");
        //隐射成为新的person
        Person map = mapperFacade.map(person, person.getClass());
        System.out.println(map+"||||||"+person);
        System.out.println(map==person);

    }
    public void fun2() {
//        MapperFactory用于注册字段映射，配置转换器，自定义映射器等
        MapperFactory factory = new DefaultMapperFactory.Builder().build();
//        MapperFacade和spring，apache中的BeanUtils具有相同的地位，负责对象间的映射，也是实际使用中，我们使用的最多的类
        Person person = new Person();
        person.setAge(18);
        person.setName("t");

        PersonDTO map = factory.getMapperFacade().map(person, PersonDTO.class);
        System.out.println(map);

    }
}