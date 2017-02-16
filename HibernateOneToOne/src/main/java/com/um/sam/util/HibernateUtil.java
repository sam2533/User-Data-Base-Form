package com.um.sam.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.um.sam.model.Customer;
import com.um.sam.model.Txn;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory(){
		Configuration config = new Configuration();
		config.configure().addAnnotatedClass(Txn.class).addAnnotatedClass(Customer.class);
		System.out.println("Hibernate Configuration loaded.....");
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		System.out.println("Service Registry created.......");
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	public static SessionFactory getsessionFactory(){
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
		return sessionFactory;
		
	}
}
