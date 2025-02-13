package com.stackroute.passenger.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="custom")
public class CustomEndpoint {

	
	@ReadOperation
	public  Map<String,String>  customEndpoint() {
		
		Map<String,String> result=new HashMap();
		result.put("Message", "This is passenger API, do run localhost:9090/swagger for more accessing");
		return result;
	}
}
