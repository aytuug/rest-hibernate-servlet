package com.aakin.rest.hibernate.servlet.hibernate.operations;


import com.aakin.rest.hibernate.servlet.hibernate.entity.Manager;
import com.aakin.rest.hibernate.servlet.hibernate.entity.School;
import com.aakin.rest.hibernate.servlet.hibernate.entity.Student;
import com.aakin.rest.hibernate.servlet.hibernate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateTeacherAndStudentDemo {

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

            session.beginTransaction();

            Student student = new Student("Sude","Durak");
            session.persist(student);
            System.out.println("Saved the student: " + student);

            //create the teachers

            Teacher teacher1 = new Teacher("Engin", "Kandıran");
            Teacher teacher2 = new Teacher("Mahmut", "Bagci");

            student.addTeacher(teacher1);
            student.addTeacher(teacher2);


            System.out.println("\n Saving teachers..");

            session.persist(teacher1);
            session.persist(teacher2);

            System.out.println("Saved teachers: " + student.getTeachers());

            //add teacher to the

            session.getTransaction().commit();
            System.out.println("Congrats Aytug!");

        }finally {
            session.close();
            factory.close();
        }





    }




}
