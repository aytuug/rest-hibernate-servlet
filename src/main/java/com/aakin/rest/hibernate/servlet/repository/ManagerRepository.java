package com.aakin.rest.hibernate.servlet.repository;


import com.aakin.rest.hibernate.servlet.hibernate.entity.Manager;
import com.aakin.rest.hibernate.servlet.service.HibDataSource;
import org.hibernate.Session;
import java.util.List;

public class ManagerRepository {

    public static Manager FindById(int id){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        Manager manager = (Manager) session.get(Manager.class, id);
        return manager;
    }

    public static int SignUp(Manager manager){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        int id = (int) session.save(manager);
        session.getTransaction().commit();
        return id;
    }


    public static void UpdateManager(Manager manager){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        session.merge(manager);

        session.beginTransaction().commit();
    }

    public static List<Manager> GetManagerList(){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        List<Manager> list = session.createQuery("FROM Manager").getResultList();
        for (Manager manager : list){
            System.out.println(manager.getFirstName());
        }
        session.getTransaction().commit();
        return list;
    }

    public static void deleteMan(int id){
        Session session = HibDataSource.getSession();
        session.beginTransaction();

        Manager manager = (Manager) session.get(Manager.class, id);
        session.delete(manager);
        session.getTransaction().commit();
    }


}
