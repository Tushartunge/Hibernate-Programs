package com.Hybernate.demo.hybernate1;

import org.hibernate.*;
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
        cfg.configure("hybernateconf.xml");
        //session factory created
        SessionFactory sessionfactory = cfg.buildSessionFactory();
        
        Session session = sessionfactory.openSession();
        
        Transaction tr = session.beginTransaction();
        
        
       //map object to database
        Employee emp1=new Employee();
        emp1.setId(1);
        emp1.setName("tushar");
        emp1.setDept("It");
        emp1.setSalary(1000000);
        
        session.save(emp1);
        
        tr.commit();
        session.close();
    }
}
