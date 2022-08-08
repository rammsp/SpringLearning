package com.luv2code.hibernatedemo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Employee_ID")
	private int employeeId;
	
	@Column(name="Employee_Name")
	private String employeeName;
	
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	public Employee() {
		super();
	}

	public Employee(String employeeName, Date dateOfBirth) {
		super();
		this.employeeName = employeeName;
		this.dateOfBirth = dateOfBirth;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	

}
