package com.stackroute.passenger.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.passenger.model.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger,Integer>{
	
 List<Passenger> findByTrainNameAndDateofjourney(String tname,LocalDate doj);
 
 
 @Query("select pass from Passenger pass where country=?1")
 List<Passenger> getByCountry(String country);
 
 
 
}
