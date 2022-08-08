package com.ram.springbootemployee.service;

import java.util.List;

import com.ram.springbootemployee.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(int employeeId);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int employeeId);

}
