package com.luv2code.hibernatedemo;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CourseDataGetDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "join i.courses " + "where i.id=:idValue", Instructor.class);

			query.setParameter("idValue", 12);
			Instructor instructor = query.getSingleResult();
			System.out.println(instructor.getCourses());

			session.getTransaction().commit();
			
			System.out.println("*****************************");

			session = factory.getCurrentSession();
			session.beginTransaction();

			Query<Course> queryTwo = session.createQuery("select c from Course c " + "where c.instructor.id=:idValue",
					Course.class);
			
			queryTwo.setParameter("idValue", 12);
			List<Course> courses = queryTwo.getResultList();
			System.out.println(courses);
			
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
