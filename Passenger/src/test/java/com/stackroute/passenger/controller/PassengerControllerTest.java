package com.stackroute.passenger.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.passenger.exception.IdAlreadyExistException;
import com.stackroute.passenger.exception.IdNotFoundException;
import com.stackroute.passenger.model.Passenger;
import com.stackroute.passenger.service.PassengerService;

@AutoConfigureMockMvc
@SpringBootTest
public class PassengerControllerTest {

	@Mock
	PassengerService pservice;
	
	
	@InjectMocks
	PassengerController pcontroller;
	
	
Passenger passenger=new Passenger();
	
	List<Passenger> passengers=new ArrayList<Passenger>();
	
	
	MockMvc mockmvc;
	
	@BeforeEach
	public void init()
	{
		MockitoAnnotations.openMocks(this);
		mockmvc=MockMvcBuilders.standaloneSetup(pcontroller).build();
		passenger.setPassengerId(10);
		passenger.setAge(30);
		passenger.setCountry("India");
		passenger.setPassname("Vikash");
		passenger.setTrainName("Sahapti");
	//	passenger.setDateofjourney(LocalDate.now());
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
	
	
	@Test
	public void whenaddthensuccess() throws JsonProcessingException, Exception
	{
		//stubbing
		when(pservice.addPassenger(passenger)).thenReturn(passenger);
		
		
		mockmvc.perform(MockMvcRequestBuilders.post("/passenger/admin/add")
										.contentType(MediaType.APPLICATION_JSON)
										.content(convertObject(passenger)))
						.andExpect(MockMvcResultMatchers.status().isCreated());
								
		}
	
	public String convertObject(Object obj) throws JsonProcessingException
	{
		ObjectMapper  objmapper=new ObjectMapper();
	return	objmapper.writeValueAsString(obj);
	}
	
	@Test
	public void whenaddthenexception() throws JsonProcessingException, Exception
	{
		
when(pservice.addPassenger(any())).thenThrow(IdAlreadyExistException.class);
		
		
		mockmvc.perform(MockMvcRequestBuilders.post("/passenger/admin/add")
										.contentType(MediaType.APPLICATION_JSON)
										.content(convertObject(passenger)))
						.andExpect(MockMvcResultMatchers.status().isConflict());
							
	}
	
	
	@Test
	public void whendeletethensuccess() throws Exception 
	{
		when(pservice.deletePassenger(10)).thenReturn(true);
		
		mockmvc.perform(MockMvcRequestBuilders.delete("/passenger/admin/delete/10"))
			.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	
	@Test
	public void whendeletethenfailed() throws Exception 
	{
		when(pservice.deletePassenger(anyInt())).thenThrow(IdNotFoundException.class);
		
		mockmvc.perform(MockMvcRequestBuilders.delete("/passenger/admin/delete/10"))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
		
	}
	
}
