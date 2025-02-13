package com.stackroute.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.stackroute.passenger.filter.PassengerFilter;

@SpringBootApplication
public class PassengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassengerApplication.class, args);
	}
	
//	@Bean
//	public FilterRegistrationBean gefilter()
//	{
//		FilterRegistrationBean fillbean=new FilterRegistrationBean();
//		fillbean.setFilter(new PassengerFilter());
//		fillbean.addUrlPatterns("/admin/*");
//		return fillbean;
//		
//	}

}
