package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
public class mango {

    private String price;

    public mango() {
    }

    public mango(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "mango{" +
                "price='" + price + '\'' +
                '}';
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @PostConstruct
    public void start(){
        System.out.println("starting method");
    }

    @PreDestroy
    public void end(){
        System.out.println("ending the method");
    }
}
