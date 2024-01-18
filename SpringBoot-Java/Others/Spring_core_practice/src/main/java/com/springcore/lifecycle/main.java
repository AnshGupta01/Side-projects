package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("lifecycle-config.xml");

//        apple apple = (apple) context.getBean("apple1");
//        System.out.println(apple);
//        //shutdown hook from Abstract Application Context clas
//        context.registerShutdownHook();

//        pepsi p = (pepsi) context.getBean("pepsi1");
//        System.out.println(p);

        mango mango = (mango) context.getBean("mango1");
        System.out.println(mango);

        context.registerShutdownHook();


    }
}
