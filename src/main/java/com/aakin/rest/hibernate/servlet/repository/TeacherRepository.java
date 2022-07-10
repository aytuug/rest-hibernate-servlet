package com.aakin.rest.hibernate.servlet.repository;


import com.aakin.rest.hibernate.servlet.hibernate.entity.Teacher;
import com.aakin.rest.hibernate.servlet.service.HibDataSource;
import org.hibernate.Session;

import java.util.List;

public class TeacherRepository {


    public static List<Teacher> GetTeacherList(){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        List<Teacher> list = session.createQuery("FROM Teacher ").getResultList();
        for (Teacher teacher : list){
            System.out.println(teacher.getFirstName());
        }
        session.getTransaction().commit();
        return list;
    }
}
