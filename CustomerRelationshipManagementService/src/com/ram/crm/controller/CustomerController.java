package com.ram.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ram.crm.entity.Customer;
import com.ram.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String getCustomerList(Model theModel) {
		List<Customer> customers = customerService.getCustomers();
		theModel.addAttribute("customers", customers);
		return "customer-list";
	}
	
	@GetMapping("/showFormForAddCustomer")
	public String showFormForAddCustomer(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		return "customer-add-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:list";
	}
	
	@GetMapping("/showFormForUpdateCustomer")
	public String showFormForUpdateCustomer(@RequestParam("customerId") int customerId, Model theModel) {
		Customer customer = customerService.getCustomer(customerId);
		theModel.addAttribute("customer", customer);
		return "customer-add-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int customerId, Model theModel) {
		customerService.deleteCustomer(customerId);
		return "redirect:list";
	}

}
