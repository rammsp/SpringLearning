package com.ram.springbootemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ram.springbootemployee.dao.EmployeeDao;
import com.ram.springbootemployee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public List<Employee> getEmployees() {	
		return employeeDao.getEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployee(int employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

}
