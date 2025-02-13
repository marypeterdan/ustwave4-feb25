package com.stackroute.passenger.service;

import java.time.LocalDate;
import java.util.List;

import com.stackroute.passenger.exception.IdAlreadyExistException;
import com.stackroute.passenger.exception.IdNotFoundException;
import com.stackroute.passenger.model.Passenger;

public interface PassengerService {
  
	Passenger addPassenger(Passenger pass) throws IdAlreadyExistException;
	Passenger updatedPassenger(Passenger pass) throws IdNotFoundException;
	List<Passenger> getAllPassengers();
	boolean deletePassenger(int id) throws IdNotFoundException;
	List<Passenger> findByTrainNameDOJ(String tname,LocalDate doj);
	List<Passenger> findByCountry(String country);
	
	
}
