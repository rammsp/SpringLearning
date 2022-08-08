package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDataAddDemo2 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			Instructor instructor = new Instructor("Rama", "Moorthy", "Ramsishu@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("Java Coding Classes", "Java Coding");
			instructor.setInstructorDetail(instructorDetail);
			
			Course courseOne = new Course("Spring MVC - 1");
			instructor.addCourse(courseOne);
			
			Student studentOne = new Student("Raj", "Kumar", "Raj@gmail.com");
			Student studentTwo = new Student("Ram", "Kumar", "Ram@gmail.com");
			Student studentThree = new Student("Rai", "Kumar", "Rai@gmail.com");

			courseOne.add(studentOne);
			courseOne.add(studentTwo);
			courseOne.add(studentThree);
			
			session.save(instructor);
			session.save(studentOne);
			session.save(studentTwo);
			session.save(studentThree);
			session.save(courseOne);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
	}

}
