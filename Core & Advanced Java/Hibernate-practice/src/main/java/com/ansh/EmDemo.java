package com.ansh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= cfg.buildSessionFactory();

        //Student 1
        Student s1 = new Student();
        s1.setId(144);
        s1.setName("Ankit");
        s1.setCity("Delhi");
        Certificate c1 = new Certificate();
        c1.setCourse("Android");
        c1.setDuration("2 Months");
        s1.setCerti(c1);

        //Student 2
        Student s2 = new Student();
        s2.setId(145);
        s2.setName("Ashhhh");
        s2.setCity("Delhi");
        Certificate c2 = new Certificate();
        c2.setCourse("Hibernate");
        c2.setDuration("2 Months");
        s2.setCerti(c2);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //save objects
        session.save(s1);
        session.save(s2);

        tx.commit();
        session.close();

        sessionFactory.close();
    }
}
