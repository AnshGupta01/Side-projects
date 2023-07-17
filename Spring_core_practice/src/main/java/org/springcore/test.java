package org.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("collection-config.xml");
        Emp employee1 = (Emp) context.getBean("Employee1");

        System.out.println(employee1.getName());
        System.out.println(employee1.getPhones());
        System.out.println(employee1.getAddresses());
        System.out.println(employee1.getCourses());
        System.out.println(employee1.getProps());

    }
}
