package com.ram.springbootemployee.dao;

import java.util.List;

import com.ram.springbootemployee.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(int employeeId);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int employeeId);

}