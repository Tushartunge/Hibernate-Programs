package com.hiber.demo;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *Configuation
 *SessionFactory
 *Session
 *Transaction
 *Query 
 *SQL - structural query language
 *HQL- Hibernate Query Language
 *HCQL- Hibernate Criteria Query Language (HCQL) 
 *is used to fetch the records based on the specific criteria.
 *
 *select * from employee- sql
 *from employee         - hql
 *
 *
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Session session=HibernateUtil.getSessionFactory().openSession();
    	Transaction tx=session.beginTransaction();
    	
    	Employee emp=new Employee();
    	emp.setName("Sukesh");
    	emp.setSalary(300000);
    	emp.setJob("developer");
    	session.save(emp);
    	System.out.println(" employee added");
    	//TypedQuery query=session.getNamedQuery("findEmployeeByName");
    	TypedQuery query=session.getNamedQuery("findEmployees");
    	//query.setParameter("name", "Tushar");
    	
    	List<Employee> employees=query.getResultList();
    	Iterator<Employee> itr=employees.iterator();
    	while(itr.hasNext())
    	{
    		Employee e=itr.next();
    		System.out.println(e);
    	}
    	
    	tx.commit();
    	session.close(); 
    } 
}
