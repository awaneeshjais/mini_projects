package com.simplebank.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	 static {
	 try {
		 Configuration cfg = new Configuration().configure("com/simplebank/db/hibernate.cfg.xml");
		 //Configuration cfg = new Configuration().configure();
		 sessionFactory = cfg.buildSessionFactory();
	 } catch (Throwable ex) {
		 System.err.println("Initial SessionFactory creation failed. --> " + ex);
		 throw new ExceptionInInitializerError(ex);
	 	}
	 }
	 public static SessionFactory getSessionFactory() {
	 return sessionFactory;
	 }
}
