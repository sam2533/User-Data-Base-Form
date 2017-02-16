package com.um.sam;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.um.sam.model.Customer;
import com.um.sam.model.Txn;
import com.um.sam.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
    	Txn txn = buildDemoTxn();
    	Txn txn2 = buildDemoTxn2();
    	SessionFactory sessionFactory = null;
    	Session session  = null;
    	Transaction tx = null;
    	try{
    		sessionFactory = HibernateUtil.getsessionFactory();
    		session = sessionFactory.getCurrentSession();
    		tx = session.beginTransaction();
    		session.save(txn);
    		session.save(txn2);
    		tx.commit();
    		session.close();
    		System.out.println("Transaction is: "+txn.getId()+ "\n & "+ txn2.getId());
    	}
    	catch(Exception e){
    		System.out.println("Session factory failed: "+e.getMessage());
    		e.printStackTrace();
    	}finally{
    		if(sessionFactory != null && !sessionFactory.isClosed()){
    			System.out.println("Session factory is going to close now");
    			sessionFactory.close();
    		}
    	}
    }

	private static Txn buildDemoTxn2() {
		Txn txn2 = new Txn();
	       txn2.setDate(new Date());
	       txn2.setTotal(150);
	       
	       Customer customer2 = new Customer();
	       customer2.setName("Saidul Said");
	       customer2.setEmail("saidulsaid777@gmail.com");
	       customer2.setAddress("University of Malaya");
	       txn2.setCust(customer2);
	       customer2.setTxn(txn2);
		return txn2;
	}

	private static Txn buildDemoTxn() {
		  Txn txn = new Txn();
	       txn.setDate(new Date());
	       txn.setTotal(100);
	       
	       Customer customer = new Customer();
	       customer.setName("Nasrin Akter");
	       customer.setEmail("rokaiya123@yahoo.com");
	       customer.setAddress("North South University, Bashudhara, Dhaka");
	 
	       txn.setCust(customer);
	       customer.setTxn(txn);
		return txn;
	}
}
