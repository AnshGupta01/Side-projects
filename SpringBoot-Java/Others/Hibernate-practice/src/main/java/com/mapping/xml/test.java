package com.mapping.xml;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class test {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().configure().buildSessionFactory();

        Person person = new Person(20, "Ansh", "delhi", "7011898341");

        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        
        s.save(person);
        
        tx.commit();
        s.close();
        sessionFactory.close();
    }
}
