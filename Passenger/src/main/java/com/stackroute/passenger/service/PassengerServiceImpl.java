package com.stackroute.passenger.service;

import java.time.LocalDate;
import org.springframework.cache.annotation.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.stackroute.passenger.exception.IdAlreadyExistException;
import com.stackroute.passenger.exception.IdNotFoundException;
import com.stackroute.passenger.model.Passenger;
import com.stackroute.passenger.repo.PassengerRepo;
@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	PassengerRepo repo ;
	
 
	@Override
	public Passenger addPassenger(Passenger pass) throws IdAlreadyExistException {
		
		
		Optional<Passenger> passexist=	repo.findById(pass.getPassengerId());
		if (passexist.isPresent())
			throw new IdAlreadyExistException("duplicate id");
		
		return repo.save(pass);
		 
	}
    

	@Override
	public Passenger updatedPassenger(Passenger pass) throws IdNotFoundException {
		
		Optional<Passenger> passexist=	repo.findById(pass.getPassengerId());
		if (passexist.isEmpty())
			throw new IdNotFoundException("invalid id");
		
		return repo.save(pass);
	}


	@Override
   
	public List<Passenger> getAllPassengers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

   

	@Override
	public boolean deletePassenger(int id) throws IdNotFoundException {
		
		Optional<Passenger> passexist=	repo.findById(id);
		if (passexist.isEmpty())
			throw new IdNotFoundException("invalid id");
		
		repo.deleteById(id);
		return  true;
	}

	@Override
	public List<Passenger> findByTrainNameDOJ(String tname, LocalDate doj) {
		// TODO Auto-generated method stub
		return repo.findByTrainNameAndDateofjourney(tname, doj);
	}

	@Override
	public List<Passenger> findByCountry(String country) {
		// TODO Auto-generated method stub
		return repo.getByCountry(country);
	}

}
