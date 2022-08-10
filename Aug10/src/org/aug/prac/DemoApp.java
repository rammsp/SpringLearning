package org.aug.prac;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoApp {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			/*
			 * Employee employeeOne = new Employee("Rama Moorthy",
			 * formatter.parse("02/02/1989")); session.save(employeeOne);
			 */

			/*
			 * Employee employeeTwo = session.get(Employee.class, 2);
			 * employeeTwo.setDateOfBirth(formatter.parse("02/02/1990"));
			 */

			/*
			 * session.
			 * createQuery("update Employee set employeeName = 'Rama V2' where employeeId="
			 * + 3).executeUpdate();
			 */

			List<Employee> employees = session.createQuery("from Employee where employeeId <> 1").getResultList();
			for (Employee employee : employees) {
				System.out.println(employee);
			}	 

			/*
			 * Employee employeeTwo = session.get(Employee.class, 2);
			 * session.delete(employeeTwo);
			 */

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}

	}

}
