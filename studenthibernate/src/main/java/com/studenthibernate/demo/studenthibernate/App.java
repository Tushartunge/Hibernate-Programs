package com.studenthibernate.demo.studenthibernate;


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
       
       Student st = new Student();
       
       st.setSid(1);
       st.setName("tushar");
       st.setAddress("pune");
       st.setMarks("120");
       st.setPhoneno(755912330);
       
       session.save(st);
       
       tr.commit();
       session.close();
       
       System.out.println("record added");
       
    }
}
