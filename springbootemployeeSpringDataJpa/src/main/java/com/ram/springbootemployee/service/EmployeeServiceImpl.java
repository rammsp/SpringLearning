package com.ram.springbootemployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ram.springbootemployee.dao.EmployeeRepository;
import com.ram.springbootemployee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public List<Employee> getEmployees() {	
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee getEmployee(int employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
