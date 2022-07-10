package com.aakin.rest.hibernate.servlet.hibernate.operations;



import com.aakin.rest.hibernate.servlet.hibernate.entity.Manager;
import com.aakin.rest.hibernate.servlet.hibernate.entity.School;
import com.aakin.rest.hibernate.servlet.hibernate.entity.Student;
import com.aakin.rest.hibernate.servlet.hibernate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateOperations {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(School.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Teacher.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            School school = new School("Yeditepe University");
            Manager manager = new Manager("Aytug","Akin",70);

            School school1 = new School("YTU");
            Manager manager1 = new Manager("Tamer", "Yılmaz", 160);

            school.setManager(manager);
            school1.setManager(manager1);
            session.beginTransaction();

            System.out.println("Saving school: " + school);
            session.persist(school);
            session.persist(school1);




            session.getTransaction().commit();
        }finally {
            factory.close();
        }



    }





}
