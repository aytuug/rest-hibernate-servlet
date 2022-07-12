package com.aakin.rest.hibernate.servlet.repository;


import com.aakin.rest.hibernate.servlet.hibernate.entity.School;
import com.aakin.rest.hibernate.servlet.service.HibDataSource;
import org.hibernate.Session;


import java.util.List;

public class SchoolRepository {

    public  School FindById(int id){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        School school = (School) session.get(School.class, id);
        return school;
    }

    public  int SignUp(School school){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        int id = (int) session.save(school);
        session.getTransaction().commit();
        return id;
    }


    public  void UpdateSchool(School school){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        session.merge(school);

        session.beginTransaction().commit();
    }

    public  List<School> GetSchoolList(){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        List<School> list = session.createQuery("FROM School").getResultList();

        session.getTransaction().commit();
        return list;
    }

    public  void deleteSch(int id){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        School school = (School) session.get(School.class, id);
        session.delete(school);
        session.getTransaction().commit();
    }




}
