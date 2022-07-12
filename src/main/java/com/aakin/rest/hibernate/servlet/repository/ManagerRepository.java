package com.aakin.rest.hibernate.servlet.repository;


import com.aakin.rest.hibernate.servlet.hibernate.entity.Manager;
import com.aakin.rest.hibernate.servlet.service.HibDataSource;
import org.hibernate.Session;
import java.util.List;

public class ManagerRepository {

    public  Manager FindById(int id){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        Manager manager = (Manager) session.get(Manager.class, id);
        return manager;
    }

    public  int SignUp(Manager manager){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        int id = (int) session.save(manager);
        session.getTransaction().commit();
        return id;
    }


    public  void UpdateManager(Manager manager){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        session.merge(manager);

        session.beginTransaction().commit();
    }

    public  List<Manager> GetManagerList(){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        List<Manager> list = session.createQuery("FROM Manager").getResultList();

        session.getTransaction().commit();
        return list;
    }

    public  void deleteMan(int id){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        Manager manager = (Manager) session.get(Manager.class, id);
        session.delete(manager);
        session.getTransaction().commit();
    }


}
