package com.ram.springbootemployee.restcontroller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.springbootemployee.entity.Employee;
import com.ram.springbootemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee employee = employeeService.getEmployee(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee ID Not Found: " + employeeId);
		}
		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.saveEmployee(employee);
		return employee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		int employeeId = employee.getId();
		Employee theemployee = employeeService.getEmployee(employeeId);
		if (theemployee == null) {
			throw new RuntimeException("Employee ID Not Found: " + employeeId);
		}

		employeeService.saveEmployee(employee);
		return employee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {
		Employee employee = employeeService.getEmployee(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee ID Not Found: " + employeeId);
		}
		employeeService.deleteEmployee(employeeId);
		return "Employee Id Deleted: " + employeeId;
	}

}
