package com.springcore.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {

    @Autowired
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        System.out.println("Setting value");
        this.address = address;
    }

    public Employee() {
    }

    public Employee(Address address) {
        System.out.println("setting constructor");
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                '}';
    }
}
