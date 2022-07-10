package com.aakin.rest.hibernate.servlet.hibernate.operations;



import com.aakin.rest.hibernate.servlet.hibernate.entity.Manager;
import com.aakin.rest.hibernate.servlet.hibernate.entity.School;
import com.aakin.rest.hibernate.servlet.hibernate.entity.Student;
import com.aakin.rest.hibernate.servlet.hibernate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(School.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Teacher.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 5;
            School school = session.get(School.class, theId);

            Student student = new Student("Sude", "Durak");
            Student student1 = new Student("Cansu", "Akın");


            school.add(student);
            school.add(student1);



            session.persist(student);
            session.persist(student1);




            session.getTransaction().commit();
            System.out.println("Done Aytug!");
        }finally {
            session.close();
            factory.close();
        }



    }





}
