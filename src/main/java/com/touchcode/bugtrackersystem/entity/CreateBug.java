package com.touchcode.bugtrackersystem.entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateBug {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Bugs.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			System.out.println("Creating new student object...");
			Bugs tempBug = new Bugs();
			tempBug.setDate(new Date());
			tempBug.setId(45);
			tempBug.setStatus("Fixed");
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the Bug...");
			session.save(tempBug);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





