package com.stackroute.passenger.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.stackroute.passenger.config.CustomResponseHandler;
import com.stackroute.passenger.exception.IdAlreadyExistException;
import com.stackroute.passenger.exception.IdNotFoundException;
import com.stackroute.passenger.model.Passenger;
import com.stackroute.passenger.service.PassengerService;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/passenger")
 
public class PassengerController {

	
	@Autowired
	PassengerService passengerService;
	
	
	@PostMapping("/admin/add")
	public ResponseEntity<?> addPassenger( @RequestBody Passenger passeng) throws IdAlreadyExistException
	{
		
 	try {
 		//passeng.setDateofjourney(LocalDate.now());
			Passenger result=passengerService.addPassenger(passeng);
			
	// return CustomResponseHandler.genearteRespnse("Passenger Data Retried successfully",HttpStatus.CREATED, result);
			return new ResponseEntity<Passenger>(result,HttpStatus.CREATED);
 	} 
 	
 	catch (IdAlreadyExistException e) {
		 	return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
			 
		 }
		
		
	}
	
	@GetMapping("/admin/viewbynameanddoj/{name}/{doj}")
	public ResponseEntity<?> getbynameanddoj(@PathVariable("name") String tname,@JsonDeserialize @PathVariable("doj") LocalDate doj)
	{
		
		List<Passenger> passengers=passengerService.findByTrainNameDOJ(tname, doj);
		
		return new ResponseEntity<List>(passengers,HttpStatus.OK);
		
	}
	
	@GetMapping("/customer/view")
	public ResponseEntity<?> viewall(HttpSession httpsession)
	{
		String username=(String) httpsession.getAttribute("uname");
		
		System.out.println("Logged in admin user is " + username);
		List<Passenger> passengers=passengerService.getAllPassengers();
		
		return new ResponseEntity<List>(passengers,HttpStatus.OK);
		
	}
	
	
 
	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int passid) throws IdNotFoundException
	{
		
		try {
	boolean result=	passengerService.deletePassenger(passid);
	String resbody="Passenger with Id " + passid + "Removed";
	 
		return CustomResponseHandler.genearteRespnse("Deleted successfully", HttpStatus.OK,resbody );
	}
	catch(Exception e)
		{
		
		return CustomResponseHandler.genearteRespnse("Failed", HttpStatus.NOT_FOUND,"No record found");
	
	}
		
	}
	
}
