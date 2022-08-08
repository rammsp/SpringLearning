package com.luv2code.hibernatedemo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDataDateDemo {

	public static void main(String[] args) throws ParseException {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			Employee theEmployee = new Employee("EmployeeOne", DateUtils.parseDate("01/02/1989"));
			session.beginTransaction();
			session.save(theEmployee);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
