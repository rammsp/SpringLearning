package com.ram.springbootemployee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.springbootemployee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
