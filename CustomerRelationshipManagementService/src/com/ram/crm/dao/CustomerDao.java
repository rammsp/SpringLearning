package com.ram.crm.dao;

import java.util.List;

import com.ram.crm.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);

}