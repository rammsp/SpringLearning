package com.ram.springbootemployee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ram.springbootemployee.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getEmployees() {
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee e", Employee.class);
		return theQuery.getResultList();
	}

	@Override
	public Employee getEmployee(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public void saveEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		entityManager.merge(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Query thequery = entityManager.createQuery("delete from Employee e where e.id = :empIdVal");
		thequery.setParameter("empIdVal", employeeId);
		thequery.executeUpdate();
	}

}
