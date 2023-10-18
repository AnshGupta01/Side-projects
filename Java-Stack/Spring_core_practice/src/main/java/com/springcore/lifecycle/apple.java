package com.springcore.lifecycle;

public class apple {
    private double price;

    public apple(double price) {
        this.price = price;
    }

    public apple() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        System.out.println("Setting price...");
        this.price = price;
    }

    @Override
    public String toString() {
        return "apple{" +
                "price=" + price +
                '}';
    }

    public void init(){
        System.out.println("Inside Init method...");
    }
    public void destroy(){
        System.out.println("Inside the destroy method...");
    }
}

