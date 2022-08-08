package com.ram.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAppAround {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		String retVal;
		retVal = accountDao.addAccountAoundTest("Rama");
		context.close();
	}

}
