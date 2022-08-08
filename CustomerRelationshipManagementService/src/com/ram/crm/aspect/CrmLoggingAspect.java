package com.ram.crm.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CrmLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.ram.crm.controller.*.*(..))")
	private void forController() {}
	
	@Pointcut("execution(* com.ram.crm.service.*.*(..))")
	private void forService() {}
	
	@Pointcut("execution(* com.ram.crm.dao.*.*(..))")
	private void forDao() {}
	
	@Pointcut("forController() || forService() || forDao()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String methodName = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> In @Before CALLING METHOD: " + methodName);
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg: args) {
			myLogger.info("===> Argument: " + tempArg);
		}
	}
	
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturn(JoinPoint theJoinPoint, Object theResult) {
		String methodName = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> In @AfterRetuning CALLING METHOD: " + methodName);
		myLogger.info("===> Return Value: " + theResult);
	}
	
}
