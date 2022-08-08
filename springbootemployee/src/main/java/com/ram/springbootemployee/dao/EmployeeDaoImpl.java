package com.ram.springbootemployee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ram.springbootemployee.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getEmployees() {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = session.createQuery("from Employee e", Employee.class);
		return theQuery.getResultList();
	}

	@Override
	public Employee getEmployee(int employeeId) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Employee.class, employeeId);
	}

	@Override
	public void saveEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Session session = entityManager.unwrap(Session.class);
		Query thequery = session.createQuery("delete from Employee e where e.id = :empIdVal");
		thequery.setParameter("empIdVal", employeeId);
		thequery.executeUpdate();
	}

}
