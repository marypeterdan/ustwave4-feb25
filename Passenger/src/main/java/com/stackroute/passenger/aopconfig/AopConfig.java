package com.stackroute.passenger.aopconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
	
	@Bean
	public PassengerAspect getAspect()
	{
		return new PassengerAspect();
	}

}
