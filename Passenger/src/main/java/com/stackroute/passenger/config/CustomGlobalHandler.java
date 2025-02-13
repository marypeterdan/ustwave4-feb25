package com.stackroute.passenger.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.stackroute.passenger.exception.IdAlreadyExistException;

import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CustomGlobalHandler {

//	@ExceptionHandler(IdAlreadyExistException.class)
//	public ResponseEntity<?> handler(HttpServletResponse  res)
//	{
//		String data="Passenger id is already exist";
//		return CustomResponseHandler.genearteRespnse("PassengerNot Added",HttpStatus.CONFLICT, "duplicate id");
//	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerRequest(MethodArgumentNotValidException excep )
	{
		
		Map<String,Object> resbody=new HashMap();
		System.out.println(excep.getBindingResult());
	List<String> errors=excep.getBindingResult().getFieldErrors().stream()
		 	.map( obj-> obj.getDefaultMessage()).collect(Collectors.toList());
	
	resbody.put("Errors",errors);
	return new ResponseEntity(resbody,HttpStatus.NOT_FOUND);
		
		
		
	}
	
}
