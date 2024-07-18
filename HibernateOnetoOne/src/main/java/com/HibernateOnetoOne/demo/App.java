package com.HibernateOnetoOne.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;                  
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
 SessionFactory sessionfactory = cfg.buildSessionFactory();
        
        Session session = sessionfactory.openSession();
        
        Transaction tr = session.beginTransaction();
        
        Husband hs = new Husband();
        Wife wf = new Wife();
        
        hs.setHid(1);
        hs.sethName("shivam");
        hs.setWife(wf);
        
        wf.setwId(1);
        wf.setwName("sakshi");
        wf.setHusband(hs);
        
        session.save(wf);
        session.save(hs);
        
        tr.commit();
        session.close();
        
        System.out.println("add the data successfully!");
    }
}
