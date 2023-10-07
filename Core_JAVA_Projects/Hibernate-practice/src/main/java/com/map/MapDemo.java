package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= cfg.buildSessionFactory();

//        //Create Question
//        Question q1 = new Question();
//        q1.setQuestionId(1212);
//        q1.setQuestion("What is java?");
//        //Creating answer
//        Answer a1 = new Answer();
//        a1.setAnswerId(343);
//        a1.setAnswer("JAVA is a progamming language");
//        a1.setQuestion(q1);
//
//        //one more answer
//        Answer a2 = new Answer();
//        a2.setAnswerId(345);
//        a2.setAnswer("JAVA used to create softwares");
//        a2.setQuestion(q1);
//        //one more
//        Answer a3 = new Answer();
//        a3.setAnswerId(346);
//        a3.setAnswer("JAVA has hibernate");
//        a3.setQuestion(q1);
//
//        List<Answer> list = new ArrayList<>();
//        list.add(a1);
//        list.add(a2);
//        list.add(a3);
//
//        q1.setAnswers(list);

//
//        //Create Question
//        Question q2 = new Question();
//        q2.setQuestionId(242);
//        q2.setQuestion("What is Collection Framework?");
//        //Creating answer
//        Answer a2 = new Answer();
//        a2.setAnswerId(344);
//        a2.setAnswer("API to work with objects in java");
//        a2.setQuestion(q2);
//        q2.setAnswer(a2);
//
//        //session
        Session s=sessionFactory.openSession();
        Transaction tx = s.beginTransaction();

        //save
//        s.save(a1);
//        s.save(a2);
//        s.save(a3);
//        s.save(q1);
//        tx.commit();

        //enactment of lazy loading as it loads answers only when
        //the size function is called in the code
        //but now ive added eager loading in the Question class code
        Question q = s.get(Question.class,1212);
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());
        System.out.println(q.getAnswers().size());
//


//        Question q = s.get(Question.class,1212);
//        System.out.println(q.getQuestion());
//        for(Answer a : q.getAnswers()){
//            System.out.println(a.getAnswer());
//        }

//        //fetching
//        Question question = s.get(Question.class, 1212);
//        System.out.println(question.getQuestion());
//        System.out.println(question.getAnswer().getAnswer());
        s.close();
        sessionFactory.close();
    }
}
