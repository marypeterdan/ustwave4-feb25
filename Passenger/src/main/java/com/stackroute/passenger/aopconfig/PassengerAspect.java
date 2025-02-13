package com.stackroute.passenger.aopconfig;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class PassengerAspect {

	Logger log=LoggerFactory.getLogger(PassengerAspect.class);
	
	@After("execution(*  com.stackroute.passenger.controller.PassengerController.viewall(..))")
	public void afterViewCalled(JoinPoint jp)
	{
		log.info("Some one called view method of passenger @ " + LocalDateTime.now());
	}
	
	@Around("addadvice()")
	public Object afterSave(ProceedingJoinPoint proceedobj) throws Throwable
	{
		
		var obj=proceedobj.proceed();
		
		try
		{
			log.info("A new passenger got added " + obj.toString() + " on " + LocalDate.now());
		}
		catch(Exception e)
		{
			
		}
		
		return obj;
		
	}
	
	
	@AfterThrowing(pointcut="addadvice()" , throwing="excep")
	public void handleError(Exception excep)
	{
		log.warn(" Exception thrown and not handled " + excep.getMessage() + LocalDate.now());
	}
	
	
	@Pointcut("execution(*  com.stackroute.passenger.controller.PassengerController.addPassenger(..))")
	public void addadvice()
	{
		
	}
	
	
}
