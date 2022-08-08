package com.ram.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoSecurityAspect {
	

	@Before("execution(public String addAccount(*))")
	public void beforeAddAccountAspectSecurity(JoinPoint joinPoint) {
		System.out.println("===> ===> ===>  ===> Before Aspect Method SECURITY is being executed");
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println(methodSignature);
		
		Object args[] = joinPoint.getArgs();
		for (Object arg: args) {
			System.out.println(arg);
		}
	}
	
	@Around("execution(public String addAccountAoundTest(String) throws Exception)")
	public Object aroundAddAccountAoundTest (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		Logger logger = Logger.getLogger(getClass().getName());
		
		long start = System.currentTimeMillis();
		
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			logger.warning(e.getMessage());
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		long timeTaken = end - start;
		
		logger.info("Time Taken: " + timeTaken);
		
		return result;
	}

	
}
