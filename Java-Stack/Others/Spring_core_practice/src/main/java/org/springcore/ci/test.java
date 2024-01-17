package org.springcore.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context2 =
                new ClassPathXmlApplicationContext("ci-config.xml");

//        Person person1 = (Person) context2.getBean("person1");
//        System.out.println(person1);
//        System.out.println(person1.getList());

        Addition add = (Addition) context2.getBean("addition");
        add.doSum();

    }

}
