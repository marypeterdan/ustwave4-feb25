package com.stackroute.passenger.config;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponseHandler {

	public static ResponseEntity<Object>  genearteRespnse(String message, HttpStatus status,Object res)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("Mesage", message);
		map.put("status", status.value());
		map.put("data", res);
		map.put("Date", LocalDate.now());
		return new ResponseEntity(map,status);
		
		
	}
	
	
}
