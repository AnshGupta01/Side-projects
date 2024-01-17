package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class pepsi implements InitializingBean, DisposableBean {
    private double price;

    public pepsi() {
        super();
    }

    public pepsi(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "pepsi{" +
                "price=" + price +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialising the bean... : INIT");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Disposing the bean... : DESTROY");
    }
}
