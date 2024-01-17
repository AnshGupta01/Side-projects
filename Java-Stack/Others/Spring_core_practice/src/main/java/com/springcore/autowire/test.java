package com.springcore.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("autowire-config.xml");
    Employee emp = context.getBean("employee1", Employee.class);
        System.out.println(emp);
    }
}
