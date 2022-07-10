package com.aakin.rest.hibernate.servlet.service;


import com.aakin.rest.hibernate.servlet.hibernate.entity.Manager;
import com.aakin.rest.hibernate.servlet.hibernate.entity.School;
import com.aakin.rest.hibernate.servlet.hibernate.entity.Student;
import com.aakin.rest.hibernate.servlet.hibernate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibDataSource {

    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Manager.class)
                    .addAnnotatedClass(School.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Teacher.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession(){
        Session session = getSessionFactory().openSession();
        return session;
    }

    public static void closeSession(Session session) {
        if (session != null) {

            session.close();

        }


    }
}
