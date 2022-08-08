package com.luv2code.springdemo;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@RequestMapping("/customerForm")
	public String showCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@RequestMapping("/processCustomerForm")
	public String processCustomerForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-added";
		}
	}

}
