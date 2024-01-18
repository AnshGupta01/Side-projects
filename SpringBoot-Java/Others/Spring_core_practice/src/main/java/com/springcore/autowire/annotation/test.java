package com.springcore.autowire.annotation;

import org.springcore.ref.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("autowire-config-anno.xml");
    Employee emp = context.getBean("employee1", Employee.class);
        System.out.println(emp);
    }
}
