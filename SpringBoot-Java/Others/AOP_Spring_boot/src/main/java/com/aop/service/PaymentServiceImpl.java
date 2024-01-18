package com.aop.service;

public class PaymentServiceImpl implements PaymentService{

    //Payment Code
    public void makePayment(int amount) {

        //payment code
        System.out.println(amount+ " Amount Debited");
        //example processes
        System.out.println(amount + " Amount Credited");

    }
}
