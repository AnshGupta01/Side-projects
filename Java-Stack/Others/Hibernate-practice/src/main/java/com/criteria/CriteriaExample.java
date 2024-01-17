package com.criteria;

import com.ansh.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

//criteria functionality implementation, although deprecated
public class CriteriaExample {
    public static void main(String[] args) {
        Session s =
                new Configuration().configure().buildSessionFactory().openSession();

        Criteria criteria = s.createCriteria(Student.class);
//        criteria.add(Restrictions.eq("certi.course","Hibernate"));

        //pulls with id more than 1418
//        criteria.add(Restrictions.gt("id",1418));

        //pulls with alike name
        criteria.add(Restrictions.like("certi.course","Java%"));


        List<Student> list = criteria.list();
        for(Student x: list){
            System.out.println(x);
        }


        s.close();


    }
}
