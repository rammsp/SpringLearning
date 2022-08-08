package com.ram.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ram.crm.dao.CustomerDao;
import com.ram.crm.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("/list")
	public String getCustomerList(Model theModel) {
		List<Customer> customers = customerDao.getCustomers();
		theModel.addAttribute("customers", customers);
		return "customer-list";
	}

}
