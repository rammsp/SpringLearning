package com.luv2code.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDataQueryDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try {
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student s Where s.email = 'Rahim@yahoo.co.in'").list();
			session.getTransaction().commit();
			
			for (Student currStudent: students) {
				System.out.println(currStudent.getId() + "\t" + currStudent.getFirstName() + "\t" + currStudent.getEmail());
			}
			
		} finally {
			factory.close();
		}

	}

}
