package com.ansh;

import com.ansh.Certificate;
import com.ansh.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
    public static void main(String[] args) {
        //Transient
        //persistent
        //detatched
        //removed

        System.out.println("example: ");
        SessionFactory f = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //creating student
        Student student = new Student();
        student.setId(1414);
        student.setName("ANSHHH");
        student.setCity("Delhi");
        student.setCerti(new Certificate
                ("Java Hibernate Course","3 Months"));
        //Object: Transient State

        Session s = f.openSession();
        Transaction tx = s.beginTransaction();
        s.save(student);
        //Object: Persistent State - session, database
        student.setName("John");
        tx.commit();

        s.close();
        //Object: Detached State
        student.setName("ANSHHH");

        //To put object in removed state
        Student student1 = s.get(Student.class, 1414);
        s.delete(student1);
        student1.setName("ABSSSSS");


        f.close();
    }
}
