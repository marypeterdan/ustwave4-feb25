package com.stackroute.passenger.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.passenger.exception.IdAlreadyExistException;
import com.stackroute.passenger.exception.IdNotFoundException;
import com.stackroute.passenger.model.Passenger;
import com.stackroute.passenger.repo.PassengerRepo;

public class PassengerServiceTest {
	
	@Mock
	PassengerRepo repo;
	
	@InjectMocks
	PassengerServiceImpl pservice;
	
	
	Passenger passenger=new Passenger();
	
	List<Passenger> passengers=new ArrayList<Passenger>();
	
	
	@BeforeEach
	
	public void init()
	{
		MockitoAnnotations.openMocks(this);
		passenger.setPassengerId(10);
		passenger.setAge(30);
		passenger.setCountry("India");
		passenger.setPassname("Vikash");
		passenger.setTrainName("Sahapti");
		passenger.setDateofjourney(LocalDate.now());
		Passenger passenger1=new Passenger();
		
		passenger1.setPassengerId(20);
		passenger1.setAge(30);
		passenger1.setCountry("India");
		passenger1.setPassname("Ravi");
		passenger1.setTrainName("Sahapti");
		passenger1.setDateofjourney(LocalDate.now());
		
		passengers.add(passenger);
		passengers.add(passenger1);

		
	}

	
	//positive test case
	@Test
	public void whenaddthenSuccess() throws IdAlreadyExistException
	{
		
		when(repo.save(passenger)).thenReturn(passenger);
		
		
		Passenger resultobj=pservice.addPassenger(passenger);
		
		assertEquals("Vikash",resultobj.getPassname());
		
		verify(repo,times(1)).save(passenger);
		
	}
	//negative test case
	@Test
	public void whenaddthenFail() throws IdAlreadyExistException
	{
		when (repo.findById(10)).thenReturn(Optional.of(passenger));
		
		
		//Passenger resultobj=pservice.addPassenger(passenger);

	Exception excep=assertThrows(IdAlreadyExistException.class, ()->pservice.addPassenger(passenger));
		
		assertEquals("duplicate id",excep.getMessage());
		verify(repo,times(0)).save(passenger);
	}
	
	@Test
	public void whenviewthenreturnall()
	{
	 when(repo.findAll()).thenReturn(passengers);	
	 
	 	List<Passenger> resultlist=pservice.getAllPassengers();
	 	
	 	assertEquals(2,resultlist.size());
	 
		
	}
	
	@Test
	
	public void whendeletethensuccess() throws IdNotFoundException
	{
		when(repo.findById(passenger.getPassengerId())).thenReturn(Optional.of(passenger));
		
		boolean result=pservice.deletePassenger(passenger.getPassengerId());
		assertTrue(result);
		
		
	}
	
	
@Test
	
	public void whendeletethenfail() throws IdNotFoundException
	{
		when(repo.findById(any())).thenReturn(Optional.empty());
		
		
		
Exception excep=assertThrows(IdNotFoundException.class, ()->pservice.deletePassenger(passenger.getPassengerId()));
		
		assertEquals("invalid id",excep.getMessage());
	//	verify(repo,times(0)).deleteById(10);
		
		
	}
	
	
	
}
