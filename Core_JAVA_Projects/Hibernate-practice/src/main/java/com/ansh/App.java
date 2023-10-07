package com.ansh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Project Started!!!!" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= cfg.buildSessionFactory();

        //creating student
        Student st = new Student();
        st.setId(105);
        st.setName("aman");
        st.setCity("gurgaon");
        System.out.println(st);

        //address class
        Address address = new Address();
        address.setStreet("street1");
        address.setCity("gurgaon");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1441234.24313242);

        //reading image
//        FileInputStream fis= new FileInputStream("src/main/IMG_3098.jpeg");
//        byte[] data = new byte[fis.available()];
//        fis.read(data);
//        address.setImage(data);

        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();

        currentSession.save(st);
        currentSession.save(address);

        currentSession.getTransaction().commit();
        currentSession.close();
        System.out.println("Done");

    }
}
