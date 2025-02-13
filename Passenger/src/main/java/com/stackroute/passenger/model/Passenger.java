package com.stackroute.passenger.model;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.stackroute.passenger.validations.Country;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Passenger {

	
	@Id
	int passengerId;
	@Column(nullable=false)
	String passname;
	@Min(1)
	int age;
//	@NotEmpty(message="Date of jounery can not be null")
   @JsonDeserialize
	LocalDate dateofjourney;
	//@Pattern(regexp="(Sahapti|Brindavan)",message="Train name should be exith sahapti or Brindavan")
	String trainName;
	
	//@Country(message="Country should be either india or bldesh")
	String country;
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassname() {
		return passname;
	}
	public void setPassname(String passname) {
		this.passname = passname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getDateofjourney() {
		return dateofjourney;
	}
	public void setDateofjourney(LocalDate dateofjourney) {
		this.dateofjourney = LocalDate.now();
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passname=" + passname + ", age=" + age + ", dateofjourney="
				+ dateofjourney + ", trainName=" + trainName + ", country=" + country + "]";
	}
}
