package com.aakin.rest.hibernate.servlet.repository;


import com.aakin.rest.hibernate.servlet.hibernate.entity.Student;
import com.aakin.rest.hibernate.servlet.service.HibDataSource;
import org.hibernate.Session;


import java.util.List;

public class StudentRepository {

    public static Student FindById(int id){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        Student student = (Student) session.get(Student.class, id);
        return student;
    }

    public static int SignUp(Student student){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        int id = (int) session.save(student);
        session.getTransaction().commit();
        return id;
    }


    public static void UpdateStudent(Student student){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        session.merge(student);

        session.beginTransaction().commit();
    }

    public static List<Student> GetStudentList(){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        List<Student> list = session.createQuery("FROM Student ").getResultList();
        for (Student student : list){
            System.out.println(student.getFirstName());
        }
        session.getTransaction().commit();
        return list;
    }

    public static void deleteStu(int id){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        Student student = (Student) session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
    }





}
