package com.tr.test;

import com.tr.bean.Car;
import com.tr.bean.ComplexUser;
import com.tr.bean.User;
import com.tr.bean.UserWithAnnocation;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    @Test
    public void func1() {
        //1 创建容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2 向容器要javaBean
//        User user = (User) ac.getBean("user");
        User user = (User) ac.getBean("user2");
        //3打印user对象
        System.out.println(user);

        //通过构造函数配置的对象
        Car car2 = (Car) ac.getBean("car2");

        ComplexUser cu = (ComplexUser) ac.getBean("cu");
        System.out.println(cu.getArr()[0]);
        System.out.println(cu.getArr()[1]);
        UserWithAnnocation userWithAnnocation = (UserWithAnnocation) ac.getBean("userW");
        System.out.println("user with annocation"+userWithAnnocation);

        //4(可选) 销毁操作
        ac.close();
    }
}
