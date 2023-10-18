package org.springcore.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ref-config.xml");

        A temp = (A) context.getBean("aref");
        System.out.println(temp.getX());

        System.out.println(temp);

        //got the value of y from ob
        System.out.println(temp.getOb().getY());
    }
}
