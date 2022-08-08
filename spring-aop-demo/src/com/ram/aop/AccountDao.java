package com.ram.aop;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
	
	public String addAccount(String text) throws Exception {
		System.out.println("===> ===> ===> addAccount Method is being executed");
		if(true) { // set to true and test @AfterThrowing
		throw new Exception("Testing Exception!!!");
		}
		return "rama";
	}
	
	public String addAccountAoundTest(String text) throws Exception {
		System.out.println("===> ===> ===> addAccount Method is being executed");
		if(true) { // set to true and test @AfterThrowing
		throw new Exception("Testing Exception!!!");
		}
		return "rama";
	}

}
