package com.ansh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        //get and load both
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();
        //get-student:101
        Student student = session.get(Student.class, 102);
        System.out.println(student);

        Address ad =session.get(Address.class,3);
        System.out.println(ad.getAddedDate());


        sessionFactory.close();
    }
}
